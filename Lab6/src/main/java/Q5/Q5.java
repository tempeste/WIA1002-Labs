/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

/**
 *
 * @author RAVEN
 */
public class Q5 {
    public static void main(String[] args) {
        Queue<Packet> insertion = new Queue<>();
        PriorityQueue<Packet> packets = new PriorityQueue<>();
        String[] arr = new String[]{"Video","Voice","Data","Data","Voice",
            "Video","Voice","Voice","Data","Video"};
        System.out.println("10 packets arrived");
        for(int i = 0; i< arr.length; i++){
            Packet temp = new Packet(arr[i]);
            insertion.enqueue(temp);
            packets.enqueue(temp);
        }
        System.out.println(insertion);

        System.out.println("\nProcessing 10 network packets");
        System.out.println(packets);
        
    }
}
