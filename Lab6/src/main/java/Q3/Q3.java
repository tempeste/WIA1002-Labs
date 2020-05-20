/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author RAVEN
 */
public class Q3 {
    public static void main(String[] args) {
        String[] colors = new String[]{"Blue", "Green", "Red", "Yellow"};
        String[] numbers = new String[]{"One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        
        //generate deck
        String[] deck = new String[40];
        for(int i = 0, counter = 0; i < 10; i++){
            for(int j = 0; j < 4; j++, counter++){
                String temp = numbers[i] + " " + colors[j];
                deck[counter]= temp;
            }
        }
        
        //ArrayList to check for duplicate draws
        ArrayList<Integer> draws = new ArrayList<>();
        Random rand = new Random();
        Queue<String>p1 = new Queue<>();
        
        //generate P1's deck
        for(int i = 0; i< 5; i++){
            int draw = rand.nextInt(40);
            if(!draws.contains(draw)){
                draws.add(draw);
                p1.enqueue(deck[draw]);
            }else{
                i--;
            }
        }
        System.out.println("Player 1 Card");
        p1.showQueue();
        Queue<String>p2 = new Queue<>();
        
        //generate P2's deck
        for(int i = 0; i< 5; i++){
            int draw = rand.nextInt(40);
            if(!draws.contains(draw)){
                draws.add(draw);
                p2.enqueue(deck[draw]);
            }else{
                i--;
            }
        }
        System.out.println("Player 2 Card");
        p2.showQueue();
        
        int p1Score =0;
        int p2Score =0;
        for(int i = 0; i < 5; i++){
            String p1Card = p1.dequeue();
            String p2Card = p2.dequeue();
            if(compare(p1Card, p2Card)){
                p1Score++;
            }else{
                p2Score++;
            }
        }
        System.out.println("Player 1 Score: "+p1Score);
        System.out.println("Player 2 Score: "+p2Score);
        int winner = (p1Score>p2Score? 1: 2);
        System.out.printf("Player %d wins!\n", winner );

    }
    
    //true if p1 has better score, false otherwise
    static boolean compare(String p1, String p2){
        String[] p1Card = p1.split(" ");
        String[] p2Card = p2.split(" ");
        int p1val;
        int p2val;
        if(!p1Card[0].equals(p2Card[0])){
            p1val = numValue(p1Card[0]);
            p2val = numValue(p2Card[0]);
            return p1val > p2val;
        }else{
            p1val = colorValue(p1Card[1]);
            p2val = colorValue(p2Card[1]);
            return p1val > p2val;
        }
        
    }
    
    static int numValue(String num){
        switch(num){
            case "One":
                return 1;
            case "Two":
                return 2;
            case "Three":
                return 3;
            case "Four":
                return 4;
            case "Five":
                return 5;
            case "Six":
                return 6;
            case "Seven":
                return 7;
            case "Eight":
                return 8;
            case "Nine":
                return 9;
            case "Ten":
                return 10;
            default:
                return -1;
        }
    }
    
    static int colorValue(String color){
        switch(color){
            case "Yellow":
                return 1;
            case "Red":
                return 2;
            case "Green":
                return 3;
            case "Blue":
                return 4;
            default:
                return -1;
        }
    }
}
