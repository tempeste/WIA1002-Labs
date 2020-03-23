/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Enter number of elements: ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = rand.nextInt(10);
        }
        
        permute(arr, 0, num-1);
    }
    
    public static void permute(int[] arr, int first, int end){
        if (first == end){
            printArr(arr);
        }else{
            for(int i = first ; i <= end; i ++){
                 swap(arr, first, i);
                 //idea is similar to alpha beta pruning, when swapping between numbers, check whether if the number is the same, if same, ignore
                 if(!(arr[first] == arr[i] && i != first)){
                     permute(arr, (first+1), end);
                 }
                 swap(arr,first,i);
            }
        }
        
    }
    
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void printArr(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++){
            if(i != 0){
                temp*=10;
            }
            temp += arr[i];
        }
        System.out.println(temp);
    }
}
