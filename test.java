import java.util.*;

public class test {

    public static void main(String[] args) {
        LinkedListPlayCard cd1 = new LinkedListPlayCard("Player 1");
        LinkedListPlayCard cd2 = new LinkedListPlayCard("Player 2");

        System.out.println("Card in deck left: " + LinkedListPlayCard.totalCard);
        while(true) {
            if(cd1.draw(5) == (null)) {
                break;
            }
            if(cd2.draw(5) == (null)) {
                break;
            }
            System.out.println(cd1.getPlayer() + "\'s cards \n" + cd1.showHandCard());
            System.out.println(cd2.getPlayer() + "\'s cards \n" + cd2.showHandCard());

            Card max_1 = cd1.getCardHand().get(0);
            for(int i = 1; i < cd1.getCardHand().size(); i++) {
                int temp = cd1.getCardHand().get(i).compareTo(max_1);
                if(temp == 1) {
                    max_1 = cd1.getCardHand().get(i);
                }
            }

            Card max_2 = cd2.getCardHand().get(0);
            for(int i = 1; i < cd2.getCardHand().size(); i++) {
                int temp = cd2.getCardHand().get(i).compareTo(max_2);
                if(temp == 1) {
                    max_2 = cd2.getCardHand().get(i);
                }
            }

            switch(max_1.compareTo(max_2)) {
                case 1:
                    System.out.println(cd1.getPlayer() + " has the largest card, which is " + max_1);
                    break;
                case -1:
                    System.out.println(cd2.getPlayer() + " has the largest card, which is " + max_2);
                    break;
                default:
                    System.out.println("There is no largest card in this turn.");
                    break;
            }
            System.out.println("Card in deck left: " + LinkedListPlayCard.totalCard);
            System.out.println("=====================================");
        }

    }

}

interface CardDeck {

    static final HashMap<Integer, String> pattern = new HashMap<>() {
        {
            put(0, "Diamond");
            put(1, "Club");
            put(2, "Heart");
            put(3, "Spade");
        }

    };
  

    public void shuffle();
    
    public List draw(int times);

    @Override
    public String toString();

}

class LinkedListPlayCard implements CardDeck {

    public static int totalCard = 144;
    private static LinkedList<Card> cardDeck = new LinkedList<>();
    private LinkedList<Card> cardHand = new LinkedList<>();
    private String player;

    public LinkedListPlayCard(String name) {
        if(cardDeck.isEmpty()) {

            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 36; j++) {
                    if(j < 10) {
                        cardDeck.add(new Card(j, i));
                    }
                    else {
                        cardDeck.add(new Card((char) (j + 55), i));
                    }
                }
            }
            shuffle();
        }
        player = name;
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cardDeck);
    }

    @Override
    public LinkedList<Card> draw(int times) {
        if(!(totalCard - (times) < 1)) {
            cardHand.clear();
            for(int i = 0; i < times; i++) {
                cardHand.add(cardDeck.remove(0));
                totalCard--;
            }
            return cardHand;
        }
        else {
            System.out.println("The cards in deck are not enough");
            return null;
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int c = 0;
        for(Card x : cardDeck) {
            str.append(x.toString()).append("   ");
            c++;
            if(c == 3) {
                str.append("\n");
                c = 0;
            }
        }
        return str.toString();
    }

    public String showHandCard() {
        StringBuilder str = new StringBuilder();
        int c = 0;
        for(Card x : cardHand) {
            str.append(x.toString()).append("   ");
            c++;
            if(c == 3) {
                str.append("\n");
                c = 0;
            }
        }
        return str.toString();
    }

    public static int getTotalCard() {
        return totalCard;
    }

    public static LinkedList<Card> getCardDeck() {
        return cardDeck;
    }

    public LinkedList<Card> getCardHand() {
        return cardHand;
    }

    public String getPlayer() {
        return player;
    }

}

class Card<E extends Comparable<E>> implements Comparable<Card<E>> {

    E rank;
    int pattern = -1;
    boolean isInteger = false;
    boolean isCharacter = false;

    public Card(E x, int pat) {
        rank = x;
        pattern = pat;
        isInteger = x instanceof Integer;
        isCharacter = x instanceof Character;
    }

    @Override
    public int compareTo(Card<E> o) {
        if(this.isInteger && o.isInteger) {
            if((Integer) this.rank > (Integer) o.rank) {
                return 1;
            }
            else if((Integer) this.rank < (Integer) o.rank) {
                return -1;
            }
        }
        else if(this.isInteger && o.isCharacter) {
            if((Integer) this.rank > (Character) o.rank - 55) {
                return 1;
            }
            else if((Integer) this.rank < (Character) o.rank - 55) {
                return -1;
            }
        }
        else if(this.isCharacter && o.isInteger) {
            if((Character) this.rank > (Integer) o.rank - 55) {
                return 1;
            }
            else if((Character) this.rank < (Integer) o.rank - 55) {
                return -1;
            }
        }
        else if(this.isCharacter && o.isCharacter) {
            if((Character) this.rank > (Character) o.rank) {
                return 1;
            }
            else if((Character) this.rank < (Character) o.rank) {
                return -1;
            }
        }
        else if(this.pattern > o.pattern) {
            return 1;
        }
        else if(this.pattern < o.pattern) {
            return -1;
        }
        return 0;
    }

    public String toString() {

            return CardDeck.pattern.get(pattern) + "\t- " + rank.toString();
        

    }

}

