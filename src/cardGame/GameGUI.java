package cardGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel playersPanel;
    private JPanel controlPanel;
    private JLabel deckInfoLabel;
    private List<PlayerPanel> playerPanels;
    private List<Player> players;

    public GameGUI() {
        players = new ArrayList<>();
        playerPanels = new ArrayList<>();

        setTitle("Карточная Игра");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 700);

        mainPanel = new JPanel(new BorderLayout());

        JPanel infoPanel = new JPanel();
        deckInfoLabel = new JLabel("Карт в колоде: 52");
        infoPanel.add(deckInfoLabel);
        mainPanel.add(infoPanel, BorderLayout.NORTH);

        playersPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        playersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(playersPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        controlPanel = new JPanel(new FlowLayout());

        JButton addPlayerButton = new JButton("Добавить игрока");
        addPlayerButton.addActionListener(e -> addNewPlayer());

        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(e -> CardGame.newGame(players));

        JButton dealCardsButton = new JButton("Раздать карты");
        dealCardsButton.addActionListener(e -> dealCards());

        controlPanel.add(addPlayerButton);
        controlPanel.add(newGameButton);
        controlPanel.add(dealCardsButton);

        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setLocationRelativeTo(null);
    }

    private void addNewPlayer() {
        Player player = CardGame.createPlayer();
        addPlayer(player);
        updateGameState();
    }

    public void addPlayer(Player player) {
        players.add(player);
        PlayerPanel playerPanel = new PlayerPanel(player);
        playerPanels.add(playerPanel);
        playersPanel.add(playerPanel);
        revalidate();
        repaint();
    }

    private void dealCards() {
        Stack<String> deck = CardGame.cardDeck();
        for (Player player : players) {
            player.resetHand();
            CardGame.dealCards(deck, player, 5);
        }
        updateGameState();
    }

    public void updateGameState() {
        for (PlayerPanel panel : playerPanels) {
            panel.updateCards();
        }
        deckInfoLabel.setText("Игроков: " + players.size());
        revalidate();
        repaint();
    }

    public List<Player> getPlayers() {
        return players;
    }
}