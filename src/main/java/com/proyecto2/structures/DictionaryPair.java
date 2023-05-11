/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.structures;

/**
 *
 * @author CARIadmin
 * @param <T>
 */
public class DictionaryPair<T> implements Comparable<DictionaryPair> {

    int key;
    T value;

    /**
     * Constructor
     *
     * @param key: the key of the key-value pair
     * @param value
     */
    public DictionaryPair(int key, T value) {
        this.key = key;
        this.value = value;
    }

    /**
     * This is a method that allows comparisons to take place between
     * DictionaryPair objects in order to sort them later on
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(DictionaryPair o) {
        if (key == o.key) {
            return 0;
        } else if (key > o.key) {
            return 1;
        } else {
            return -1;
        }
    }
}
