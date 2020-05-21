/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q4 {
    static int gains = 0;
    public static void main(String[] args) {
        Queue<Shares> shareslist= new Queue<>();
        Queue<Shares> selling = new Queue<>();

        try{
            Scanner sc = new Scanner(new FileInputStream("lab6Q4.txt"));
            while(sc.hasNextLine()){
                String input = sc.nextLine();
                String[] temp = input.split(" ");
                //System.out.println(Arrays.toString(temp));
                Shares tempShare = new Shares(temp);
                shareslist.enqueue(tempShare);
                if(tempShare.type == 'S'){
                    sell(selling, tempShare.amount, tempShare.value);
                }else{
                    selling.enqueue(tempShare);
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        System.out.println("List of Transactions");
        System.out.println(shareslist);
        
        System.out.println("Total Gain: " + gains);
    }
    
    static void sell(Queue<Shares> selling, int amount, int value){
        while(amount != 0){
            Shares temp = selling.peek();
            if(temp.amount <= amount){
                selling.dequeue();
                amount -= temp.amount;
                gains += temp.amount * (value - temp.value );
            }else{
                gains += amount * (value - temp.value);
                temp.amount -= amount;
                selling.setFront(temp);
                amount = 0;
            }
        }
    }
}
