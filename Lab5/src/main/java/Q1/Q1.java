/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1;

/**
 *
 * @author RAVEN
 */
public class Q1 {
    public static void main(String[] args) {
        Stack<String> stack1 = new Stack<>();
        String[] arr = new String[]{"Blue", "Yellow", "Yellow", "Orange", "Blue", "Red", "Orange"};
        for (int i = arr.length -1 ; i >= 0; i-- ) {
            stack1.push(arr[i]);
        }
        Stack<String> stack2 = new Stack<>();
        System.out.println("The Candies in the container: \n" + stack1);
        while(!stack1.isEmpty())
        {
            String temp = stack1.pop();
            if(!temp.equals("Blue"))
            {
                stack2.push(temp);
            }
        }
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }
        
        System.out.println("Ali takes all the candiews one by one and eats the blue ones.");
        System.out.println("He puts back all the candies in the container.");
        System.out.println(stack1);
    }
}
