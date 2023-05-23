/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

/**
 *
 * @author CARIadmin
 */
public class GenericDoublyLinkedNode<T> {

    private T data;
    private GenericDoublyLinkedNode prev;
    private GenericDoublyLinkedNode next;

    public GenericDoublyLinkedNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public GenericDoublyLinkedNode() {
        this.prev = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericDoublyLinkedNode getPrev() {
        return prev;
    }

    public void setPrev(GenericDoublyLinkedNode prev) {
        this.prev = prev;
    }

    public GenericDoublyLinkedNode getNext() {
        return next;
    }

    public void setNext(GenericDoublyLinkedNode next) {
        this.next = next;
    }

}
