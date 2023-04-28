/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.files;

import com.proyecto2.view.MainFrame;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author ACER
 */
public class XMLReader {
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
}
