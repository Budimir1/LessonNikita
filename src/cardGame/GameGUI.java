package cardGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GameGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel playersPanel;
    private JPanel controlPanel;
    private JLabel deckInfoLabel;
    private List<PlayerPanel> playerPanels;
    private List<Player> players;
    private Random random;
    private ArrayList<ImageIcon> cardImages;
    private JLabel cardLabel;
    private JDialog throwCardDialog;

    public GameGUI() {
        players = new ArrayList<>();
        playerPanels = new ArrayList<>();

        setTitle("Карточная Игра");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 700);

        // Создаем основную панель
        mainPanel = new JPanel(new BorderLayout());

        // Панель информации о колоде
        JPanel infoPanel = new JPanel();
        deckInfoLabel = new JLabel("Карт в колоде: 52");
        infoPanel.add(deckInfoLabel);
        mainPanel.add(infoPanel, BorderLayout.NORTH);

        // Панель игроков
        playersPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        playersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(playersPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Панель управления
        controlPanel = new JPanel(new FlowLayout());

        JButton addPlayerButton = new JButton("Добавить игрока");
        addPlayerButton.addActionListener(e -> addNewPlayer());

        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(e -> CardGame.newGame(players));

        JButton dealCardsButton = new JButton("Раздать карты");
        dealCardsButton.addActionListener(e -> dealCards());

        JButton throwCardWindowButton = new JButton("Подкинуть карту");
        throwCardWindowButton.addActionListener(e -> openThrowCardDialog());

        controlPanel.add(addPlayerButton);
        controlPanel.add(newGameButton);
        controlPanel.add(dealCardsButton);
        controlPanel.add(throwCardWindowButton);

        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setLocationRelativeTo(null);

        initializeThrowCardSystem();
    }

    private void initializeThrowCardSystem() {
        random = new Random();
        cardImages = new ArrayList<>();

        // Надо создать папку "cards" с картами!!!!
        for (int i = 1; i <= 52; i++) {
            // изображения с именами card1.png, card2.png, ..., card52.png
            cardImages.add(new ImageIcon("cards/card" + i + ".png"));
        }
    }

    private void openThrowCardDialog() {

        throwCardDialog = new JDialog(this, "Подкидывание карт", true);

        cardLabel = new JLabel();
        cardLabel.setHorizontalAlignment(JLabel.CENTER);
        cardLabel.setPreferredSize(new Dimension(200, 300));

        JButton throwButton = new JButton("Подкинуть карту");
        throwButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throwCard();
            }
        });

        throwCardDialog.setLayout(new BorderLayout());
        throwCardDialog.add(cardLabel, BorderLayout.CENTER);
        throwCardDialog.add(throwButton, BorderLayout.SOUTH);

        throwCardDialog.setTitle("Подкидывание карт");
        throwCardDialog.setSize(300, 400);
        throwCardDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        throwCardDialog.setLocationRelativeTo(this); // Центрируем относительно главного окна

        throwCardDialog.setVisible(true);
    }

    private void throwCard() {
        if (!cardImages.isEmpty()) {

            int randomIndex = random.nextInt(cardImages.size());
            ImageIcon randomCard = cardImages.get(randomIndex);

            cardLabel.setIcon(randomCard);

            cardLabel.setText("Карта #" + (randomIndex + 1));
            cardLabel.setVerticalTextPosition(JLabel.BOTTOM);
            cardLabel.setHorizontalTextPosition(JLabel.CENTER);
        } else {

            cardLabel.setText("Изображения карт не загружены!");
            cardLabel.setIcon(null);
        }
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