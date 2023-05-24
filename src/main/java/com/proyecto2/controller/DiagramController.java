/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.controller;

import com.proyecto2.structures.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class DiagramController {

    public void createGraph(String path, Graph graph, TableLinkedList tableList) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("graph.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz(graph, tableList));
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -O " + path + " graph.dot");
            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    private String getCodigoGraphviz(Graph graph, TableLinkedList tableList) {
        return "graph ER {\n"
                + "fontname=\"Helvetica,Arial,sans-serif\""
                + "node [fontname=\"Helvetica,Arial,sans-serif\"]"
                + "edge [fontname=\"Helvetica,Arial,sans-serif\"]"
                + "layout=neato\n"
                + getCodigoInterno(graph, tableList)
                + "label = \"\\n\\nDiagrama Entidad Relación\\ndibujado por Diego Maldonado\";\n"
                + "fontsize=20;\n"
                + "}\n";
    }

    private String getCodigoInterno(Graph graph, TableLinkedList tableList) {
        String etiquette;

        etiquette = "node [shape=box]; ";
        TableLinkedNode node = tableList.getHead();

        while (node != null) {
            if (node.getNext() == null) {
                etiquette.concat(node.getData().getName() + ";\n");
            } else {
                etiquette.concat(node.getData().getName() + ";");
            }
            node = node.getNext();
        }

        etiquette.concat("node[shape = ellipse];");
        while (node != null) {
            ParamLinkedNode paramNode = node.getData().getParams().getHead();
            while (paramNode != null) {
                if (paramNode.getNext() == null) {
                    if (paramNode.getData().getTag().equals("clave")) {
                        etiquette.concat(paramNode.getData().getType() + ";\n");
                    } else {
                        etiquette.concat(paramNode.getData().getTag() + ";\n");
                    }
                } else {
                    if (paramNode.getData().getTag().equals("clave")) {
                        etiquette.concat(paramNode.getData().getType() + ";");
                    } else {
                        etiquette.concat(paramNode.getData().getTag() + ";");
                    }
                }
                paramNode = paramNode.getNext();
            }

            node = node.getNext();
        }

        while (node != null) {
            ParamLinkedNode paramNode = node.getData().getParams().getHead();
            while (paramNode != null) {
                if (paramNode.getData().getTag().equals("clave")) {
                    etiquette.concat(node.getData().getName()+" -- "+paramNode.getData().getType() + ";\n");
                } else {
                    etiquette.concat(node.getData().getName()+" -- "+paramNode.getData().getTag() + ";\n");
                }
                paramNode = paramNode.getNext();
            }

            node = node.getNext();
        }

        return etiquette;
    }

}
