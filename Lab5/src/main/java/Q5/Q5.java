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
        String root = " ";
        Stack<String> stack = new Stack();
        boolean valid = true;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '<'){
                if(root.equals(" ")){ //to determine the root
                    root =  input.substring(i+1, input.indexOf(">")); 
                    stack.push(root);
                    input = input.substring(input.indexOf(">")+1);
                    i = 0;
                }else if(input.charAt(i+1) == '/'){ //for closing tags
                    String str = stack.pop(); 
//                    System.out.println("String before breaking: "+ str + " and it's index is "+ i); //for debug
                    String compare = input.substring(i+2, input.indexOf(">"));
                    if(!str.equals(compare)){
                        System.out.println("Begin Element : <" + str +"> Invalid ending element : </" + compare + ">");

                       return;
                    }
                    input = input.substring(input.indexOf(">")+1);
                    i = 0;
                }else{ //for opening tags
                    String temp =  input.substring(i+1, input.indexOf(">"));
                    if(temp.equals(root)){ //prevent duplicate root
                        System.out.println("Duplicate root element <"+temp+">");

                        return;
                    }
                    stack.push(temp);
                    input = input.substring(input.indexOf(">")+1);
                    i = 0;
                }
            }
        }
        System.out.println("The xml document is valid.");
    }
}
