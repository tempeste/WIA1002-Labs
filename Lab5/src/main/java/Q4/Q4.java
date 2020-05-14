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
                if (starting.isEmpty() || (!starting.isEmpty() && starting.pop() != complement(exp.charAt(i)))){
                    spaces = i;
                    wrongSign = exp.charAt(i);
                    extra = true;
                    break;
                }
                char temp = closing.pop();
                if(temp != exp.charAt(i))
                {   
                    spaces = i;
                    wrongSign = temp;
                    missing = true;
                    break;
                }else{
                    starting.pop();
                }
            }else if(i == exp.length()-1 && !closing.isEmpty()){
                if(exp.charAt(i) != closing.peek()){
                    spaces = i;
                    wrongSign = closing.peek();
                    missing = true;
                    break;
                }
            }
            
        }
        if(!starting.isEmpty()){
            spaces = exp.length()-1;
            missing = true;
            wrongSign = complement(starting.pop());
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
