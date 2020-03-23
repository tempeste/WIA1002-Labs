import java.util.*;

public class TestCard{
    public static void main(String[] args) {
        CardDeck Deck = new ArrayDeck("Integer");
        Deck.shuffle();
        System.out.println("Player one draws:");
        Card[] P1 = Deck.draw(5);
        for (Card card : P1) {System.out.println(card);}
        System.out.println();
        System.out.println("Player two draws:");
        Card[] P2 = Deck.draw(5);
        for (Card card : P2) {System.out.println(card);}
        System.out.println();
        Arrays.sort(P1);
        Arrays.sort(P2);
        System.out.println("SHOWDOWN!");
        System.out.println(P1[4]+ " vs "+P2[4]);
        if(P1[4].compareTo(P2[4])>0){System.out.println("Player one wins!");}else{ System.out.println("Player two wins!");}

        CardDeck Deck2 = new ListDeck("Integer");
        Deck.shuffle();
        System.out.println("Player one draws:");
        P1 = Deck.draw(5);
        for (Card card : P1) {System.out.println(card);}
        System.out.println();
        System.out.println("Player two draws:");
        P2 = Deck.draw(5);
        for (Card card : P2) {System.out.println(card);}
        System.out.println();
        Arrays.sort(P1);
        Arrays.sort(P2);
        System.out.println("SHOWDOWN!");
        System.out.println(P1[4]+ " vs "+P2[4]);
        if(P1[4].compareTo(P2[4])>0){System.out.println("Player one wins!");}else{ System.out.println("Player two wins!");}
    }
}

class Card<E extends Comparable<E>> implements Comparable<Card<E>>{
    String pattern;
    E rank;
    public Card(E rank,String pattern){
        this.pattern=pattern;this.rank=rank;
    }
    public static int tier(String pat){
        switch(pat.charAt(0)){
            case 's': return 3;
            case 'h': return 2;
            case 'c': return 1;
            case 'd': return 0;
        }
        return -1;
    }
    @Override
    public int compareTo(Card<E> o) {
        if(rank.compareTo(o.rank)>0){return 1;}
        if(rank.compareTo(o.rank)<0){return -1;}
        if(tier(pattern)>tier(o.pattern)){return 1;}
        if(tier(pattern)<tier(o.pattern)){return -1;}
        return 0;
    }
    @Override
    public String toString(){
        return rank.toString()+" of "+pattern;
    }
}
interface CardDeck{
    public void shuffle();
    public Card[] draw(int n);
    public String toString();
}

class ArrayDeck implements CardDeck{
    ArrayList<Card> deck;

    public ArrayDeck(String type){
        deck = new ArrayList<>();
        if(type.equals("Integer")){
            for(int i=0;i<10;i++){
                deck.add(new Card<Integer>(i,"spade"));
                deck.add(new Card<Integer>(i,"heart"));
                deck.add(new Card<Integer>(i,"club"));
                deck.add(new Card<Integer>(i,"diamond"));
            }
        }else{
            for(char i='A';i<='Z';i++){
                deck.add(new Card<Character>(i,"spade"));
                deck.add(new Card<Character>(i,"heart"));
                deck.add(new Card<Character>(i,"club"));
                deck.add(new Card<Character>(i,"diamond"));
            }
        }
    }
    @Override
    public void shuffle() {
        Collections.shuffle(deck);
    }

    @Override
    public Card[] draw(int n) {
        Card[] ret= new Card[n];
        for(int i=0;i<n;i++)ret[i]=deck.remove(deck.size()-1);
        return ret;
    }
    
    @Override
    public String toString(){
        return deck.toString();
    }
}
class ListDeck implements CardDeck{
    LinkedList<Card> deck;

    public ListDeck(String type){
        deck = new LinkedList<>();
        if(type.equals("Integer")){
            for(int i=0;i<10;i++){
                deck.add(new Card<Integer>(i,"spade"));
                deck.add(new Card<Integer>(i,"heart"));
                deck.add(new Card<Integer>(i,"club"));
                deck.add(new Card<Integer>(i,"diamond"));
            }
        }else{
            for(char i='A';i<='Z';i++){
                deck.add(new Card<Character>(i,"spade"));
                deck.add(new Card<Character>(i,"heart"));
                deck.add(new Card<Character>(i,"club"));
                deck.add(new Card<Character>(i,"diamond"));
            }
        }
    }
    @Override
    public void shuffle() {
        Collections.shuffle(deck);
    }

    @Override
    public Card[] draw(int n) {
        Card[] ret= new Card[n];
        for(int i=0;i<n;i++)ret[i]=deck.removeLast();
        return ret;
    }
    
    @Override
    public String toString(){
        return deck.toString();
    }
}
