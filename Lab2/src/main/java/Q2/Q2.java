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
        TextFileLog<String> log = new TextFileLog<>(5);
        log.insert("James");
        log.insert("Ahmad");
        log.insert("Siti");
        log.insert("Ramesh");
        log.insert("John");
        log.size();
        
        
        log.display();
        log.insert("test");
        log.search("Siti");
        log.delete();
        log.size();
        
    }
}



