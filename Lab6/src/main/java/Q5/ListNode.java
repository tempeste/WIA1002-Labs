/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;



/**
 *
 * @author RAVEN
 */
public class ListNode<T extends Comparable> {
    private T data;
    private ListNode link;

    public ListNode() {
        data = null;
        link = null;
    }

    public ListNode(T data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public ListNode getLink() {
        return link;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLink(ListNode link) {
        this.link = link;
    }
    //modified toString to fit example
    public String toString(){
        return data + "\n";
    }
    
    public int compareTo(ListNode a){
        return data.compareTo(a.getData());
    }
}
