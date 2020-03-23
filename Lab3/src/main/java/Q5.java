
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RAVEN
 */
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int i = 0;
        while(true){
            try{
                System.out.print("Enter an Integer: ");
                arr[i] = sc.nextInt();
                i++;                
            }catch(InputMismatchException e){
                System.out.println("Invalid Input Type");
                sc.next();
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println(Arrays.toString(arr).replaceAll("[^0-9\\s+]", ""));
                break;
      
            }
        }
        
    }
}
