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
    } //thhewrtheyjrty

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHand() {
        return hand;
    } //hrtwhrtht

    public void setHand(List<String> hand) {
        this.hand = hand;
    }

    public void addCard(String card){
        hand.add(card);
    } //gfhgfhrgfhgf
    public void resetHand() {
        hand.clear();
    }
}
