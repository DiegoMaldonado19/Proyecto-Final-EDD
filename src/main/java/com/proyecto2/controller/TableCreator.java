/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.controller;
import com.proyecto2.models.*;
import com.proyecto2.structures.*;
/**
 *
 * @author CARIadmin
 */
public class TableCreator <T> {
    private DoublyLinkedList tableList;
    
    public void create(DoublyLinkedList paramList, int amountOfElements){
        tableList = new DoublyLinkedList();
        
        for(int i=0; i<amountOfElements; i++){
            tableList.insert(createTable(paramList, primaryKey, name, amountOfElements));
        }
        
    }
    
    private Table createTable(DoublyLinkedList params, T primaryKey, String name, int amountOfElements){
        Table table = new Table(params, primaryKey, name, amountOfElements);
        return table;
    }
}
