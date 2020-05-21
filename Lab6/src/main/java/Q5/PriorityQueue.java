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
public class PriorityQueue<T extends Comparable> {
    private ListNode<T> head;
    
    public PriorityQueue(){
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
    //modified enqueue for PriorityQueue
    public void enqueue(T a){
        ListNode<T> temp = new ListNode<>(a, null);
        ListNode previous = head;
        ListNode current = head;
        if(head == null){
            head = temp;
        }else{
            if(head.compareTo(temp) < 0){ //special case for head, because 
                //otherwise, temp -> head -> temp again
                temp.setLink(head);
                head = temp;
            }else{
                while(current != null && current.compareTo(temp) >= 0){
                    previous = current;
                    current = current.getLink();
                }
                previous.setLink(temp);
                temp.setLink(current);
            }
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
