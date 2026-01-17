package cardGame;

import java.util.*;
import javax.swing.*;

public class CardGame {


    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<String> allCards = new ArrayList();
    public static String[] cardMasty = {"♥", "♦", "♠", "♣"};
    public static String[] numCard = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public static Stack<String> cardDeck(){
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


    public static Player profile(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        return new Player(name);
    }

    public static void cards(Stack<String> deck, Player player, int numOfCards){
        for (int i = 0; i < numOfCards; i++) {
            if (!deck.empty()) {
                player.addCard(deck.pop());
            }
        }
    }


    public static void changeCards(List <Player> players){
        cardDeck();
        for (Player player : players) {
            player.resetHand();
        }
        System.out.println("Игра сброшена. Новая колода и карты сброшены у игроков.");
    }





    public static void main(String[] args) {
        Stack<String> deck = cardDeck();
        Player player = profile();
        cards(deck, player, 5);

        Player player2 = profile();
        cards(deck, player2, 5);


        JFrame frame = new JFrame("Игрове поле");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JButton play = new JButton("Игрок: " + player.getName());
        JButton comp = new JButton("Компьютер:  " + player2.getName());

        JPanel panel = new JPanel();
        panel.add(play);
        panel.add(comp);

        frame.getContentPane().add(panel);

        frame.setVisible(true);


//        System.out.println(player.getName());
//        System.out.println(player.getHand());
//
//
//        System.out.println(player2.getName());
//        System.out.println(player2.getHand());


//        ArrayList <Player> players = new ArrayList<>();
//        players.add(profile());
//        changeCards(players);
    }
}
