/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import Q1.*;

/**
 *
 * @author RAVEN
 */
public class BSTNode<T extends Comparable <T>>   {
    private T data;
    private BSTNode left;
    private BSTNode right;
    
    public BSTNode(){
        data = null;
        left = null;
        right = null;
    }
    
    public BSTNode(T data,BSTNode left,BSTNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
    
}
