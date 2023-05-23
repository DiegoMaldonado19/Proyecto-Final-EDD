/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

import com.proyecto2.models.*;

/**
 *
 * @author ACER
 */
public class TableLinkedNode {
    private Table table;
    private TableLinkedNode prev;
    private TableLinkedNode next;

    public TableLinkedNode(Table table) {
        this.table = table;
        this.prev = null;
        this.next = null;
    }

    public TableLinkedNode() {
        this.prev = null;
        this.next = null;
    }

    public Table getData() {
        return this.table;
    }

    public void setData(Table table) {
        this.table = table;
    }

    public TableLinkedNode getPrev() {
        return this.prev;
    }

    public void setPrev(TableLinkedNode prev) {
        this.prev = prev;
    }

    public TableLinkedNode getNext() {
        return next;
    }

    public void setNext(TableLinkedNode next) {
        this.next = next;
    }
}
