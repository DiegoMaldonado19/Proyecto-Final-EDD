/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.models;

import com.proyecto2.structures.DoublyLinkedList;

/**
 *
 * @author CARIadmin
 * @param <T>
 */
public class Table<T> {
    private DoublyLinkedList params;
    private T primaryKey;
    private String name;
    /*
    private BPlusTree tree;
    */

    public Table(DoublyLinkedList params, T primaryKey, String name) {
        this.params = params;
        this.primaryKey = primaryKey;
        this.name = name;
    }

    public DoublyLinkedList getParams() {
        return params;
    }

    public void setParams(DoublyLinkedList params) {
        this.params = params;
    }

    public T getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(T primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
