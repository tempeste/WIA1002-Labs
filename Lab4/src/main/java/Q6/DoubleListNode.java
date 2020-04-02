/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

/**
 *
 * @author RAVEN
 */
public class DoubleListNode<T> {
    T data;
    DoubleListNode previous;
    DoubleListNode next;
    
    public DoubleListNode(){
        data = null;
        previous = null;
        next = null;
    }
    
    public DoubleListNode(T data, DoubleListNode previous, DoubleListNode next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public DoubleListNode getPrevious() {
        return previous;
    }

    public DoubleListNode getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPrevious(DoubleListNode previous) {
        this.previous = previous;
    }

    public void setNext(DoubleListNode next) {
        this.next = next;
    }
    
    public void setLink(DoubleListNode previous, DoubleListNode next){
        this.previous = previous;
        this.next = next;
    }

    @Override
    public String toString() {
        return " <-- " + data+ " --> " ;
    }
    
    
}
