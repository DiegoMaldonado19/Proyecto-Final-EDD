/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.models;

/**
 *
 * @author CARIadmin
 */
public class Param {
    private String tag;
    private String type;

    public Param(String tag, String type) {
        this.tag = tag;
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Parametro: " + " Tag = " + tag + ", tipo de dato = " + type;
    }
}
