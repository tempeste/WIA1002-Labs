/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q7;

import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        CircularLinkedList list = new CircularLinkedList<String>();
        for(int i = 0; i < arr.length; i++){
            list.addCircularNode(arr[i]);
        }
        System.out.println("The words in the circular list:");
        //list.showCircularList();
        System.out.println(list);
        list.deleteCircularNode();
        System.out.println("After delete a word");
        System.out.println(list);
        System.out.println("List's length is: " + list.length());
        System.out.println("The second item in the list is: " + list.get(1));
    }
   
}
