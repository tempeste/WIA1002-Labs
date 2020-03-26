/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author RAVEN
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Random rand = new Random();
        int[] arr = new int[10];
        for(int i = 0; i< 10; i++){
            arr[i] = rand.nextInt(101);
        }
        System.out.println("The random numbers are:  " + Arrays.toString(arr).replaceAll("[^\\d\\s+]", ""));
        for(int i = 0; i < 10; i++){
            list.addNode(arr[i]);
        }
        System.out.println("Inserting the random numbers at the back of the list:");
        System.out.println(list.toString());
        System.out.println("");
        list.clear();       
        
        for(int i = 0; i < 10; i++){
            list.addFrontNode(arr[i]);
        }
        System.out.println("Inserting the random numbers at the front of the list:");
        System.out.println(list.toString());
        System.out.println("");
        list.clear();
        
        for(int i = 0; i < 10; i++){
            list.addSortNode(arr[i]);
        }
        System.out.println("Inserting the random numbers in sorted order:");
        System.out.println(list.toString());
        System.out.println("");
        list.clear();
    }
}
