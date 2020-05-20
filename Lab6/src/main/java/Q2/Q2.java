/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q2 {
    public static void main(String[] args) {
        String items = "";
        try{
            Scanner sc = new Scanner(new FileInputStream("Lab6Q2.txt"));
            items = sc.nextLine();
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
        String[] arr = items.split("P0");
        HashMap<String, Queue<String>> map = new HashMap<>();
        Queue<String> codes = new Queue<>();
        for(int i = 1; i < arr.length; i++){//i from 1 because of empty first string
            String[] temp = arr[i].split(" ");
            //System.out.println(Arrays.toString(temp)); for testing
            String code = "P0"+ temp[0];
            if(map.containsKey(code)){
                Queue tempQueue = map.get(code);
                tempQueue.enqueue(temp[1]);
            }else{
                codes.enqueue(code);
                Queue<String> tempQueue = new Queue<String>();
                tempQueue.enqueue(temp[1]);
                map.put(code, tempQueue);
            }
        }
        
        System.out.println("Product Code in Queue: " + codes);
        System.out.println("List of product by categories");
        while(!codes.isEmpty()){
            String code = codes.dequeue();
            Queue temp = map.get(code);
            System.out.println("Product: "+code);
            temp.showQueue();
        }
    }
}
