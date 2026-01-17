package exemple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

class Player {
    private String name;
    private List<String> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCard(String card) {
        hand.add(card);
    }

    public List<String> getHand() {
        return hand;
    }

    public void resetHand() {
        hand.clear();
    }
}

public class CardGame1 {
    public static Scanner scanner = new Scanner(System.in);
    public static Stack<String> deck;

    public static Stack<String> cardDeck() {
        ArrayList<String> allCards = new ArrayList<>();
        String[] cardMasty = {"♥️", "♦️", "♠️", "♣️"};
        String[] numCard = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String masty : cardMasty) {
            for (String num : numCard) {
                allCards.add(masty + num);
            }
        }
        Collections.shuffle(allCards);

        Stack<String> newDeck = new Stack<>();
        newDeck.addAll(allCards);
        return newDeck;
    }

    public static Player profile() {
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        return new Player(name);
    }

    public static void dealCard(Player player, int numOfCards) {
        for (int i = 0; i < numOfCards; i++) {
            if (!deck.empty()) {
                player.addCard(deck.pop());
            }
        }
    }

    public static void main(String[] args) {
        deck = cardDeck();
        Player player = profile();
        dealCard(player, 5);

        Player player2 = profile();
        dealCard(player2, 5);

        JFrame frame = new JFrame("Игровое поле");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JButton playerButton = new JButton(player.getName() + ": " + player.getHand());
        JButton computerButton = new JButton(player2.getName() + ": " + player2.getHand());

        JPanel panel = new JPanel();
        panel.add(playerButton);
        panel.add(computerButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}