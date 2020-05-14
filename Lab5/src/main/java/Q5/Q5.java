/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
/**
 *
 * @author RAVEN
 */
public class Q5 {
    public static void main(String[] args) {
        String input = "";
        try{
            Scanner sc = new Scanner(new FileInputStream("text.xml"));
            do{
                input += sc.nextLine();
                input += "\n";
            }while(sc.hasNextLine());
            sc.close();
            System.out.println("Contents of XML file");
            System.out.println(input);
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
        
        
    }
}
