/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q4;

import java.util.Scanner;

/**
 *
 * @author RAVEN
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String exp = sc.nextLine();
        Stack<Character> starting = new Stack();
        Stack<Character> closing = new Stack();
        int spaces = 0;
        boolean missing = false;
        boolean extra = false;
        char wrongSign = ' ';
        for(int i = 0; i < exp.length(); i ++){
            if(exp.charAt(i) == '\\'){
                i++;
            }else if(isStart(exp.charAt(i), closing)){
                starting.push(exp.charAt(i));
            }else if(isClose(exp.charAt(i))){
                if(starting.isEmpty()){
                    spaces = i;
                    wrongSign = exp.charAt(i);
                    extra = true;
                    break;
                }else if(exp.charAt(i)!= closing.peek()){
                    spaces = i;
                    boolean miss = false;
                    while(!starting.isEmpty()){
                        char temp = starting.pop();
                        if(temp == complement(exp.charAt(i))){
                            miss = true;
                            missing = true;
                            wrongSign = closing.pop();
                            break;
                        }
                    }
                    if(!miss){
                        extra = true;
                        wrongSign = exp.charAt(i);
                    }
                    break;
                }else if(!starting.isEmpty() && i == exp.length()-1){
                    spaces = exp.length()-1;
                    missing = true;
                    wrongSign = complement(starting.pop());
                    break;
                }else{
                    closing.pop();
                    starting.pop();
                }
            }
            
        }
        System.out.println(exp);
        if(missing){
            for(int i = 0; i < spaces; i++)
            {
                System.out.print(" ");
            }
            System.out.println("^ Missing "+ wrongSign);
        }else if(extra){
            for(int i = 0; i < spaces; i++)
            {
                System.out.print(" ");
            }
            System.out.println("^ Extra "+ wrongSign);
        }else{
            System.out.println("The expression is balanced");
        }
    }
    
    static boolean isStart(char a, Stack<Character> closing){
        switch(a){
            case '(':
                closing.push(')');
                return true;
            case '{':
                closing.push('}');
                return true;
            case '[':
                closing.push(']');
                return true;
    
            default: 
                return false;
        }
    } 
    
    static boolean isClose(char a){
        switch(a){
            case '}':
            case ')':
            case ']':
                return true;
            default: 
                return false;
        }
    } 
    
    static char complement(char a){
        switch(a){
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '['; 
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
        }
        return ' ';
    }
}
