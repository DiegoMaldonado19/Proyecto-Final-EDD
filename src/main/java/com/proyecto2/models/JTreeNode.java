/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.models;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author ACER
 */
public class JTreeNode extends DefaultMutableTreeNode{
    private Table table;

    public JTreeNode(Table table) {
        this.table = table;
    }

    public Table getValor() {
        return this.table;
    }

    @Override
    public String toString() {
        return this.table.toString(); // Representación en texto del nodo
    }
}
