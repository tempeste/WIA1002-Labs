/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author RAVEN
 */
public class UNOarr<T> implements UNO<T>{
    
    int times;
    String[] finalarr = new String[54];
    int[] cards = new int[54];
    
    String[] p1;
    String[] p2;
    
    UNOarr(int a){
        times = a;
        this.generate();
        
//        int total = 0;
//        System.out.println(Arrays.toString(cards));
//        for(int i = 0; i < cards.length; i++){
//            total += cards[i];
//        }
//        System.out.println("total cards: " + total);
    }
    
    public void generate(){
        p1 = new String[times];
        p2 = new String[times];
        int counter = 0;
        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j < color.length; j++){
                if(i == 0){
                    finalarr[counter] = nums[i] + " " + color[j];
                    cards[counter] = 1;
                }else{
                    finalarr[counter] = nums[i] + " " + color[j];
                    cards[counter] = 2;
                }
                
                counter++;
            }
        }
        
        finalarr[52] = "Draw Four Wild";
        cards[52] = 4;
        finalarr[53] = "Pick Color";
        cards[53] = 4;
    }
    
    public void draw(){
        System.out.println("Array Implementation");
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
            }while(cards[temp] <= 0);
            p1[i] = finalarr[temp];
            cards[temp]--;
        }
        this.display((T[])p1);
        System.out.println("");
        System.out.println("Array Implementation");
        System.out.println("Player 2 draws " + times + " times");
        for(int i = 0; i < times; i++){
            tempCounter++;
            if(tempCounter > 108){
                break;
            }
            do{
                temp = r.nextInt(54);
            }while(cards[temp] <= 0);
            p2[i] = finalarr[temp];
            cards[temp]--;
            
        }
        this.display((T[])p2);
    }
    
    
   private void display(T[] arr){
        for(int i =0 ; i < arr.length; i++){
            if(arr[i] != null){
                System.out.print(arr[i] + " :: ");
            }else{
                System.out.print("Ran out of cards");
                break;
            }
        }
        System.out.println("");
    }
}
