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
        System.out.print("Enter N characters: ");
        int total = sc.nextInt();
        SortTest<Character> test = new SortTest<>(1, 'A', total);
        test.showValue();
        System.out.println("Heap Sort - Ascending Order");
        test.heapSort();
        test.showValue();
    }
}
