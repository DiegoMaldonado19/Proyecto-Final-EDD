/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.proyecto2.view;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.proyecto2.files.*;
/**
 *
 * @author ACER
 */
public class MainFrame extends javax.swing.JFrame {
    
    private XMLReader xmlReader;
    private DataFrame dataFrame;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        xmlReader = new XMLReader();
        this.jTextArea1.setEditable(false);
        this.jTextArea1.setText("En esta area de texto verá el contenido del archivo subido al sistema...");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        archiveChargeButton = new javax.swing.JMenu();
        editingTablesButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree2);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        archiveChargeButton.setText("Cargar Archivo");
        archiveChargeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archiveChargeButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(archiveChargeButton);

        editingTablesButton.setText("Editar Tablas");
        editingTablesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editingTablesButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(editingTablesButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archiveChargeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archiveChargeButtonMouseClicked
        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(this);
        this.jTextArea1.setText(" ");
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChosser.getSelectedFile();
            try {
                this.xmlReader.readXMLFile(selectedFile, this.jTextArea1, this);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo");
            }
        }
    }//GEN-LAST:event_archiveChargeButtonMouseClicked

    private void editingTablesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editingTablesButtonMouseClicked
        JOptionPane.showMessageDialog(this, "Evento para enviar a Frame de edicion de tablas");
        this.dataFrame = new DataFrame();
        
        this.dataFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_editingTablesButtonMouseClicked

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archiveChargeButton;
    private javax.swing.JMenu editingTablesButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTree jTree2;
    // End of variables declaration//GEN-END:variables
}
