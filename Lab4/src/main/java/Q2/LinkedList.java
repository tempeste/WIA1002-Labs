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
public class LinkedList<T extends Comparable<T>> {
    private ListNode head;
    
    public LinkedList(){
        head = null;
    }
    
    public int length(){
        int count = 0;
        if(head == null){
            return 0;
        }else if(head.getLink() == null){
            return 1;
        }else{
            ListNode current = head;
            while(current != null){
                count ++;
                current = current.getLink();
            }
            return count;
        }
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
        ListNode current = head;
        ListNode<T> newNode = new ListNode<T>(a, null);
        if(current == null){
            head = newNode;
        }else{
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
            System.out.println("List is empty. Update failed");
        }else if(head.getLink() == null){
            head = null;
        }else{
            while(current != null){
                previous = current;
                current = current.getLink();
            }
            
            previous.setLink(null);
        }
    }
    
    public void addFrontNode(T a){
        ListNode newNode = new ListNode<T>(a, head);
        head = newNode;
    }
    
    public void deleteFrontNode(){
        if(head != null){
            if(head.getLink() == null){
                head = null;
            }else{
                head = head.getLink();
            }
        }else{
            System.out.println("The list is empty. Update failed");
        }
    }
    
    public boolean Contains(T a){
        ListNode current = head;
        while(current != null){
            if(a.compareTo((T) current.getData()) == 0){
                return true;
            }
            current = current.getLink();
        }
        
        return false;
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
            System.out.println("The list is empty, invalid update");
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
            temp += current.toString() + " ";
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
    
    //Not the implementation that the question desires, also, there's a bug in which the original linked list is not modified due to the way Java passes reference values
    
//    public LinkedList splitList(){
//        LinkedList<T> second = new LinkedList<T>();
//        int length = this.length();
//        ListNode current = head;
//        if(length %2 == 0){
//            for(int i = 0; i < this.length(); i++){ 
//                if( i >= length/2){
//                    second.addNode((T) current.getData());
//                }
//                current = current.getLink();
//            }
//            
//            
//        }else{
//            for(int i = 0; i < this.length(); i++){
//                if( i > length/2){
//                    second.addNode((T) current.getData());
//                }
//                current = current.getLink();
//            }
//        }
//        
//        if(length%2 == 0){
//            for(int i = 0; i < length/2; i++){
//                deleteNode();
//                System.out.println("Deletion of " + i + "th item" + this.toString());
//            }
//        }else{
//            for(int i = 0; i < length/2 -1; i++){
//                
//                deleteNode();
//                System.out.println("Deletion of " + i + "th item" + this.toString());
//            }
//        }
//        return second;
//    }
    
    public void splitList(LinkedList first, LinkedList second){
        int length = this.length();
        ListNode current = head;
        if(length %2 == 0){
            for(int i = 0; i < this.length(); i++){ 
                if( i >= length/2){
                    second.addNode((T) current.getData());
                }else{
                    first.addNode((T)current.getData());
                }
                current = current.getLink();
            }
            
            
        }else{
            for(int i = 0; i < this.length(); i++){
                if( i > length/2){
                    second.addNode((T) current.getData());
                }else{
                    first.addNode((T)current.getData());
                }
                current = current.getLink();
            }
        }
    }
    
    public void alternateList(LinkedList first , LinkedList second){
        int length = this.length();
        ListNode current = head;
        for(int i = 0; i < length; i++){
            if(i % 2 == 0){
                first.addNode((T)current.getData());
            }else{
                second.addNode((T) current.getData());
            }
            current = current.getLink();
        }
    }
    
    public void mergeList(LinkedList second){
        int length = second.length();

        for(int i = 0, j = 1; i < length; i++, j+= 2){   
            this.addNode(j, (T) second.get(i));
        }
    }
    
    public void reverseList(){
        head = reverse(head);
    }
    
    public ListNode reverse(ListNode node){
        if (node == null){
            return null;
        }
        
        if(node.getLink() == null){
            return node;
        }
        
        ListNode second = node.getLink();
        node.setLink(null);
        
        ListNode reverseOthers = reverse(second);
        second.setLink(node);
        
        return reverseOthers;
        
    }
    
    public ListNode getHead(){
        return head;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    public ListNode reverse(ListNode list){
//        if (list == null) return null; 
//
//        if (list.getLink() == null) return list; 
//
//        ListNode secondElem = list.getLink();
//
//        list.setLink(null);
//
//        ListNode reverseRest = reverse(secondElem);
//
//        secondElem.setLink(list);
//
//        return reverseRest;
//    }
    
    
}
