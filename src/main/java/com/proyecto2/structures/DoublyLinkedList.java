/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

/**
 *
 * @author CARIadmin
 */
public class DoublyLinkedList<T> {

    private DoublyLinkedNode head;

    // insert a newDoublyLinkedNode at the end of the list
    public void insert(T data) {
        DoublyLinkedNode new_DoublyLinkedNode = new DoublyLinkedNode(data);

        DoublyLinkedNode temp = head;

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

    public DoublyLinkedNode deleteNode(T data) {
        DoublyLinkedNode node = this.head;
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
        DoublyLinkedNode node = this.head;
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
}
