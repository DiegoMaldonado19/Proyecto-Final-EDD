/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.controller;

import com.proyecto2.structures.*;

/**
 *
 * @author ACER
 */
public class InsertionController<T> {

    public TableLinkedList insertData(TableLinkedList tableList, ParamLinkedList paramList) {
        
        int cont = 0;

        TableLinkedNode node = tableList.getHead();

        while (node != null) {
            if (node.getData().getName().equals(paramList.getHead().getData().getTag())) {
                break;
            }
            node = node.getNext();
        }

        ParamLinkedNode paramNode = paramList.getHead();

        while (paramNode != null) {

            if (paramNode.equals(paramList.getHead())) {

            } else {

            }

            paramNode = paramNode.getNext();
        }

        T value = traverseLists(node.getData().getParams(), paramList);
        
        while(cont<=tableList.countElements()){
            tableList.getHead().getData().getTree().insert(0, value);
            cont++;
        }

        return tableList;
    }

    private T traverseLists(ParamLinkedList tableParams, ParamLinkedList insertionParams) {
        T value;
        String insertionParam = "";
        ParamLinkedNode insertionNode = insertionParams.getHead().getNext();

        ParamLinkedNode tableParamNode = tableParams.getHead();

        while (insertionNode != null) {
            insertionParam = insertionNode.getData().getTag();
            while (tableParamNode != null) {
                if (tableParamNode.getData().getTag().equals(insertionParam)) {

                    break;
                }
                tableParamNode = tableParamNode.getNext();
            }

            insertionNode = insertionNode.getNext();
        }

        value = castValue(insertionNode.getData().getType(), tableParamNode.getData().getType());

        return value;
    }

    private T castValue(String value, String type) {
        
        T valueT;

        switch (type) {
            case "int":
                    valueT = (T)Integer.valueOf(value);
                break;

            case "String":
                    valueT = (T)value;
                break;

            case "double":
                    valueT = (T)Double.valueOf(value);
                break;

            case "char":
                    valueT = (T)value.toCharArray();
                break;

            case "byte":
                    valueT = (T)Byte.valueOf(value);
                break;

            case "short":
                    valueT = (T)Short.valueOf(value);
                break;

            case "long":
                    valueT = (T)Long.valueOf(value);
                break;

            case "float":
                    valueT = (T)Float.valueOf(value);
                break;

            case "boolean":
                    valueT = (T)Boolean.valueOf(value);
                break;
        }

        return (T)value;
    }

}
