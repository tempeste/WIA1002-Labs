/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;
import java.util.LinkedList;
import java.util.Random;
/**
 *
 * @author RAVEN
 */
public class UNOlist<T> implements UNO<T>{
    int times;
    private LinkedList<String> p1 = new LinkedList<>();
    private LinkedList<String> p2 = new LinkedList<>();
    private LinkedList<String[]> cards = new LinkedList<>();
    
    public UNOlist(int a){
        times = a;
        this.generate();
    }
    
    public void generate(){
        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j < color.length; j++){
                if(i == 0){
                      cards.add(new String[]{nums[i] + " " + color[j], "1"});
//                    finalarr[counter] = nums[i] + " " + color[j];
//                    cards[counter] = 1;
                }else{
                      cards.add(new String[]{nums[i] + " " + color[j], "2"});
//                    finalarr[counter] = nums[i] + " " + color[j];
//                    cards[counter] = 2;
                }
                
            }
        }
        
        cards.add(new String[]{"Draw Four Wild", "4"}) ;
        cards.add(new String[]{"Pick Color", "4"}) ;
    }
    
    public void draw(){
        System.out.println("");
        System.out.println("Linked List Implementation");
        System.out.println("Player 1 draws " + times + " times");
        Random r = new Random();
        int temp;
        int tempCounter = 0;
        for(int i = 0; i < times; i++){
            tempCounter++;
            if(tempCounter > 108){
                break;
            }
            do{
                temp = r.nextInt(54);
            }while(cards.get(temp)[1].equals("0"));
            p1.add(cards.get(temp)[0]);
            if(cards.get(temp)[1].equals("2")){
                cards.set(temp, new String[]{cards.get(temp)[0], "1"});
            }else{
                cards.set(temp, new String[]{cards.get(temp)[0], "0"});
            }
        }
        this.display(p1);
        System.out.println("");
        System.out.println("");
        System.out.println("Linked List Implementation");
        System.out.println("Player 2 draws " + times + " times");
        for(int i = 0; i < times; i++){
            tempCounter++;
            if(tempCounter > 108){
                break;
            }
            do{
                temp = r.nextInt(54);
            }while(cards.get(temp)[1].equals("0"));
            p2.add(cards.get(temp)[0]);
            if(cards.get(temp)[1].equals("2")){
                cards.set(temp, new String[]{cards.get(temp)[0], "1"});
            }else{
                cards.set(temp, new String[]{cards.get(temp)[0], "0"});
            }
        }
        this.display(p2);
    }
    
    private void display(LinkedList list){
        for(int i =0 ; i < list.size(); i++){
            System.out.print(list.get(i) + " :: ");
        }
        
        if (list.size() < times){
            System.out.println("Ran out of cards\n");
        }
    }
}
