/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

/**
 *
 * @author RAVEN
 */
public class LinkedList<T extends Comparable<T>> {
    public ListNode head;
    
    public LinkedList(){
        head = null;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void clear(){
        head = null;
    }
    
    public int length(){
        ListNode current = head;
        int count = 0;
        while (current != null){
            current = current.getLink();
            count++;
        }
        return count;
    }
    
    public void showList(){
        ListNode current = head;
        while(current != null){
            System.out.println(current.toString());
            current = current.getLink();
        }
    }
    public void addNode(T a){
        ListNode newNode = new ListNode(a, null);
        ListNode current = head;
        if(head == null){
            head = newNode;
        }else{
            while(current.getLink()!=null){
                current = current.getLink();
            }
            current.setLink(newNode);
        }
        
    }
    
    public void deleteNode(){
        if(head == null){
            System.out.println("List is empty. Update failed");
        }else{
            ListNode previous = head;
            ListNode current = head;
            if(current.getLink() == null){
                head = null;
            }else{
                while(current.getLink() != null ){
                    previous = current;
                    current = previous;
                }
                previous.setLink(null);
            }
            
        }
    }
    
    public void addFrontNode(T a){
        if(head == null){
            head = new ListNode(a, null);
        }else{
            head = new ListNode(a, head.getLink());
        }
    }
    
    public void deleteFrontNode(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            ListNode temp = head.getLink();
            head.setLink(null);
            head = temp;
        }
    }
    
    public boolean contains(T a){
        ListNode current = head;
        while(current!= null){
            if(a.compareTo((T) current.getData()) == 0){
                return true;
            }
            current = current.getLink();
        }
        return false;
    }
    
    public void addNode(int index, T a){
        if(index == 0){
            addFrontNode(a);
        }else if(index == this.length()){
            addNode(a);
        }else if(index > this.length()){
            System.out.println("Invalid index. Update failed");
        }else{
            ListNode current = head;
            for(int i = 1; i < index; i++){
                current = current.getLink();
            }
            ListNode temp = new ListNode(a, current.getLink());
            current.setLink(temp);
        }
    }
    
    public void deleteNode(int index){
        if(index == 0){
            deleteFrontNode();
        }else if(index == this.length()-1){
            deleteNode();
        }else if(index >= this.length()){
            System.out.println("Invalid index. Update failed");
        }else{
            ListNode current = head;
            for(int i = 1; i < index; i++){
                current = current.getLink();
            }
            ListNode next = current.getLink();
            current.setLink(next.getLink());
            next.setLink(null);
        }
    }
    
    public void setFront(T a){
        if(head == null){
            System.out.println("List is empty");
        }else{
            head.setData(a);
        }
    }
    
    public void setBack(T a){
        if(head == null){
            System.out.println("List is empty");
        }else{
            ListNode current = head;
            while(current.getLink() != null){
                current = current.getLink();
            }
            current.setData(a);
        }
    }
    
    public void set(int index, T a){
        if(index == 0){
            setFront(a);
        }else if(index == this.length()-1){
            setBack(a);
        }else if(index >= this.length()){
            System.out.println("Invalid index.");
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
            temp += current.toString();
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
