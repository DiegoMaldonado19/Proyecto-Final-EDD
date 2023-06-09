/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

import javax.swing.JTextArea;

/**
 *
 * @author CARIadmin
 * @param <T>
 */
public class GenericDoublyLinkedList<T> {

    private GenericDoublyLinkedNode head;

    public void insert(T data) {
        GenericDoublyLinkedNode new_DoublyLinkedNode = new GenericDoublyLinkedNode(data);

        GenericDoublyLinkedNode temp = head;

        new_DoublyLinkedNode.setNext(null);

        if (head == null) {
            new_DoublyLinkedNode.setPrev(null);
            head = new_DoublyLinkedNode;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(new_DoublyLinkedNode);

        new_DoublyLinkedNode.setPrev(temp);
    }

    public GenericDoublyLinkedNode deleteNode(T data) {
        GenericDoublyLinkedNode node = this.head;
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
        GenericDoublyLinkedNode node = this.head;
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
        GenericDoublyLinkedNode node = this.head;
        if (node != null) {
            while (node != null) {
                text.append(node.getData()+"\n");
                node = node.getNext();
            }
        } else {
            System.out.println("Lista vacia");
        }
        System.out.println();
    }

    public void deleteAllNodes() {
        GenericDoublyLinkedNode temp = new GenericDoublyLinkedNode();

        while (this.head != null) {
            temp = this.head;
            this.head = this.head.getNext();
            temp = null;
        }
    }

    public GenericDoublyLinkedNode getHead() {
        return this.head;
    }
    
}
