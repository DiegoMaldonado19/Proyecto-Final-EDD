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
public class ParamLinkedList {

    private ParamLinkedNode head;

    public void insert(Param data) {
        ParamLinkedNode new_ParamLinkedNode = new ParamLinkedNode(data);

        ParamLinkedNode temp = head;

        new_ParamLinkedNode.setNext(null);

        if (head == null) {
            new_ParamLinkedNode.setPrev(null);
            head = new_ParamLinkedNode;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(new_ParamLinkedNode);

        new_ParamLinkedNode.setPrev(temp);
    }

    public ParamLinkedNode deleteNode(Param data) {
        ParamLinkedNode node = this.head;
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
        ParamLinkedNode node = this.head;
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
        ParamLinkedNode node = this.head;
        if (node != null) {
            while (node != null) {
                text.append(node.getData() + "\n");
                node = node.getNext();
            }
        } else {
            System.out.println("Lista vacia");
        }
        System.out.println();
    }

    public String getPrimaryKey() {
        ParamLinkedNode node = this.head;
        if (node != null) {
            while (node != null) {
                if (node.getData().getTag().equals("clave")) {
                    return node.getData().getType();
                } else {
                    node = node.getNext();
                }
            }
        } else {
            System.out.println("Lista vacia");
        }
        return "";
    }

    public void deleteAllNodes() {
        ParamLinkedNode temp = new ParamLinkedNode();

        while (this.head != null) {
            temp = this.head;
            this.head = this.head.getNext();
            temp = null;
        }
    }

    public ParamLinkedNode getHead() {
        return head;
    }

    public int countElements() {
        int elements = 0;
        ParamLinkedNode node = this.head;
        if (node != null) {
            while (node != null) {
                elements++;
                node = node.getNext();
            }
        } else {
            return elements;
        }
        return elements;
    }

}
