/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto2.controller;

import com.proyecto2.models.JTreeNode;
import com.proyecto2.structures.ParamLinkedNode;
import com.proyecto2.structures.TableLinkedList;
import com.proyecto2.structures.TableLinkedNode;
import com.proyecto2.view.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author CARIadmin
 */
public class JTreeController {

    public void refreshJTree(MainFrame mainFrame, JTree jTree, TableLinkedList tableList) {
        jTree.setModel(addRecords(tableList));
    }

    private DefaultTreeModel addRecords(TableLinkedList tableList) {
        TableLinkedNode tmp = new TableLinkedNode();
        tmp = tableList.getHead();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Tablas");

        root = createNodes(root, tableList);

        DefaultTreeModel treeModel = new DefaultTreeModel(root);

        return treeModel;
    }

    private DefaultMutableTreeNode createNodes(DefaultMutableTreeNode root, TableLinkedList tableList) {
        DefaultMutableTreeNode table = null;
        DefaultMutableTreeNode param = null;

        TableLinkedNode node = tableList.getHead();

        while (node != null) {
            ParamLinkedNode paramNode = node.getData().getParams().getHead();

            table = new DefaultMutableTreeNode(node.getData().getName());
            
            root.add(table);

            if (paramNode != null) {

                while (paramNode != null) {
                    param = new DefaultMutableTreeNode(paramNode.getData().getTag());
                    table.add(param);
                    paramNode = paramNode.getNext();
                }
            }
            node = node.getNext();
        }

        return root;
    }
}
