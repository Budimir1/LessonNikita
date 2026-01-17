package cardGame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CardGame {
    public static String[] cardMasty = {"♥", "♦", "♠", "♣"};
    public static String[] numCard = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public static List<String> allCards = new ArrayList<>();
    private static GameGUI gameGUI;

    public static Stack<String> cardDeck() {
        allCards.clear();
        for (String masty : cardMasty) {
            for (String num : numCard) {
                allCards.add(masty + num);
            }
        }
        Collections.shuffle(allCards);

        Stack<String> deck = new Stack<>();
        deck.addAll(allCards);

        return deck;
    }

    public static Player createPlayer() {
        String name = JOptionPane.showInputDialog(null, "Введите имя игрока:",
                "Создание игрока", JOptionPane.QUESTION_MESSAGE);
        if (name == null || name.trim().isEmpty()) {
            name = "Игрок " + (gameGUI.getPlayers().size() + 1);
        }
        return new Player(name);
    }

    public static void dealCards(Stack<String> deck, Player player, int numOfCards) {
        for (int i = 0; i < numOfCards; i++) {
            if (!deck.isEmpty()) {
                player.addCard(deck.pop());
            }
        }
    }

    public static void newGame(List<Player> players) {
        Stack<String> deck = cardDeck();
        for (Player player : players) {
            player.resetHand();
            dealCards(deck, player, 5);
        }
        gameGUI.updateGameState();
        JOptionPane.showMessageDialog(null, "Новая игра началась!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            gameGUI = new GameGUI();
            gameGUI.setVisible(true);

            // Создаем начальных игроков
            Player player1 = createPlayer();
            Player player2 = createPlayer();

            Stack<String> deck = cardDeck();
            dealCards(deck, player1, 5);
            dealCards(deck, player2, 5);

            gameGUI.addPlayer(player1);
            gameGUI.addPlayer(player2);
            gameGUI.updateGameState();
        });
    }

    public static GameGUI getGameGUI() {
        return gameGUI;
    }
}