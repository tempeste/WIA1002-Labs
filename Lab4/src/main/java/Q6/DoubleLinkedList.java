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
public class DoubleLinkedList<T> {
    private DoubleListNode head;
    
    public DoubleLinkedList(){
        head = null;
    }
    
    public void clear(){
        head = null;
    }
    
    public int length(){
        DoubleListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    public boolean isEmpty(){
        return head == null;
    }
    
    public void showList(){
        DoubleListNode current = head;
        while(current.getNext() != null){
            System.out.print(current);
            current = current.getNext();
        }
    }
    
    public void addNode(T a){
        DoubleListNode current = head;
        
        if(head == null){
            head = new DoubleListNode(a, null, null);
        }else{
            while(current.getNext() != null){
                current = current.getNext();
            }
            DoubleListNode newNode = new DoubleListNode(a, current, null);
            current.setNext(newNode);
        }
        
    }
    
    public void addFrontNode(T a){
        DoubleListNode temp = head;
        head = new DoubleListNode(a, null, head);
        temp.setPrevious(head);        
    }
    
    public void deleteNode(){
        if (head == null){
            System.out.println("List is empty");
        }else{
            if(head.getNext() == null){
                head = null;
            }else{
                DoubleListNode current = head;
                DoubleListNode previous = head;
                while(current.getNext() != null){
                    previous = current;
                    current = current.getNext();
                }
                current.setLink(null, null);
                previous.setNext(null);
            }
        }
        
    }
    
    public void deleteFrontNode(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            DoubleListNode temp = head.getNext();
            head.setLink(null, null);
            head = temp;
            head.setPrevious(null);
        }
    }
    
    public void addNode(int index, T a){
        if(index == 0){
            addFrontNode(a);
        }else if(index == length()){
            addNode(a);
        }else if(index > length()){
            System.out.println("Invalid index.");
        }else{
            DoubleListNode newNode = new DoubleListNode(a, null, null);
            DoubleListNode current = head;
            for(int i = 1; i < index; i++){
                current = current.getNext();
            }
            newNode.setLink(current, current.getNext());
            current.setNext(newNode);
        }
    }
    
    public void deleteNode(int index){
        if(index == 0){
            deleteFrontNode();
        }else if(index == length()-1){
            deleteNode();
        }else if(index >= length()){
            System.out.println("Invalid index");
        }else{
            DoubleListNode current = head;
            for(int i = 1; i < index; i++){
                current = current.getNext();
            }
            DoubleListNode deleted = current.getNext();
            current.setNext(deleted.getNext());
            deleted.getNext().setPrevious(current);
            deleted.setLink(null, null);
        }
    }
    
    public String toString(){
        String temp = "";
        DoubleListNode current = head;
        while(current != null){
            temp += current.toString();
            current = current.getNext();
        }
        return temp;
    }
    
    public T get(int index){
        if(index >= length()){
            System.out.println("Invalid index");
        }
        DoubleListNode current = head;
        for(int i = 0; i< index; i++){
            current = current.getNext();
        }
        return (T) current.getData();
    }
}
