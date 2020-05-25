/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        BST<Integer> bst = new BST<>();
        String string = "The random numbers are ";
        for(int i = 0; i < 10; i++){
            numbers[i] = rand.nextInt(21);
            bst.addNode(numbers[i]);
            string += numbers[i] +" ";
        }
        System.out.println(string);
        System.out.println("Number of elements in the BST: " + bst.getSize());
        
        System.out.print("The tree elements - PREORDER : ");
        bst.setOrder(2);
        bst.showTree();
        
        System.out.print("The tree elements - INORDER : ");
        bst.setOrder(1);
        bst.showTree();
        
        System.out.print("The tree elements - POSTORDER : ");
        bst.setOrder(3);
        bst.showTree();
        
        System.out.println("The minimum number is : " + bst.findMin());
        System.out.println("The maximum number is : " + bst.findMax());
        System.out.println("The total is: " + bst.findTotal());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search : " );
        int temp = sc.nextInt();
        System.out.println("The number of occurrence of " + temp + " is " + bst.findOccurrence(temp));
    }
}
