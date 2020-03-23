package LearningSomethingNew;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;


interface CardDeck{
    final int [] number = {0,1,2,3,4,5,6,7,8,9};
    final Pattern [] rank = {new Pattern("Spade"),new Pattern("Heart"),
        new Pattern("Club"),new Pattern("Diamond")};
    final char [] character = {'A','B','C','D','E','F','G','H','I','J','K','L'
    ,'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public void shuffle();
    public Card[] draw(int n);
    public String toString();
}

class Card <E extends Comparable <E>> implements Comparable <Card<E>>{
    
    private Pattern pattern ;

    private E rank ;

    public Card(Pattern pattern, E rank) {
        this.pattern = pattern;
        this.rank = rank;
    }
    
    @Override
    public int compareTo(Card<E> o) {
        if(this.rank.compareTo(o.rank) > 0)
            return 1;
        else if(this.rank.compareTo(o.rank) < 0)
            return -1;
        else{
            int thisValue = this.pattern.getValue();
            int nextValue = o.pattern.getValue();
            if(thisValue == nextValue){
                return 0;
            }else if(thisValue > nextValue)
                return 1;
            else
                return -1;
        }
            
    }
    @Override
    public String toString() {
        return pattern + " " + rank;
    }
}

class Pattern {
    private String pattern;
    private int value;

    public Pattern(String pattern) {
        this.pattern = pattern;
        if(pattern.equalsIgnoreCase("Spade")){
            value = 4;
        }else if(pattern.equalsIgnoreCase("heart")){
            value = 3;
        }else if(pattern.equalsIgnoreCase("club")){
            value = 2;
        }else if(pattern.equalsIgnoreCase("diamond")){
            value = 1;
        }
    }

    public String getPattern() {
        return pattern;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return pattern;
    }
    
}

class LinkedListCardDeck implements CardDeck{
    private LinkedList<Card> deck;
    
    public LinkedListCardDeck(String rankType) {
        deck = new LinkedList<>();
        if(rankType.equals("Integer")){
            for(int i = 0 ; i < rank.length ; i ++){
                for(int j = 0 ; j < number.length ; j ++){
                    deck.add(new Card(rank[i],number[j]));
                }
            }
            
        }else if(rankType.equals("Character")){
            for(int i = 0 ; i < rank.length ; i ++){
                for(int j = 0 ; j < character.length ; j ++){
                    deck.add(new Card(rank[i],character[j]));
                }
            }   
        }
        shuffle();
    }

    
    @Override
    public void shuffle() {
        Collections.sort(deck);
    }

    @Override
    public Card[] draw(int n) {
        Random rnd = new Random();
        Card [] cards = new Card[n];
        
        for(int i = 0 ; i < n ; i++){
            int randomNum = rnd.nextInt(deck.size() );
            cards[i] = deck.remove(randomNum);
        }
        
        return cards;
        
    }

}

class ArrayCardDeck implements CardDeck{

    private Card [] deck ;
    private boolean[] drew;
    
    public ArrayCardDeck(String rankType) {
        if(rankType.equals("Integer")){
            deck = new Card [40];
            for(int i = 0 ; i < rank.length ; i ++){
                for(int j = 0 ; j < number.length ; j ++){
                    deck[i*10+j] = new Card(rank[i],number[j]);
                }
            }
            
        }else if(rankType.equals("Character")){
            deck = new Card[4*character.length];
            for(int i = 0 ; i < rank.length ; i ++){
                for(int j = 0 ; j < character.length ; j ++){
                    deck[i*character.length+j] = new Card(rank[i],character[j]);
                }
            }   
        }
        
        shuffle();
        drew = new boolean[deck.length];
    }

    
    @Override
    public void shuffle() {
        Random rnd = new Random();
        for(int i = 0 ; i < 50 ; i++){
            int swap1 = rnd.nextInt(deck.length);
            int swap2 = rnd.nextInt(deck.length);
            Card temp = deck[swap1];
            deck[swap1] = deck[swap2];
            deck[swap2] = temp;
        }
    }

    @Override
    public Card[] draw(int n) {
        Random rnd = new Random();
        Card [] cards = new Card[n];
        
        for(int i = 0 ; i < n ; i++){
            int randomNum = rnd.nextInt(deck.length );
            
            while(drew[randomNum] != false){
                randomNum = rnd.nextInt(deck.length);
            }
            cards[i] = deck[randomNum];
            drew[randomNum] = true;
        }
        
        return cards;
        
    }
}

class testCard{
    public static void main(String[] args) {
        System.out.println("Implementation using Linked List");
        LinkedListCardDeck deck1 = new LinkedListCardDeck("Integer");
        Card [] player1 = deck1.draw(5);
        Card [] player2 = deck1.draw(5) ;
        Arrays.sort(player1);
        Arrays.sort(player2);
        System.out.println("Card of player 1 ");
        for(int i = 0 ; i < player1.length ; i ++){
            System.out.print(player1[i] + " | ");
        }
        System.out.println("\nCard of player 2 ");
        for(int i = 0 ; i < player2.length ; i ++){
            System.out.print(player2[i] + " | ");
        }
        
        
        System.out.println("");
        int score1 = 0;
        int score2 = 0;
        for(int i = 4; i >= 0 ; i --){
            System.out.println("Card Player 1 is " + player1[i]);
            System.out.println("Card Player 2 is " + player2[i]);
            if(player1[i].compareTo(player2[i]) > 0){
                score1 ++;
                System.out.println("Card player 1 is higher : " + score1 );
            }else{
                score2 ++;
                System.out.println("Card player 2 is higher : " + score2 );
            }
        }
        if(score1 > score2){
            System.out.println("Player 1 won");
        }else{
            System.out.println("Player 2 won");
        }
        
        
        System.out.println("\n\n\n");
        
        System.out.println("Implementation using Array");
        ArrayCardDeck deck2 = new ArrayCardDeck("Character");
        player1 = deck2.draw(5);
        player2 = deck2.draw(5) ;
        Arrays.sort(player1);
        Arrays.sort(player2);
        System.out.println("Card of player 1 ");
        for(int i = 0 ; i < player1.length ; i ++){
            System.out.print(player1[i] + " | ");
        }
        System.out.println("\nCard of player 2 ");
        for(int i = 0 ; i < player2.length ; i ++){
            System.out.print(player2[i] + " | ");
        }
        
        score1 = 0;
        score2 = 0;
        for(int i = 4; i >= 0 ; i --){
            System.out.println("Card Player 1 is " + player1[i]);
            System.out.println("Card Player 2 is " + player2[i]);
            if(player1[i].compareTo(player2[i]) > 0){
                score1 ++;
                System.out.println("Card player 1 is higher : " + score1 );
            }else{
                score2 ++;
                System.out.println("Card player 2 is higher : " + score2 );
            }
        }
        
        System.out.println("");
        if(score1 > score2){
            System.out.println("Player 1 won");
        }else{
            System.out.println("Player 2 won");
        }
    }
}
