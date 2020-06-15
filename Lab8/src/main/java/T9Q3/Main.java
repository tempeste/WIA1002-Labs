package T9Q3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashTable<String, String> hash = new HashTable<>();
        hash.put("100-101", "ICND 1");
        hash.put("200-101", "ICND 2");
        hash.put("200-120", "CCNA Routing and Switching");
        hash.put("210-260", "CCNA Security");
        System.out.println("The number of elements in thw Hash Table: " + hash.getSize());
        hash.showHashTable();
        System.out.print("\nEnter a code to search : ");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        hash.get(input);
        if(hash.get(input)!=null){
            System.out.println("Course " + input + " : " +hash.get(input));
        }
        else
            System.out.println("The course " + input + " cannot be found");
    }
}
