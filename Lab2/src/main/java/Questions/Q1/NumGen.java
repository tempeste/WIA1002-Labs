/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions.Q1;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;
/**
 *
 * @author RAVEN
 */
public class NumGen <T>{
    private LinkedList<Integer> list;
    private int[] array;
    private int length;
    NumGen(int a){
        length = a;
        list = new LinkedList<>();
        array = new int[length];
        ArrayList<Integer> arrList = new ArrayList<>();
        Random rand = new Random();
        System.out.printf("Generate %d non-duplicate integer within 0-100\n", length);
        System.out.println("Linked List Implementation");
        for(int i = 0; i < length; i++){
            int store;
            do{
                store = rand.nextInt(101);
            }while(list.contains(store));
            arrList.add(store);
            list.add(store);
        }
        
        list.sort((x, y) -> x - y);
        for(int i = 0; i < length; i ++){
            System.out.print(list.get(i) + " ");
        }
        
        System.out.println("");
        System.out.println("Array Implementation");
        for(int i = 0; i < length; i++){
            int store;
            do{
                store = rand.nextInt(101);
            }while(arrList.contains(store));
            arrList.add(store);
            array[i] = store;
        }
        quickSort(array,0, length-1);
        for(int i : array){
            System.out.print(i + " ");
        }
        
        
        
    }
    
    static int partition(int[] arr, int start, int end){    
        int pivot = arr[end];
        
        int counter = start;
        for(int i = start; i < end; i++){
            if( arr[i] < pivot){
                int temp= arr[counter];
                arr[counter]=arr[i];
                arr[i]=temp;
                counter++;
            }
        }
        int temp = pivot;
        arr[end] = arr[counter];
        arr[counter] = temp;

        return counter;
    
    }
    
    
    public static void quickSort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }
        
        int pivot = partition(arr, start, end);
       
        quickSort(arr, start, pivot - 1);
        
        
        quickSort(arr, pivot + 1, end);
        
    }
    
}