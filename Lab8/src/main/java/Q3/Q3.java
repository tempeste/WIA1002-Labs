/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author RAVEN
 */
public class Q3 {
    public static void main(String[] args) {
        Random r= new Random();
        int size = 10000;
        Integer[][] arr = new Integer[100][size];
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = (Integer) r.nextInt(501);
            }
        }
        
        Sorting[] arr1 = new Sorting[5];
        arr1[0] = new Sorting("Bubble Sort", 0);
        arr1[1] = new Sorting("Quick Sort", 0);
        arr1[2] = new Sorting("Merge Sort", 0);
        arr1[3] = new Sorting("Insertion Sort", 0);
        arr1[4] = new Sorting("Selection Sort", 0);
        
        for(int i = 0; i < 100; i++){
            Integer[] temp = arr[i].clone();
            SortTest<Integer> test = new SortTest<>(1 ,temp, size);
            long start = System.currentTimeMillis();
            test.bubbleSort();
            arr1[0].time  += System.currentTimeMillis() - start;
            
            
            temp = arr[i].clone();
            test = new SortTest<>(1 ,temp, size);
            start = System.currentTimeMillis();
            test.quickSort();
            arr1[1].time  += System.currentTimeMillis() - start;
            
            
            temp = arr[i].clone();
            test = new SortTest<>(1 ,temp, size);
            start = System.currentTimeMillis();
            test.mergeSort();
            arr1[2].time  += System.currentTimeMillis() - start;
            
            temp = arr[i].clone();
            test = new SortTest<>(1 ,temp, size);
            start = System.currentTimeMillis();
            test.insertionSort();
            arr1[3].time  += System.currentTimeMillis() - start;
            
            temp = arr[i].clone();
            test = new SortTest<>(1 ,temp, size);
            start = System.currentTimeMillis();
            test.selectionSort();
            arr1[4].time  += System.currentTimeMillis() - start;
        }
        
        SortTest<Sorting> sorts = new SortTest<>(1, arr1, arr1.length);
        sorts.quickSort();
        sorts.showValue();
        System.out.println("The fastest sorting algo is " + arr1[0].name);
    }
}
