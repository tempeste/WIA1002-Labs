/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Solving the N-Queen problem");
        System.out.print("N : ");
        int n = sc.nextInt();
        int current = 0;
        int[] arr = new int[n];
        int solution =0;
        boolean valid = false;
        while (true){
            valid = false;
            for(int i = current; i < n ; i++){
                int size = stack.getSize();
                if(size < n){ //cause without this if statement, check() might check size n
                    //which will result in array out of bounds
                    if(check(arr, stack , i)){
                        stack.push(i);
                        arr[stack.getSize()-1] = i;
                        current = 0;
                        valid = true;
                    }
                }
                
            }
            
            if(!valid){
                if(stack.isEmpty()){
                    break;
                }else{
                    current = stack.pop();
                    current += 1;
                }
            }else if(stack.getSize() == n){
                {
                    for(int i = n-1; i >= 0; i--)
                    {
                        arr[i] = stack.pop();
                    }
                    display(arr);
                    current = arr[0];
                    current += 1;
                    solution ++;
                }
            }
            
        }
        System.out.println("Number of solutions: "+ solution);
    }
    
    
    static void display(int[] arr){
        int n = arr.length;
        char[][] temp = new char[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n;j ++){
               temp[i][j] = '*';
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            temp[i][arr[i]] = 'Q';
        }
        
        for(int i = 0; i< n; i++){
            for(int j = 0 ; j < n; j++){
                System.out.print(temp[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        
        System.out.println("");
    }
    
    /*static boolean check(boolean arr[][], int row, int column){ //inefficient version from outdated main method
        //check row
        for(int i = 0; i < arr.length; i++){
            if(arr[row][i]){
                return false;
            }
        }
        
        //check column
        for(int i = 0; i < arr.length; i++){
            if(arr[i][column]){
                return false;
            }
        }
        int diff = Math.abs(column - row);
        int[] temp;
        if(column > row){
            temp = new int[]{0,diff};
        }else{
            temp = new int[]{diff,0};
        }
        //check diagonal
        for(int i = temp[0], j = temp[1]; i < arr.length  && j< arr.length; i++, j++){
            if(arr[i][j]){
                return false;
            }
        }
        
        for(int i = row, j = column; i < arr.length && j >= 0 ; i++, j --){
            if(arr[i][j]){
                return false;
            }
        }
        
        for(int i = row, j = column; j < arr.length && i >= 0 ; i--, j ++){
            if(arr[i][j]){
                return false;
            }
        }
        return true;
    }*/
    
    private static boolean check(int arr[], Stack<Integer> s, int currentPosition) {
        int size = s.getSize();
        for (int i = 0; i < size; i++) {
            if (arr[i] == currentPosition || Math.abs(currentPosition - arr[i]) == s.getSize() - i) {
                return false;
            }
        }
        return true;
    }
    
}
