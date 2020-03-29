/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        LinkedList<Character> list = new LinkedList<Character>();
        for(int i = 0 ; i< input.length(); i++){
            list.addNode(input.charAt(i));
        }
        System.out.println("The original list: " + list.toString());
        System.out.println("Item at 2: " + list.get(2));
        
    }
}
