/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

/**
 *
 * @author RAVEN
 */
public class Q3 {
    public static void main(String[] args) {
        Course a = new Course("WXX101", "Programming", 5, "B");
        Course b = new Course("WXX201", "Networking", 4, "C");
        Course c = new Course("WXX301", "Operating System", 3, "A");
        LinkedList<Course> list = new LinkedList<>();
        list.addNode(a);
        list.addNode(b);
        list.addNode(c);
        System.out.println(list);
        int point = 0, credit = 0; 
        int length = list.length();
        for(int i = 0; i < length; i ++){
            point += list.get(i).getPoint() * list.get(i).getCredit();
            credit += list.get(i).getCredit();
        }
        System.out.println("Total Point is " + point);
        System.out.println("Total credit is " + credit);
        System.out.printf("Grade Point Average is %.2f", (double) point/credit);
    }

}
