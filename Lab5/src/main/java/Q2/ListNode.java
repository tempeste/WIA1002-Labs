/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author RAVEN
 */
public class ListNode<T> {
    private T data;
    private ListNode link;
    
    public ListNode()
    {
        data = null;
        link = null;
    }
    
    public ListNode(T a, ListNode b)
    {
        data = a;
        link = b;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLink(ListNode link) {
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public ListNode getLink() {
        return link;
    }
    
    public String toString()
    {
        return "<-- " + this.data; 
    }
}
