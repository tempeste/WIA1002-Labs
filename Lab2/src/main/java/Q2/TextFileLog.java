/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;


/**
 *
 * @author RAVEN
 */
public class TextFileLog<T> implements SimpleLog<T>{
    private ArrayList<T> store;
    private int maxSize;
    TextFileLog(int a){
        
        maxSize = a;        
        try{
            PrintWriter write = new PrintWriter(new FileOutputStream("log.txt"));
            System.out.println("Create a text file log with maximum record equal to " + maxSize);
            store = new ArrayList<>(5);
            write.close();
        }catch(IOException e){
            System.out.println("Problem with file output");
        }
    }
    
   
    public void insert(T t){
        
        if (store.size() < maxSize){
            store.add(t);
        }else{
            System.out.println("Adding another record");
            System.out.println("The log is full");
            return;
        }
        try{
            PrintWriter write = new PrintWriter(new FileOutputStream("log.txt", false));
            write.println(t);
        }catch(IOException e){
            System.out.println("Problem with file output");
        }
    }
    public boolean isFull(){
        if(store.size() == maxSize){
            System.out.println("The log is full");
        }else{
            System.out.println("The log is not full");
        }
        return false;
    }
    public int size(){
        System.out.println("Text File Log Size " + store.size());
        return store.size();
    }
    public boolean search(T t){
        System.out.println("Searching for " + t + " in the file");
        if(store.contains(t)){
            System.out.println("Text File Log contains " + t);
            return true;
        }else{
            System.out.println("Text File Log does not contain " + t);
            return false;
        }
    }
    public void delete(){
        System.out.println("Clearing the text file log");
        store.removeAll(store);
        try{
            PrintWriter write = new PrintWriter(new FileOutputStream("log.txt"));
        }catch(IOException e){
            System.out.println("Problem with file output");
        }
    }
    public void display(){
        for(int i = 0; i < store.size(); i++){
            System.out.println(store.get(i));
        }
    }
}
