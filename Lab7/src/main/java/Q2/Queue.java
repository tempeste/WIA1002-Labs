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
public class Queue<T> {
    private ListNode<T> head;
    
    public Queue(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public int getSize(){
        ListNode temp = head;
        int counter = 0;
        while(temp != null){
            counter++;
            temp = temp.getLink();
        }
        return counter;
    }
    
    public void enqueue(T a){
        ListNode<T> temp = new ListNode<>(a, null);
        ListNode current = head;
        if(head == null){
            head = temp;
        }else{
            while(current.getLink() != null){
                current = current.getLink();
            }
            current.setLink(temp);
        }
    }
    
    public T dequeue(){
        if(head == null){
            return null;
        }else{
            T temp = (T) head.getData();
            head = head.getLink();
            return temp;
        }
    }
    
    public T peek(){
        if(head == null){
            return null;
        }else{
            return head.getData();
        }
    }
    
    public void showQueue(){
        if(head == null){
            System.out.println("Queue is empty");
        }else{
            ListNode temp = head;
            while(temp!= null){
                System.out.print(temp);
                temp = temp.getLink();
            }
            System.out.println("");
        }
    }
    
    public String toString(){
        if(head == null){
            return "List is empty";
        }else{
            ListNode temp = head;
            String str = "";
            while(temp!= null){
                str += temp;
                temp = temp.getLink();
            }

            return str;
        }
    }
}
