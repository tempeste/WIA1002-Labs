/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author RAVEN
 */
public class LinkedList <T extends Comparable<T>>{
    private ListNode head;
    
    public LinkedList(){
        head = null;
    }
    
    public int length(){
        int count = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }
    
    public void clear(){
        head = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void showList(){
        ListNode currentNode = head;
        while(currentNode != null){
            System.out.println(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }
    
    public void addNode(T a){
        ListNode currentNode = head;
        ListNode newNode = new ListNode<T>(a, null);
        if(currentNode == null){
            head = newNode;
        }else{
            while(currentNode.getLink() != null){
                currentNode = currentNode.getLink();
            }

            currentNode.setLink(newNode);
        }
        
    }
    
    public void deleteNode(){
        ListNode currentNode = head;
        ListNode previousNode = head;    
        if(head != null){
            if(currentNode.getLink() == null){
                head = null;
            }else{
                while(currentNode != null){
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        }else{
            System.out.println("The list is empty");
        }
    }
    
    
    public void addFrontNode(T a){
        ListNode b = new ListNode<T>(a, head);
        head = b;
    }
    
    public void deleteFrontNode(){
        if(head != null){
            head = head.getLink();
        }else{
            System.out.println("The list is empty");
        }
    }
    
    public boolean Contains(T a){
        boolean found = false;
        ListNode current = head;
        while(current != null){
//            if(current.getData().equals(a)){
            if(a.compareTo( (T) current.getData()) == 0){ //note's method
                found = true;
                break;
            }
            current = current.getLink();
        }
        
        return found;
    }
    
     public void addNode(int index, T a){
        ListNode newNode = new ListNode<T>(a, null);
        ListNode current = head;
        if(index == 0){
            addFrontNode(a);
        }else if(index == this.length()){
            addNode(a);
        }else if(index > this.length()){
            System.out.println("Invalid index. No node inserted");
        }else{
            for(int i = 1; i < index; i++){
                current = current.getLink();
            }
            ListNode temp = current.getLink();
            current.setLink(newNode);
            newNode.setLink(temp);
        }
    }
    
    public void deleteNode(int index){
        if(head != null){
            if(index == this.length()){
                deleteNode();
            }else if(index == 0){
                deleteFrontNode();
            }else if(index > this.length()){
                System.out.println("Invalid index. No node deleted ");
            }else{
                ListNode current = head;
                ListNode previous = head;
                for(int i = 1; i < index; i++){
                    previous = current;
                    current = current.getLink();
                }
                ListNode temp = current.getLink();
                previous.setLink(temp);
                current.setLink(null);
            }
           
        }else{
             System.out.println("The list is empty, invalid update");
        }
    }
    
    
    public void setFront(T a){
        if(head != null){
            head.setData(a);
        }else{
            System.out.println("The list is empty. Invalid update");
        }
        
    }
    
    public void setBack(T a){
         if(head != null){
             ListNode current = head;
             while(current.getLink() != null){
                 current = current.getLink();
             }
             current.setData(a);
         }else{
             System.out.println("The list is empty. Invalid update");
         }
    }
    
    public void set(int index, T a){
        if (index == 0){
            setFront(a);
        }else if(index == this.length() -1){
            setBack(a);
        }else if(index >= this.length()){
            System.out.println("Invalid index. Update failed");
        }else{
            ListNode current = head;
            for(int i = 0; i < index; i++){
                current= current.getLink();
            }
            current.setData(a);
        }
    }
    
    @Override
    public String toString(){
        ListNode current = head;
        String temp = "";
        for(int i = 0; i < this.length(); i++){
            temp += current.toString() + " ";
            current = current.getLink();
        }
        return temp;
    }
    
    //Right idea, but wrong implementation because object is passed by reference
//    public void addSortNode(T a){
//        ListNode current = head;
//        ListNode newNode = new ListNode<T>(a, null);
//        if(head == null){
//            addNode(a);
//        }else{
//            int i = 0;
//            for(i = 0; i < this.length(); i++){
//                if(a.compareTo((T) current.getData()) < 0){
//                    break;
//                }
//                current = current.getLink();     
//            }
//            
//            ListNode temp = current;
//            current = newNode;
//        }
//    }
    
    //correct implementation
    public void addSortNode(T a){
        ListNode current = head;
        ListNode previous = head;
        ListNode newNode = new ListNode<T>(a, null);
        if(head == null){
            addNode(a);
        }else if(a.compareTo((T) head.getData()) < 0 ){
            newNode.setLink(head);
            head = newNode;
        }else{
            int i = 0;
            for(i = 0; i < this.length(); i++){
                if(a.compareTo((T) current.getData()) < 0){
                    break;
                }
                previous = current;
                current = current.getLink();     
            }
            
            previous.setLink(newNode);
            newNode.setLink(current);
        }
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
