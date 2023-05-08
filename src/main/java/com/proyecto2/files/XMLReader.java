/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.files;

import com.proyecto2.controller.*;
import com.proyecto2.models.*;
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
        tableCreator = new TableCreator();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archive);

            doc.getDocumentElement().normalize();

            NodeList estructuras = doc.getElementsByTagName("estructura");

            traverseNodeList(estructuras, text, mainFrame);

        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
        }
    }

    private void traverseNodeList(NodeList list, JTextArea text, MainFrame mainFrame) {
        for (int i = 0; i < list.getLength(); i++) {
            Node genericNode = list.item(i);

            if (genericNode.getNodeType() == Node.ELEMENT_NODE) {
                Element genericElement = (Element) genericNode;

                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    NodeList fields = element.getChildNodes();

                    for (int j = 0; j < fields.getLength(); j++) {

                        Node field = fields.item(j);

                        if (field.getNodeType() == Node.ELEMENT_NODE) {

                            Element fieldElement = (Element) field;

                            String fieldName = fieldElement.getTagName();
                            String fieldType = fieldElement.getTextContent();

                            Param parameter = new Param(fieldName, fieldType);

                            tableCreator.create(parameter);

                            text.append(parameter.toString() + "\n");
                        }
                    }
                }
            }
        }
    }
}
