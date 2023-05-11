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
public class TableCreator {
    private DoublyLinkedList tableList;
    
    public void create(Param parameter){
        tableList = new DoublyLinkedList();
        this.tableList.insert(parameter);
    }
}
