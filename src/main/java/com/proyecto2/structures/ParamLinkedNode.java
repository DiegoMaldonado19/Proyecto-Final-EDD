/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

import com.proyecto2.models.*;

/**
 *
 * @author ACER
 */
public class ParamLinkedNode {

    private Param param;
    private ParamLinkedNode prev;
    private ParamLinkedNode next;

    public ParamLinkedNode(Param param) {
        this.param = param;
        this.prev = null;
        this.next = null;
    }

    public ParamLinkedNode() {
        this.prev = null;
        this.next = null;
    }

    public Param getData() {
        return this.param;
    }

    public void setData(Param param) {
        this.param = param;
    }

    public ParamLinkedNode getPrev() {
        return this.prev;
    }

    public void setPrev(ParamLinkedNode prev) {
        this.prev = prev;
    }

    public ParamLinkedNode getNext() {
        return next;
    }

    public void setNext(ParamLinkedNode next) {
        this.next = next;
    }
}
