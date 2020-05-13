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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression : ");
        String infix = sc.nextLine();
        infix = inconv(infix);
        System.out.println("The infix expression is: " + infix);
        String post = inToPost(infix);
        System.out.println("The postfix expression is: " + inToPost(infix));
        System.out.println("The result is: " + evaluate(post));
        
    }
    
    static String inToPost(String original){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < original.length(); i ++){
            if(original.charAt(i)>= '0' && original.charAt(i) <= '9' )
            {
                int temp = 0;
                int index = i;
                for(int j = i; (j < original.length() && original.charAt(j)>= '0' && original.charAt(j) <= '9' ) ;j++ ){
                    temp = temp* 10;
                    temp += original.charAt(j) - '0';
                    //System.out.println("Tab at iteration " + j + " of j equals: " + temp); for testing
                    index = j;
                }
                i = index;
                answer += temp;
            
            }else if(original.charAt(i) == '('){
                stack.push(original.charAt(i));
            }else if(original.charAt(i) == ')'){
                char temp2 = stack.pop();
                while(temp2 != '('){
                    answer += temp2;
                    temp2 = stack.pop();
                }
            }else if(original.charAt(i) == ' '){
                answer += " ";
            }else{
                char temp3 = original.charAt(i);
                if(!stack.isEmpty()){
                    if(stack.peek().equals("(")){
                        stack.push(original.charAt(i));
                    }else{
                        while(priority(temp3) <= priority(stack.peek())  )
                        {
                            answer += stack.pop();
                            if(stack.isEmpty()){
                                break;
                            }
                        }
                        stack.push(temp3);
                    }
                }else{
                    stack.push(temp3);
                }
            }
        }
        while(!stack.isEmpty()){
            answer += stack.pop() + " ";
        }
        return answer;
    }
    
    static int priority(char sign){
        switch (sign){
            case '%':
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
                
    }
    
    static String inconv (String a){
        String answer = "";
        for(int i = 0 ; i < a.length(); i ++){
            switch(a.charAt(i)){
                case 'a':
                    i+=2;
                    answer += '+';
                    break;
                case 's':
                    i+=2;
                    answer += '-';
                    break;
                case 'm':
                    if(a.charAt(i+1) == 'u'){
                        answer += '*';
                        i+=2;
                    }else{
                        answer += '%';
                        i+=2;
                    }                    
                    break;
                case 'd':
                    i+=2;
                    answer += '/';
                    break;
                case 'o':
                    i+=1;
                    answer += '(';
                    break;
                case 'c':
                    i+=1;
                    answer += ')';
                    break;
                default:
                    answer += a.charAt(i);
            }
        }
        return answer;
    }
    
    static int evaluate(String post){
        Stack<String> stack = new Stack<>();
        String temp = "";
        int a = 0, b = 0, result = 0;
        for(int i = 0; i < post.length(); i++){
            if(Character.isDigit(post.charAt(i))){
                int temp1 = 0;
                int index = i;
                for(int j = i; (j < post.length() && Character.isDigit(post.charAt(j)) ) ;j++ ){
                    temp1 = temp1* 10;
                    temp1 += post.charAt(j) - '0';
                    //System.out.println("Tab at iteration " + j + " of j equals: " + temp); for testing
                    index = j;
                }
                i = index;
                stack.push(String.valueOf(temp1));
            }else if(post.charAt(i) == ' '){
                continue;
            }else{
                b = Integer.parseInt(stack.pop());
                a = Integer.parseInt(stack.pop());
                result = getResult(a, b, post.charAt(i));
                stack.push(result + "");
            }
        }
        result = Integer.parseInt(stack.pop());
        return result;
    }
    
    static int getResult(int a, int b, char c){
        switch(c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            case '%':
                return a % b;
        }
        return 0;
    }
}
