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
public class LinkedList<T extends Comparable<T>> {
    private ListNode head;
    
    public LinkedList(){
        head = null;
    }
    
    public int length(){
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.getLink();
        }
        return count;
    }
    
    public void clear(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
     public void showList(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.toString());
            current = current.getLink();
        }
    }
     
    public void addNode(T a){
        ListNode<T> newNode = new ListNode<T>(a, null);
        if(head == null){
            head = newNode;
        }else{
            ListNode current = head;
            while(current.getLink() != null){
                current = current.getLink();
            }
            current.setLink(newNode);
        }
    }
    
    public void deleteNode(){
       ListNode current = head;
       ListNode previous = head;
       if(head == null){
           System.out.println("List is empty. No changes made.");
       }else{
           while (current.getLink() != null){
               previous = current;
               current = current.getLink();
           }
           previous.setLink(null);
       }
    }
    
    public void addFrontNode(T a){
        ListNode newNode = new ListNode(a, null);
        newNode.setLink(head);
        head = newNode;
    }
    
    public void deleteFrontNode(){
        if(head == null){
            System.out.println("The list is empty.");
        }else{
            ListNode temp = head.getLink();
            head.setLink(null);
            head = temp;
        }
    }
    
    public boolean contains(T a){
        ListNode current = head;
        while(current != null){
            if(a.compareTo( (T) current.getData()) == 0){
                return true;
            }
            current = current.getLink();
        }
        return false;
    }
    
    public void addNode(int index, T a){
        int length = this.length();
        if(index == 0){
            addFrontNode(a);
        }else if(index == length){
            addNode(a);
        }else if(index > length){
            System.out.println("Invalid Index.");
        }else{
            ListNode current = head;
            for(int i = 1; i < length; i++){
                current = current.getLink();
            }
            ListNode newNode = new ListNode<T>(a, current.getLink());
            current.setLink(newNode);
        }
    }
    
    public void deleteNode(int index){
        int length = this.length();
        if(index == 0){
            deleteFrontNode();
        }else if(index == length-1){
            deleteNode();
        }else if (index >= length){
            System.out.println("Invalid index.");
        }else{
            ListNode current = head;
            for(int i = 1; i < length; i ++){
                current = current.getLink();
            }
            ListNode temp = current.getLink().getLink();
            current.getLink().setLink(null);
            current.setLink(temp);
        }
    }
    
    public void setFront(T a){
        if(head != null){
            head.setData(a);
        }else{
            System.out.println("List is empty");
        }
    }
    
    public void setBack(T a){
        ListNode current = head;
        if(head != null){
            while(current.getLink() != null){
                current = current.getLink();
            }
            current.setData(a);
        }else{
            System.out.println("The list is empty, invalid update");
        }
    }
    
    public void set(int index, T a){ //no need to check if head is null because it's already checked in setFront
        if(index == 0){
            setFront(a);
        }else if(index == this.length()-1){
            setBack(a);
        }else if(index >= this.length()){
            System.out.println("Invalid index. No node deleted ");
        }else{
            ListNode current = head;
            for(int i = 0; i < index; i++){
                current = current.getLink();
            }
            current.setData(a);
        }
    }
    
    public String toString(){
        ListNode current = head;
        String temp = "";
        for(int i = 0; i < this.length(); i++){
            temp += current.toString() + "\n";
            current = current.getLink();
        }
        return temp;
    }
    
    public T getFront(){
        if(head != null){
            return (T) head.getData();
            
        }else{
            System.out.println("The list is empty.");
            return null;
        }
    }
    
    public T getBack(){
        if(head != null){
            ListNode<T> current = head;
            while(current.getLink() != null){
                current = current.getLink();
            }
            return current.getData();
        }else{
            System.out.println("The list is empty. Invalid update");
            return null;
        }
    }
    
    public T get(int index){
        if (index == 0){
            return getFront();
        }else if(index == this.length()-1){
            return getBack();
        }else if(index >= this.length()){
            System.out.println("Invalid index.");
            return null;
        }else{
            ListNode current = head;
            for(int i = 0; i < index; i++){
                current= current.getLink();
            }
            return (T) current.getData();
        }
    }
    
}
