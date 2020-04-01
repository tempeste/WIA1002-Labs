/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import java.util.Random;

/**
 *
 * @author RAVEN
 */
public class Q4 {
    public static void main(String[] args) {
        Random rand = new Random();
        int start = rand.nextInt(2);
        int p1, p2;
        LinkedList p1list = new LinkedList<Character>();
        LinkedList p2list = new LinkedList<Character>();
        if(start %2 == 0){
            p1 = 1;
            p2 = 2;
        }else{
            p1 = 2;
            p2 = 1;
        }
        System.out.println("Player " + p1 + " start first");
        while(p2list.length() <= 20){
            int add = rand.nextInt(6)+1;
            addNode(p1list, add);
            System.out.println("Player "+ p1 +": " + p1list);
            if(p1list.length()> 20){
                break;
            }
            add = rand.nextInt(6)+1;
            addNode(p2list, add);
            System.out.println("Player "+ p2 +": " + p2list);
        }
        System.out.println(p1list.length() > p2list.length() ? ("Player " + p1 + " wins the game"): ("Player " + p2 + " wins the game")); 
    }
    
    static void addNode(LinkedList a, int times){
        for(int i = 0; i < times; i++){
            a.addNode('*');
        }
    }
}
