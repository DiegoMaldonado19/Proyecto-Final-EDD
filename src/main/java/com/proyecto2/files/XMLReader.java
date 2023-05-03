/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.files;

import com.proyecto2.view.MainFrame;
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

    /*
      public void readXMLFile(File archive, JTextArea text, MainFrame mainFrame) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(archive);
        BufferedReader br = new BufferedReader(fr);
   
        String linea;
    
        while((linea = br.readLine()) != null){
            text.append(linea+"\n");
        }
        
        JOptionPane.showMessageDialog(mainFrame, "Archivo cargado con exito");
        
        fr.close();
    }
     */
    public void readXMLFile(File archive, JTextArea text, MainFrame mainFrame) throws FileNotFoundException, IOException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archive);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("reporte");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    
                    NodeList fields = element.getChildNodes();

                    for (int j = 0; j < fields.getLength(); j++) {

                        Node field = fields.item(j);

                        if (field.getNodeType() == Node.ELEMENT_NODE) {

                            Element fieldElement = (Element) field;

                            String fieldName = fieldElement.getTagName();
                            String fieldType = fieldElement.getTextContent();

                            text.append(fieldName + ": " + fieldType + "\n");
                        }
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            JOptionPane.showMessageDialog(mainFrame, e.getMessage());
        }
    }
}
