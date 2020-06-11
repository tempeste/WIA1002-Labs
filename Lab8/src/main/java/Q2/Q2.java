/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q2;

/**
 *
 * @author RAVEN
 */
import java.io.*;
import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        ArrayList<String[]> temp = new ArrayList<>();
        Product[] PArr;
        try{
            Scanner sc = new Scanner(new FileInputStream("Lab8Q2.txt"));
            while(sc.hasNextLine()){
                String tempS = sc.nextLine();
                temp.add(tempS.split(","));
            }
        }catch(FileNotFoundException e){
            System.out.println("Exception encountered, file not found");
        }
        
        int size = temp.size();
        PArr = new Product[size];
        for(int i = 0; i < size; i++){
            PArr[i] = new Product(temp.get(i));
        }
        
        SortTest<Product> sorts = new SortTest<>(1, PArr);
        System.out.println("Reading data from product text file");
        sorts.showValue();
        sorts.quickSort();
        System.out.println("After quicksort (price, PID): ");
        sorts.showValue();
    }
}
