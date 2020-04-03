/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

/**
 *
 * @author RAVEN
 */
public class CircularLinkedList<T> {
    public ListNode head;
    public ListNode tail;
    
    public CircularLinkedList(){
        head = null;
        tail  = null;
    }
    
    public int length(){
        if(head == null){
            return 0;
        }else if(head.getLink() == head){
            return 1;
        }else{
            ListNode current = head;
            int count = 0;
            while(current.getLink() != head){
                current = current.getLink();
                count += 1;
            }
            count++;
            return count;
        }
    }
    
    public void clear(){
        head = null;
    }
    
    public void addCircularNode(T a){
        ListNode newNode = new ListNode(a, null);
        if(head == null){
            head = newNode;
        }else{
//            if(head.getLink() == head){
//                head.setLink(newNode);
//                tail = newNode;               //trying out another way of doing it(not necessary)
//            }else{
                tail.setLink(newNode);
            //}
        }
        tail = newNode;
        tail.setLink(head);
    }
    
    public void deleteCircularNode(){
        if(head == null){
            System.out.println("list is empty. Update failed");
        }else{
            ListNode current = head;
            if(head.getLink() == head){
                head = null;
                tail = null;
            }else{
                ListNode previous = head;
                while(current != tail){
                    previous = current;
                    current = current.getLink();
                }
                current.setLink(null);
                tail = previous;
                tail.setLink(head);
                
            }
        }
    }
    
    public void showCircularList(){
        ListNode current = head;
        while(current != tail){
            System.out.print(current);
            current = current.getLink();
        }
        if(head == null){
            System.out.println();
        }else if(tail == head){
            System.out.print(head + ""+ head + "\n");
        }else{
            System.out.print("" + tail + head + "\n");
        }
        
    }
    
    public String toString(){
        ListNode current = head;
        String temp = "";
        while(current != tail){
            temp += current;
            current = current.getLink();
        }
        
        if(head == null){
            return "";
        }else if(tail == head){
            temp += head;
            temp += head;

        }else{
            temp += tail + "" + head;
        }
        return temp;
    }
    
    public T get(int index){
        if(index == 0){
            return (T) head.getData();
        }else if(index == length()-1){
            return (T) tail.getData();
        }else if(index >= length()){
            System.out.println("Invalid index");
            return null;
        }else{
            ListNode current = head;
            for(int i = 0; i < index; i++){
                current = current.getLink();
            }
            return (T) current.getData();
        }
    }
}
