/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

/**
 *
 * @author CARIadmin
 */
public class DoublyLinkedList {

    private DoublyLinkedNode head;

    // insert a newDoublyLinkedNode at the end of the list
    public void insertEnd(int data) {
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

    // delete a DoublyLinkedNode from the doubly linked list
    public void deleteDoublyLinkedNode(DoublyLinkedNode del_DoublyLinkedNode) {

        if (head == null || del_DoublyLinkedNode == null) {
            System.out.println("Lista vacia");
        }

        if (head == del_DoublyLinkedNode) {
            head = del_DoublyLinkedNode.getNext();
        }

        if (del_DoublyLinkedNode.getNext() != null) {
            del_DoublyLinkedNode.getNext().setPrev(del_DoublyLinkedNode.getPrev());
        }

        if (del_DoublyLinkedNode.getPrev() != null) {
            del_DoublyLinkedNode.getPrev().setNext(del_DoublyLinkedNode.getNext());
        }

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
