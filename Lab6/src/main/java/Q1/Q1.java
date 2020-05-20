/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
//D 400 | W 300 | W 700 | D 200 | D 450 | W 120
public class Q1 {
    static int balance = 500;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter transactions : ");
        String input = sc.nextLine();
        String[] arr = input.split("\\|");
        Queue<String> trans = new Queue<>();
        for(int i = 0; i < arr.length; i++){
            trans.enqueue(arr[i]);
        }
        trans.showQueue();
        System.out.println("Initial Balance: "+ balance );
        while(!trans.isEmpty()){
            char type = ' ';
            String value = "";
            String transaction = trans.dequeue();
            for(int i =0 ;i < transaction.length(); i++){
                if(Character.isDigit(transaction.charAt(i))){
                    value += transaction.charAt(i);
                }else if(Character.isLetter(transaction.charAt(i))){
                    type = transaction.charAt(i);
                }
            }
            System.out.println(output(type, value));
        }
    }
    
    static String output(char a, String amount){
        String type;
        boolean reject = false;
        int  value = Integer.valueOf(amount);
        if(a == 'D'){
            type = "Deposit";
            balance += value;
        }else if(a == 'W'){
            type = "Withdraw";
            if(value <= balance){
                balance -= value;
            }else{
                reject = true;
            }
        }else{
            return "Invalid transaction type";
        }
        
        String prefix = type +" "+ amount; 
        prefix += reject? " Rejected" : "";
        return String.format("%-24s New Balance %d", prefix, balance);
        
    }
}
