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
        System.out.println("Mesh Topology");
        System.out.println("There are 4 switches in the campus.");
        System.out.println("The total number of connections required is " + mesh(4));
        System.out.println("There are 7 switches in the campus.");
        System.out.println("The total number of connections required is " + mesh(7));
    }
    
    public static int mesh(int n){
        if(n <= 1)
            return 0;
        if(n == 2)
            return 1;
        
        
        return mesh(n-1)+ n-1;
    }
}
