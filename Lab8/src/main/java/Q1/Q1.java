package Q1;

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
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N Special Random Number within 0-100: ");
        int total = sc.nextInt();
        SortTest<Special> sorts;
        sorts = new SortTest<>(1 , new Special(5) , total);
        System.out.print("The Special Number are : ");
        sorts.showValue();
        sorts.mergeSort();
        System.out.print("After Merge Sort : ");
        sorts.showValue();
    }
}
