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
public class Stack<T> {
    private ListNode<T> head;
    
    public Stack(){
        head = null;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public int getSize(){
        int counter = 0;
        ListNode temp = head;
        while(temp != null)
        {
            counter += 1; 
            temp = temp.getLink();
        }
        return counter;
    }
    
    public void push(T a){
        head = new ListNode<T>(a, head);
    }
    
    public T pop()
    {
        if (head == null){
            return null;
        }else{
            ListNode temp = head;
            head = head.getLink();
            return (T) temp.getData();
        }
    }
    
    public T peek(){
        return (T) head.getData();
    }
    
    public String toString(){
        String temp = "";
        ListNode tempN = head;
        while(tempN != null){
            temp += tempN;
            tempN = tempN.getLink();
        }
        return temp +"\n";
    }
    
    public void showStack(){
        String temp = "";
        ListNode tempN = head;
        while(tempN != null){
            temp += tempN;
            tempN = tempN.getLink();
        }
        System.out.println(temp); 
    }
}
