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
public class GraphCreator {
    
    public Graph createGraph(TableLinkedList tableList, ParamLinkedList relationList){
        Graph newGraph = new Graph(tableList.countElements(), tableList.countElements());
        
        newGraph = makeRelations(newGraph,tableList, relationList);
        
        return newGraph;
    }
    
    private Graph makeRelations(Graph newGraph, TableLinkedList tableList, ParamLinkedList relationList ){
        
        int cont = 0;
        
        ParamLinkedNode paramNode = relationList.getHead();
        
        Edge[] edges = new Edge[tableList.countElements()];
        
        while(paramNode!=null){
            
            if(paramNode.getData().getTag().equals("TableParent")){
                String parentTable = paramNode.getData().getType();
                String childTable = paramNode.getNext().getNext().getData().getTag();
                edges[cont] = new Edge(parentTable, childTable);
                break;
            }
            paramNode = paramNode.getNext();
            cont++;
        }
        
        for(int i=0; i<edges.length; i++){
            if(edges[i]!=null){
                System.out.println("Edge number: "+i+ " "+ edges[i].toString());
            }
        }
        newGraph.setEdge(edges);
        
        return newGraph;
    }
   
}
