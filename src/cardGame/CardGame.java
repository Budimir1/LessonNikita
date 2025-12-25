package cardGame;

import java.util.*;

public class CardGame {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<String> allCards = new ArrayList();

    public static Stack<String> cardDeck(){
        String[] cardMasty = {"♥", "♦", "♠", "♣"};

        String[] numCard = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String masty: cardMasty) {
            for (String num: numCard) {
                allCards.add(masty + num);
            }
        }
        Collections.shuffle(allCards);

        Stack<String> deck = new Stack<>();

        for (String card: allCards) {
            deck.push(card);
        }

        System.out.println(deck);
        System.out.println(deck.size());

        return deck;
    }

    public static void dealCard(Stack<String> deck, List<String> playerHand, int numOfCards){
        for (int i = 0; i < numOfCards; i++) {
            if (!deck.empty()) {
                playerHand.add(deck.pop());
            }
        }
    }



    public static void main(String[] args) {
        Stack<String> deck = cardDeck();

    }
}
