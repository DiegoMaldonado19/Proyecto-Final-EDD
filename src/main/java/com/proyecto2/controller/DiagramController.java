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

    public void createGraph(Graph graph, TableLinkedList tableList) {
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
            rt.exec("dot -Tpng -O graph.dot");
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

        /*
        String primaryKey = String.valueOf(node.getData().getPrimaryKey());
         */
        while (node != null) {
            if (node.getNext() == null) {
                etiquette = etiquette.concat(node.getData().getName() + ";\n");
            } else {
                etiquette = etiquette.concat(node.getData().getName() + ";");
            }
            node = node.getNext();
        }

        node = tableList.getHead();

        etiquette = etiquette.concat("node[shape=ellipse]; ");
        while (node != null) {
            ParamLinkedNode paramNode = node.getData().getParams().getHead();
            while (paramNode != null) {
                if (paramNode.getNext() == null) {
                    if (paramNode.getData().getTag().equals("clave")) {

                    } else {
                        etiquette = etiquette.concat(paramNode.getData().getTag() + ";\n");
                    }
                } else {
                    if (paramNode.getData().getTag().equals("clave")) {

                    } else {
                        etiquette = etiquette.concat(paramNode.getData().getTag() + ";");
                    }
                }
                paramNode = paramNode.getNext();
            }

            node = node.getNext();
        }

        node = tableList.getHead();

        while (node != null) {
            ParamLinkedNode paramNode = node.getData().getParams().getHead();
            etiquette = etiquette.concat(node.getData().getName() + " -- " + paramNode.getData().getTag()+" [color=forestgreen];\n");
            while (paramNode != null) {
                if (paramNode.getData().getTag().equals("clave")) {

                } else {
                    if (paramNode.equals(node.getData().getParams().getHead())) {

                    } else {
                        etiquette = etiquette.concat(node.getData().getName() + " -- " + paramNode.getData().getTag() + ";\n");
                    }

                }
                paramNode = paramNode.getNext();
            }

            node = node.getNext();
        }

        for (int i = 0; i < graph.getEdge().length; i++) {
            if (graph.getEdge()[i] != null) {
                etiquette = etiquette.concat(graph.getEdge()[i].getSrc() + " -- " + graph.getEdge()[i].getDest() + ";\n");
            }
        }

        System.out.println(etiquette);

        return etiquette;
    }

}
