/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Sentence {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("The sentence is: ");
        String sentence = sc.nextLine();
        
        System.out.println("The length of the sentence: " + sentence.length());
        int vowels = 0;
        for(int i = 0; i < sentence.length(); i++){
            char test = sentence.toLowerCase().charAt(i);
            if( test == 'a' || test == 'e'|| test == 'i' || test == 'o' || test == 'u'){
                vowels++;
            }
        }
        
        System.out.printf("The number of vowels: %d\n", vowels);
        
        System.out.printf("The number of words: %d\n", sentence.split(" ").length);
    }
}
