/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author RAVEN
 */
public class ListNode<T> {
    private ListNode link;
    private T data;
    
    public ListNode(){
        this.data = null;
        this.link = null;
    }

    public ListNode(T data, ListNode link) {
        this.link = link;
        this.data = data;
    }

    public ListNode getLink() {
        return link;
    }

    public T getData() {
        return data;
    }

    public void setLink(ListNode link) {
        this.link = link;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public String toString(){
        return data + "--> ";
    }
    
}
