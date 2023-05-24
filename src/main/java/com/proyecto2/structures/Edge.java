/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

/**
 *
 * @author CARIadmin
 */
public class Edge {
    String src, dest;

    public Edge(String src, String dest) {
        this.src = src;
        this.dest = dest;
    }

    public Edge() {
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
    
     @Override
    public String toString() {
        return "Edge{" + "src=" + src + ", dest=" + dest + '}';
    }
}
