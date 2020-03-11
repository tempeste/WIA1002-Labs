package Q2;


import java.lang.reflect.Array;
import java.util.Arrays;
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
public class Polynomial {
    int degree;
    double[] coArray;
    String exp = "";
    double x;
    double answer;
    
    public Polynomial(int a, double[] b){
        this.degree = a;
        this.coArray = b;
        for(int i = degree, j =0; i >= 0; i--, j++){
            if(coArray[j] > 0 && j != 0){
                this.exp += "+" + coArray[j];
            }else{
                this.exp += coArray[j];                
            }
            if(i == 1){
                exp += "x";
            }
            else if(i != 0){
                exp += "x^";
                exp += i;
            }
            this.exp += " ";
        }
        this.answer();
    }
    
    
    public void answer(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("The Polynomial is: " + exp);
        do{
            answer = 0;
            System.out.print("When x = ");
            x = Double.valueOf(sc.nextLine());
            for(int i = degree, j =0; i >= 0; i--, j++){
                answer += coArray[j] * Math.pow(x, i); 
            }
            System.out.println(exp + "= " + answer);
        }while( x != -1);
    }
    
}
