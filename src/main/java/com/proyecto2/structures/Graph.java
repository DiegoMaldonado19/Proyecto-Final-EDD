/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

/**
 *
 * @author CARIadmin
 */
public class Graph {

    private int vertices, edges;

    private Edge[] edge;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;

        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {

            edge[i] = new Edge();
        }
    }

    public Graph() {
    }
    

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public Edge[] getEdge() {
        return edge;
    }

    public void setEdge(Edge[] edge) {
        this.edge = edge;
    }
}
