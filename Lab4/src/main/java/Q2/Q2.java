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
        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        LinkedList<Character> list = new LinkedList<Character>();
        LinkedList<Character> first = new LinkedList<Character>();
        LinkedList<Character> second = new LinkedList<Character>();
        for(int i = 0 ; i< input.length(); i++){
            list.addNode(input.charAt(i));
        }
        System.out.println("The original list: " + list.toString());
        
        list.splitList(first, second);
        System.out.println("Split the list into two");
        System.out.println("The first list: " + first.toString());
        System.out.println("The second list: " + second.toString());
        first.clear();
        second.clear();
        
        
        list.alternateList(first, second);
        System.out.println("Split the list by alternating the nodes");
        System.out.println("The first list: " + first.toString());
        System.out.println("The second list: " + second.toString());
        
        
        System.out.println("Merge First List and Second List by alternating the nodes");
        first.mergeList(second);
        System.out.println(first);
        
        System.out.println("Reverse the list. Recursive in lInked list");
        list.reverseList();
        System.out.println(list);
        
        System.out.println("Reverse the list. Recursive in tester class");
        LinkedList newList = new LinkedList<Character>();
        ListNode node = list.getHead();
        list = reverseList(node,newList);
        System.out.println(list);
        
        System.out.println("Reverse the list. Recursive in tester class2");
        LinkedList newlist = new LinkedList<Character>();
        char[] arr = new char[list.length()];
        reverse(list, arr, 0, arr.length-1);
        list = arrConv(arr);
        System.out.println(list);
        
        
        System.out.println("Reverse the list. Recursive in tester class3");
        list = reverseList2(list, 0, list.length()-1);
        System.out.println(list);
        
        
    }
    
    static LinkedList reverseList(ListNode node, LinkedList list){
        if(node == null){
            return list;
        }
        
        list.addNode(0, (Comparable) node.getData());
        return reverseList(node.getLink(), list);
    }
    
    //reverse method 2
    static void reverse(LinkedList list, char[] arr, int start, int  arrIndex){
        if(start >= arr.length){
            return;
        }
        arr[arrIndex] = (char) list.get(start);
        reverse(list, arr, start + 1, arrIndex - 1);
    }
    
    static LinkedList arrConv(char[] arr){
        LinkedList newList = new LinkedList<Character>();
        for(int i = 0; i < arr.length; i++){
            newList.addNode(arr[i]);
        }
        return newList;
    }
    
    //reverse method 3
    static LinkedList reverseList2(LinkedList list, int start, int end){
        if(start >= end){
            return list;
        }
        
        char Start = (char) list.get(start);
        char End = (char) list.get(end);
        list.set(start, End);
        list.set(end, Start);
        return reverseList2(list, start+1, end -1);

    }
}
