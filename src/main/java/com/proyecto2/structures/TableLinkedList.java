/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

import com.proyecto2.models.*;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class TableLinkedList {

    private TableLinkedNode head;

    public void insert(Table data) {
        TableLinkedNode new_TableLinkedNode = new TableLinkedNode(data);

        TableLinkedNode temp = head;

        new_TableLinkedNode.setNext(null);

        if (head == null) {
            new_TableLinkedNode.setPrev(null);
            head = new_TableLinkedNode;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(new_TableLinkedNode);

        new_TableLinkedNode.setPrev(temp);
    }

    public TableLinkedNode deleteNode(Table data) {
        TableLinkedNode node = this.head;
        while (node != null) {
            if (node.getData().equals(data)) {
                if (head == null) {
                    System.out.println("Lista vacia");
                }

                if (head == node) {
                    head = node.getNext();
                }

                if (node.getNext() != null) {
                    node.getNext().setPrev(node.getPrev());
                }

                if (node.getPrev() != null) {
                    node.getPrev().setNext(node.getNext());
                }
            }
            node = node.getNext();
        }
        return null;
    }

    public void printlist() {
        TableLinkedNode node = this.head;
        if (node != null) {
            while (node != null) {
                System.out.print(node.getData() + "->");
                node = node.getNext();
            }
        } else {
            System.out.println("Lista vacia");
        }
        System.out.println();
    }

    public void printlistInTextArea(JTextArea text) {
        TableLinkedNode node = this.head;
        ParamLinkedNode paramNode = node.getData().getParams().getHead();
        if (node != null) {
            text.append("Tabla: " + node.getData().getName() + "\n");
            text.append("Llave Primaria: " + node.getData().getPrimaryKey() + "\n");
            while (node != null) {
                if (paramNode != null) {
                    text.append("Parametros de Tabla: " + node.getData().getName() + "\n");
                    while (paramNode != null) {
                        text.append("Elemento: " + paramNode.getData().getTag() + " , Tipo de Dato: " + paramNode.getData().getType() + "\n");
                        paramNode = paramNode.getNext();
                    }
                }
                node = node.getNext();
            }
        } else {
            System.out.println("Lista vacia");
        }
        System.out.println();
    }

    public void deleteAllNodes() {
        TableLinkedNode temp = new TableLinkedNode();

        while (this.head != null) {
            temp = this.head;
            this.head = this.head.getNext();
            temp = null;
        }
    }
}
