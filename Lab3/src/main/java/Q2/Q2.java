/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q2 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new FileInputStream("original.txt"));
            PrintWriter write = new PrintWriter(new FileOutputStream("reverse.txt"));
            read(sc, write);
            write.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }catch(IOException e){
            System.out.println("Problem with file output");
        }
        
        
    }
    
    public static void read(Scanner sc, PrintWriter write){
        String input = "";
        if(sc.hasNextLine()){
             input = sc.nextLine();
             read(sc, write);
             write.println(input);
        }
        
    }
}
