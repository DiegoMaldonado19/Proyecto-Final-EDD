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
    private TableLinkedList tableList;
    
    public TableLinkedList create(ParamLinkedList paramList, int amountOfElements, String tableName, int numberOfTables){
        tableList = new TableLinkedList();
        
        for(int i=0; i<numberOfTables; i++){
            tableList.insert(createTable(paramList, paramList.getPrimaryKey(), tableName, amountOfElements));
        }
        
        return tableList;
    }
    
    private Table createTable(ParamLinkedList params, String primaryKey, String name, int amountOfElements){
        Table newTable = new Table(params, primaryKey, name, amountOfElements);
        return newTable;
    }
}
