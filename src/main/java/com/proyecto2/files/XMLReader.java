/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.files;

import com.proyecto2.controller.*;
import com.proyecto2.models.*;
import com.proyecto2.structures.*;
import com.proyecto2.view.*;
import java.io.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ACER
 */
public class XMLReader {

    private TableCreator tableCreator;

    public void readXMLFile(File archive, JTextArea text, MainFrame mainFrame) throws FileNotFoundException, IOException {
        int amountOfElements = 0;
        tableCreator = new TableCreator();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archive);

            doc.getDocumentElement().normalize();

            if (archive.getName().equals("Estructura.xml")) {
                traverseStructureList(doc, text, amountOfElements, tableCreator);
            } else if (archive.getName().equals("reportes.rpt")) {
                traverseReportList(doc, text);
            } else {
                traverseAnyList(doc, text);
            }

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
        }
    }

    private void traverseStructureList(Document doc, JTextArea text, int amountOfElements, TableCreator tableCreator) {
        DoublyLinkedList paramList = new DoublyLinkedList();
        NodeList structures = doc.getElementsByTagName("estructura");

        for (int i = 0; i < structures.getLength(); i++) {
            Node structureNode = structures.item(i);
            if (structureNode.getNodeType() == Node.ELEMENT_NODE) {
                Element structureElement = (Element) structureNode;

                String table = getTextValue(structureElement, "tabla");
                text.append("Tabla: " + table + "\n");

                NodeList fields = structureElement.getChildNodes();
                for (int j = 0; j < fields.getLength(); j++) {
                    Node fieldNode = fields.item(j);
                    if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element fieldElement = (Element) fieldNode;
                        String structureTag = fieldElement.getNodeName();
                        String structureTagContent = fieldElement.getTextContent().trim();
                        if (!structureTag.equals("relacion")) {
                            if (structureTag.equals("tabla")) {
                                amountOfElements = 0;
                                paramList.deleteAllNodes();
                            } else {
                                amountOfElements++;
                                Param parameterPair = new Param(structureTag, structureTagContent);
                                paramList.insert(parameterPair);
                            }
                        }
                    }
                }

                paramList.printlistInTextArea(text);
                
                tableCreator.create(paramList, amountOfElements);
                
                
                NodeList relations = structureElement.getElementsByTagName("relacion");
                for (int k = 0; k < relations.getLength(); k++) {
                    Node relationNode = relations.item(k);
                    if (relationNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element relationElement = (Element) relationNode;

                        NodeList relationFields = relationElement.getElementsByTagName("*");
                        text.append("Relacion: \n");
                        for (int l = 0; l < relationFields.getLength(); l++) {
                            Node relationFieldNode = relationFields.item(l);
                            if (relationFieldNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element relationFieldElement = (Element) relationFieldNode;
                                String relationTag = relationFieldElement.getTagName();
                                String relationTagContent = relationFieldElement.getTextContent().trim();
                                text.append("Nombre Campo: " + relationTag + ", Tipo: " + relationTagContent + "\n");
                            }
                        }
                    }
                }
            }
        }
    }

    private void traverseAnyList(Document doc, JTextArea text) {
        NodeList tags = doc.getElementsByTagName("*");
        text.append("Tabla: " + tags.item(0).getNodeName() + "\n");
        for (int i = 0; i < tags.getLength(); i++) {
            Node tagNode = tags.item(i);
            if (tagNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tagElement = (Element) tagNode;
                NodeList fields = tagElement.getChildNodes();
                for (int j = 0; j < fields.getLength(); j++) {
                    Node fieldNode = fields.item(j);
                    if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element fieldElement = (Element) fieldNode;
                        String anyTag = fieldElement.getNodeName();
                        String anyTagContent = fieldElement.getTextContent().trim();
                        text.append("Nombre Campo: " + anyTag + " , Tipo: " + anyTagContent + "\n");
                    }
                }
            }
        }
    }

    private void traverseReportList(Document doc, JTextArea text) {
        NodeList tags = doc.getElementsByTagName("reporte");
        for (int i = 0; i < tags.getLength(); i++) {
            Node tagNode = tags.item(i);
            if (tagNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tagElement = (Element) tagNode;
                NodeList fields = tagElement.getChildNodes();
                for (int j = 0; j < fields.getLength(); j++) {
                    Node fieldNode = fields.item(j);
                    if (fieldNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element fieldElement = (Element) fieldNode;
                        String anyTag = fieldElement.getNodeName();
                        String anyTagContent = fieldElement.getTextContent().trim();
                        text.append("Nombre Campo: " + anyTag + " , Tipo: " + anyTagContent + "\n");
                    }
                }
            }
        }
    }

    private static String getTextValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Element tagElement = (Element) nodeList.item(0);
            if (tagElement != null) {
                Node textNode = tagElement.getFirstChild();
                if (textNode != null) {
                    return textNode.getNodeValue();
                }
            }
        }
        return "";
    }
}
