/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.models;

import com.proyecto2.structures.*;

/**
 *
 * @author CARIadmin
 * @param <T>
 */
public class Table<T> {

    private ParamLinkedList params;
    private T primaryKey;
    private String name;
    private BPlusTree tree;

    public Table(ParamLinkedList params, T primaryKey, String name, int order) {
        this.params = params;
        this.primaryKey = primaryKey;
        this.name = name;
        this.tree = new BPlusTree(order);
    }

    public Table() {
    }

    public ParamLinkedList getParams() {
        return this.params;
    }

    public void setParams(ParamLinkedList params) {
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

    public BPlusTree getTree() {
        return tree;
    }

    public void setTree(BPlusTree tree) {
        this.tree = tree;
    }
}
