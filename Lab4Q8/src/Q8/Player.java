/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q8;

import java.util.Scanner;



/**
 *
 * @author RAVEN
 */
public class Player {
    public static void main(String[] args) {
        System.out.println("My Music Player");
        Music a = new Music("Roar", "Roar~ Dies Irae.mp3");
        Music b = new Music("Dogfight", "Dogfight.mp3");
        Music c = new Music("Spinal Swan Coaster II", "Spinal Swan Coaster II.mp3");
        Music d = new Music("Sei BGM", "Sei BGM.mp3");
        CircularLinkedList<Music> player = new CircularLinkedList<>();
        player.addCircularNode(a);
        player.addCircularNode(b);
        player.addCircularNode(c);
        player.addCircularNode(d);
        ask(player, 0, 0);
        
    }
    
    public static void ask(CircularLinkedList<Music> player, int index, int prev) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println(player);
            System.out.print("1 Play Music | 2 Forward | 3 Back | 4 Stop | -1 Exit: ");
            try{
                option = sc.nextInt();
            }catch(NumberFormatException e){
                sc.next();
            }
            if (prev == 1 || prev == 2 || prev ==3){
                player.get(index).stop();
            }
            Music song;
            switch(option){
                case 1:
                    song = player.get(index);
                    System.out.println("Play Music: " + song.getTitle());
                    song.play();
                    ask(player, index, 1);
                    break;
                case 2:
                    if(index == player.length() -1){
                        index = 0;
                    }else{
                        index += 1;
                    }
                    song = player.get(index);
                    System.out.println("Forward one position - Play Music: " + song.getTitle());
                    song.play();
                    ask(player, index, 2);
                    break;
                case 3:
                    if(index == 0){
                        index = player.length()-1;
                    }else{
                        index -= 1;
                    }
                    song = player.get(index);
                    song.play();
                    System.out.println("Backward one position - Play Music: " + song.getTitle());
                    ask(player, index,3);
                    break;
                case 4:
                    song = player.get(index);
                    song.stop();
                    System.out.println("Stop playing");
                    ask(player, index,4);
                    break;
                case -1:
                    song = player.get(index);
                    System.out.println("Exit Music Player");
                    song.exit();
                    break;
            }
            
        }while(option != -1);
    }
}
