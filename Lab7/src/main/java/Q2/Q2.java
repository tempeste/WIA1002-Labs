/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q2 {
    public static void main(String[] args) {
        String text = "";
        try{
           Scanner sc = new Scanner(new FileInputStream("L7Q2.txt")); 
           text = sc.nextLine();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        
        BST<String> bst = new BST<>();
        String[] arr = text.split("[\\W]+");
        for(int i = 0 ; i < arr.length; i++){
            bst.addNode(arr[i].toLowerCase());
        }
        bst.freqCounter();
        bst.setOrder(2);
        bst.showTree();
    }
}
