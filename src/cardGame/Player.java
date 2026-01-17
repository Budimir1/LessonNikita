package cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> hand;
    public String name;
    public static List<String> card;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public List<String> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<String> getCardHand() {
        return card;
    }

    public void setCardHand(List<String> cardHand) {
        this.card = cardHand;
    }


    public void resetHand() {
        hand.clear(); // Очистка руки
    }


    public void addCard(String card) {
        hand.add(card);
    }
}
