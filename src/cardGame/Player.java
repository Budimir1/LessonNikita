package cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<String> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHand() {
        return hand;
    }

    public void setHand(List<String> hand) {
        this.hand = hand;
    }

    public void addCard(String card) {
        hand.add(card);
    }

    public void resetHand() {
        hand.clear();
    }

    @Override
    public String toString() {
        return name + " (карт: " + hand.size() + ")";
    }
}