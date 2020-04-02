/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q6;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author RAVEN
 */
public class Q6 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10];
        DoubleLinkedList list = new DoubleLinkedList<Integer>();
        for(int i = 0; i < 10; i++){
            arr[i] = rand.nextInt(101);
            list.addNode(arr[i]);
        }
        System.out.println("The random numbers are: "+ Arrays.toString(arr).replaceAll("[^\\s\\d]", ""));
        System.out.println("Insert the numbers into the doubly linked list");
        System.out.println(list);
        
        System.out.println("Remove a number from the third position");
        list.deleteNode(2);
        System.out.println(list);
        
        System.out.println("Remove all even numbers");
        for(int i = 0; i < list.length(); i++){
            if((int) list.get(i) % 2 == 0){
                list.deleteNode(i);
                i--;
            }
        }

        System.out.println(list);
    }
}
