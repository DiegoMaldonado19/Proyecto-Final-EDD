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
    public Table createTable(ParamLinkedList params, String primaryKey, String name, int amountOfElements){
        Table newTable = new Table(params, primaryKey, name, amountOfElements);
        return newTable;
    }
}
