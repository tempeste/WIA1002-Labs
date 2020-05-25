/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.Scanner;

/**
 *
 * @author RAVEN
 */

//NOTE: THIS CLASS DOES NOT WORK FOR EXPRESSIONS WITH NUMBERS > 1 digit
//NOTE: THE EXAMPLE OUTPUT GIVEN IN THE LAB ASSIGNMENT IS WRONG, 
//THE POST ORDER AND PRE ORDER SEQUENCE HAS BEEN SWAPPED
//NOTE: THE ALGORITHM PROVIDED IN THE LECTURE NOTES IS ALSO WRONG
//I.E: SET RIGHT LINK BEFORE SET LEFT LINK
//the println comments are used for testing
public class BSTExpression {
    public static void main(String[] args) {
        System.out.print("Enter the infix expression: ");
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        exp = exp.trim();
        Stack<Character> operatorStack = new Stack<>(); 
        Stack<BST<Character>> bstStack = new Stack<>();
        for(int i = 0; i< exp.length(); i++){
            if(exp.charAt(i) == '('){
                operatorStack.push('(');
            }else if(exp.charAt(i) == ')'){
                while(operatorStack.peek() != '('){
                    BST<Character> temp = new BST<>();
                    temp.addNode(operatorStack.pop());
                    temp.addRight(bstStack.pop());
                    temp.addLeft(bstStack.pop());
                    bstStack.push(temp);
                }
                operatorStack.pop();
            }else if(Character.isDigit(exp.charAt(i))){
                BST<Character> temp = new BST<>();
                temp.addNode(exp.charAt(i));
                bstStack.push(temp);
                //System.out.println("bststack after pushing digit " + exp.charAt(i)+ " : " +bstStack);
            }else if(operator(exp.charAt(i))){
                while(!operatorStack.isEmpty()){
                    if(priority(exp.charAt(i)) < priority(operatorStack.peek())){
                        BST<Character> temp = new BST<>();
                        temp.addNode(operatorStack.pop());
                        temp.addRight(bstStack.pop());
                        temp.addLeft(bstStack.pop());
//                        System.out.println("temp after left right linkage"+temp);
                        bstStack.push(temp);
                    }else{
                        break;
                    }
                }
                operatorStack.push(exp.charAt(i));
                //System.out.println("operatorStack after adding in "+exp.charAt(i)+": "+operatorStack);
            }
        }
        
//        System.out.println("OperatorStack: "+operatorStack);
//        System.out.println("BSTStack: "+ bstStack); 
        while(!operatorStack.isEmpty()){
            BST<Character> temp = new BST<>();
            temp.addNode(operatorStack.pop());
            //System.out.println("right: " + bstStack.peek());
            temp.addRight(bstStack.pop());
            //System.out.println("left: " + bstStack.peek());
            temp.addLeft(bstStack.pop());
            //System.out.println("temp: "+temp);
            bstStack.push(temp);
//            System.out.println("current bststack: "+ bstStack);
        }
        
        //System.out.println("final bststack: "+ bstStack);
        BST<Character> finalexp = bstStack.pop();
        
        System.out.print("The tree elements - INORDER : ");
        finalexp.setOrder(1);
        finalexp.showTree();
        
        System.out.print("The tree elements - PREORDER : ");
        finalexp.setOrder(2);
        finalexp.showTree();
        
        System.out.print("The tree elements - POSTORDER : ");
        finalexp.setOrder(3);
        finalexp.showTree();
    }
    
    static boolean operator(char a){
        if( a == '*' || a == '+' || a == '-' || a=='/' || a=='%'){
            return true;
        }
        return false;
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
}
