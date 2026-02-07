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

    // Панель для стола с картами
    private JPanel tablePanel;
    private JLabel tableInfoLabel;

    // Панель для колоды и козыря
    private JPanel deckAreaPanel;
    private JLabel deckLabel;          // Колода
    private JLabel trumpCardLabel;     // Козырь

    private Stack<String> currentDeck;
    private String trumpCard;

    // Для функционала подкидывания карт
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
        setSize(1200, 800);

        // Создаем основную панель
        mainPanel = new JPanel(new BorderLayout());

        //ПАНЕЛЬ ИГРОКОВ
        playersPanel = new JPanel(new GridLayout(1, 0, 10, 10));
        playersPanel.setBorder(BorderFactory.createTitledBorder("Игроки"));
        playersPanel.setBackground(new Color(240, 240, 240));

        mainPanel.add(playersPanel, BorderLayout.SOUTH);

        // ========== ПАНЕЛЬ СТОЛА И КОЛОДЫ (ЦЕНТР) ==========
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(new Color(34, 139, 34)); // Зеленый стол

        // Информация о столе
        JPanel tableInfoPanel = new JPanel();
        tableInfoLabel = new JLabel("Стол для карт", SwingConstants.CENTER);
        tableInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tableInfoLabel.setForeground(Color.WHITE);
        tableInfoPanel.setBackground(new Color(34, 139, 34));
        tableInfoPanel.add(tableInfoLabel);

        tablePanel.add(tableInfoPanel, BorderLayout.NORTH);

        // Размещение карт на столе
        JPanel cardsOnTablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        cardsOnTablePanel.setBackground(new Color(34, 139, 34));
        cardsOnTablePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ОБЛАСТЬ КОЛОДЫ И КОЗЫРЯ НА СТОЛЕ
        deckAreaPanel = new JPanel();
        deckAreaPanel.setLayout(null);
        deckAreaPanel.setPreferredSize(new Dimension(200, 200));
        deckAreaPanel.setOpaque(false);

        // Колода
        deckLabel = new JLabel();
        deckLabel.setBounds(30, 75, 140, 100); // x, y, ширина, высота
        deckLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        deckLabel.setBackground(new Color(220, 220, 255));
        deckLabel.setOpaque(true);
        deckLabel.setHorizontalAlignment(JLabel.CENTER);
        deckLabel.setVerticalAlignment(JLabel.CENTER);
        deckLabel.setText("Колода");
        deckLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Козырь
        trumpCardLabel = new JLabel();
        trumpCardLabel.setBounds(50, 40, 100, 150);
        trumpCardLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        trumpCardLabel.setBackground(Color.WHITE);
        trumpCardLabel.setOpaque(true);
        trumpCardLabel.setHorizontalAlignment(JLabel.CENTER);
        trumpCardLabel.setVerticalAlignment(JLabel.CENTER);

        // Добавляем колоду и козырь на панель (важен порядок - сначала козырь, потом колода)
        deckAreaPanel.add(trumpCardLabel);
        deckAreaPanel.add(deckLabel);

        // Добавляем область колоды на стол
        cardsOnTablePanel.add(deckAreaPanel);

        // Область для карт, которые игроки кладут на стол
        JPanel playedCardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        playedCardsPanel.setBackground(new Color(34, 139, 34));
        playedCardsPanel.setPreferredSize(new Dimension(600, 200));

        // Добавляем обе области на панель стола
        JPanel tableCenterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        tableCenterPanel.setBackground(new Color(34, 139, 34));
        tableCenterPanel.add(deckAreaPanel);
        tableCenterPanel.add(playedCardsPanel);

        tablePanel.add(tableCenterPanel, BorderLayout.CENTER);

        // Информация о колоде внизу стола
        JPanel deckInfoPanel = new JPanel();
        deckInfoLabel = new JLabel("Карт в колоде: 52", SwingConstants.CENTER);
        deckInfoLabel.setFont(new Font("Arial", Font.BOLD, 14));
        deckInfoLabel.setForeground(Color.WHITE);
        deckInfoPanel.setBackground(new Color(34, 139, 34));
        deckInfoPanel.add(deckInfoLabel);

        tablePanel.add(deckInfoPanel, BorderLayout.SOUTH);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // ПАНЕЛЬ УПРАВЛЕНИЯ
        controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addPlayerButton = new JButton("Добавить игрока");
        addPlayerButton.addActionListener(e -> addNewPlayer());

        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(e -> {
            CardGame.newGame(players);
            updateGameState();
        });

        JButton dealCardsButton = new JButton("Раздать карты");
        dealCardsButton.addActionListener(e -> dealCards());

        // Кнопка для окна подкидывания карт
        JButton throwCardWindowButton = new JButton("Подкинуть карту");
//        throwCardWindowButton.addActionListener(e -> openThrowCardDialog());

        // Кнопка для очистки стола
        JButton clearTableButton = new JButton("Очистить стол");
        clearTableButton.addActionListener(e -> clearTable());

        controlPanel.add(addPlayerButton);
        controlPanel.add(newGameButton);
        controlPanel.add(dealCardsButton);
        controlPanel.add(throwCardWindowButton);
        controlPanel.add(clearTableButton);

        mainPanel.add(controlPanel, BorderLayout.NORTH);

        add(mainPanel);
        setLocationRelativeTo(null);

        // Инициализация для подкидывания карт
//        initializeThrowCardSystem();

        // Начальная и козырь
        initializeDeckAndTrump();
    }

    // ИНИЦИАЛИЗАЦИЯ КОЛОДЫ И КОЗЫРЯ
    private void initializeDeckAndTrump() {
        currentDeck = CardGame.cardDeck();
        updateTrumpCard();
        updateDeckInfo();
    }

    // ОБНОВЛЕНИЕ КОЗЫРЯ
    private void updateTrumpCard() {
        if (currentDeck != null && !currentDeck.isEmpty()) {
            Random rand = new Random();
            int trumpIndex = rand.nextInt(currentDeck.size());
            trumpCard = currentDeck.get(trumpIndex);


            displayTrumpCardVertical(trumpCard);
        } else {
            trumpCard = null;
            trumpCardLabel.setText("Нет козыря");
            trumpCardLabel.setIcon(null);
        }
    }

    //ОТОБРАЖЕНИЯ КОЗЫРЯ
    private void displayTrumpCardVertical(String card) {
        if (card != null) {
            // Создаем вертикальную панель карты
            JPanel cardPanel = new JPanel();
            cardPanel.setLayout(new BorderLayout());
            cardPanel.setPreferredSize(new Dimension(90, 140)); // Вертикальная карта

            // Определяем цвет масти
            Color suitColor = card.startsWith("♥") || card.startsWith("♦") ? Color.RED : Color.BLACK;
            cardPanel.setBackground(Color.WHITE);
            cardPanel.setBorder(BorderFactory.createLineBorder(suitColor, 2));

            // Верхний угол
            JLabel topLabel = new JLabel(card);
            topLabel.setFont(new Font("Arial", Font.BOLD, 10));
            topLabel.setForeground(suitColor);
            topLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Центр (масть)
            JLabel centerLabel = new JLabel(card.substring(0, 1), SwingConstants.CENTER);
            centerLabel.setFont(new Font("Arial", Font.BOLD, 24));
            centerLabel.setForeground(suitColor);

            // Нижний угол
            JLabel bottomLabel = new JLabel(card);
            bottomLabel.setFont(new Font("Arial", Font.BOLD, 10));
            bottomLabel.setForeground(suitColor);
            bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Для вертикальной карты - поворачиваем метки
            topLabel.setLayout(new BorderLayout());
            centerLabel.setLayout(new BorderLayout());
            bottomLabel.setLayout(new BorderLayout());

            cardPanel.add(topLabel, BorderLayout.NORTH);
            cardPanel.add(centerLabel, BorderLayout.CENTER);
            cardPanel.add(bottomLabel, BorderLayout.SOUTH);

            // Конвертируем панель в изображение
            cardPanel.setSize(new Dimension(90, 140));
            java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(
                    cardPanel.getWidth(), cardPanel.getHeight(), java.awt.image.BufferedImage.TYPE_INT_ARGB);
            Graphics g = image.getGraphics();
            cardPanel.paint(g);
            g.dispose();

            trumpCardLabel.setIcon(new ImageIcon(image));
            trumpCardLabel.setText("");

            // Обновляем текст на колоде
            if (currentDeck != null) {
                deckLabel.setText("Карт: " + currentDeck.size());
            }
        }
    }

    private void updateDeckInfo() {
        if (currentDeck != null) {
            deckInfoLabel.setText("Карт в колоде: " + currentDeck.size());


            if (currentDeck.size() == 0) {
                deckLabel.setText("Пусто");
                deckLabel.setBackground(Color.LIGHT_GRAY);
            } else {
                deckLabel.setText("Карт: " + currentDeck.size());
                deckLabel.setBackground(new Color(220, 220, 255));
            }
        } else {
            deckInfoLabel.setText("Колода не создана");
        }
    }


    public void addCardToTable(String card, String playerName) {
        // Находим панель для карт на столе (вторая панель в tableCenterPanel)
        JPanel tableCenterPanel = (JPanel)((JPanel)tablePanel.getComponent(1)).getComponent(0);
        JPanel playedCardsPanel = (JPanel)tableCenterPanel.getComponent(1);

        // Панель для карты на столе
        JPanel tableCardPanel = new JPanel(new BorderLayout());
        tableCardPanel.setPreferredSize(new Dimension(80, 120));
        tableCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        tableCardPanel.setBackground(Color.WHITE);

        // Цвет масти
        Color suitColor = card.startsWith("♥") || card.startsWith("♦") ? Color.RED : Color.BLACK;

        // Верхний угол
        JLabel topLabel = new JLabel(card);
        topLabel.setFont(new Font("Arial", Font.BOLD, 10));
        topLabel.setForeground(suitColor);
        topLabel.setBorder(BorderFactory.createEmptyBorder(3, 3, 0, 0));

        // Центр
        JLabel centerLabel = new JLabel(card.substring(0, 1), SwingConstants.CENTER);
        centerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        centerLabel.setForeground(suitColor);

        // Нижний угол
        JLabel bottomLabel = new JLabel(card);
        bottomLabel.setFont(new Font("Arial", Font.BOLD, 10));
        bottomLabel.setForeground(suitColor);
        bottomLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 3));
        bottomLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Метка с именем игрока
        JLabel playerLabel = new JLabel(playerName, SwingConstants.CENTER);
        playerLabel.setFont(new Font("Arial", Font.PLAIN, 8));
        playerLabel.setForeground(Color.DARK_GRAY);

        tableCardPanel.add(topLabel, BorderLayout.NORTH);
        tableCardPanel.add(centerLabel, BorderLayout.CENTER);
        tableCardPanel.add(bottomLabel, BorderLayout.SOUTH);
        tableCardPanel.add(playerLabel, BorderLayout.NORTH);

        // Всплывающая подсказка
        tableCardPanel.setToolTipText(card + " от " + playerName);

        playedCardsPanel.add(tableCardPanel);
        playedCardsPanel.revalidate();
        playedCardsPanel.repaint();

        // Обновляем информацию на столе
        tableInfoLabel.setText("На столе " + playedCardsPanel.getComponentCount() + " карт");
    }

    // ОЧИСТКА СТОЛА
    public void clearTable() {
        // Панель для карт на столе
        JPanel tableCenterPanel = (JPanel)((JPanel)tablePanel.getComponent(1)).getComponent(0);
        JPanel playedCardsPanel = (JPanel)tableCenterPanel.getComponent(1);

        playedCardsPanel.removeAll();
        tableInfoLabel.setText("Стол для карт");
        playedCardsPanel.revalidate();
        playedCardsPanel.repaint();
    }

    // МЕТОДЫ ДЛЯ ПОДКИДЫВАНИЯ КАРТ.....
//    private void initializeThrowCardSystem() {
//        random = new Random();
//        cardImages = new ArrayList<>();
//
//        for (int i = 1; i <= 52; i++) {
//            cardImages.add(new ImageIcon("cards/card" + i + ".png"));
//        }
//    }
//
//    private void openThrowCardDialog() {
//        throwCardDialog = new JDialog(this, "Подкидывание карт", true);
//
//        cardLabel = new JLabel();
//        cardLabel.setHorizontalAlignment(JLabel.CENTER);
//        cardLabel.setPreferredSize(new Dimension(200, 300));
//
//        JButton throwButton = new JButton("Подкинуть карту");
//        throwButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                throwCard();
//            }
//        });
//
//        throwCardDialog.setLayout(new BorderLayout());
//        throwCardDialog.add(cardLabel, BorderLayout.CENTER);
//        throwCardDialog.add(throwButton, BorderLayout.SOUTH);
//
//        throwCardDialog.setTitle("Подкидывание карт");
//        throwCardDialog.setSize(300, 400);
//        throwCardDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        throwCardDialog.setLocationRelativeTo(this);
//
//        throwCardDialog.setVisible(true);
//    }
//
//    private void throwCard() {
//        if (!cardImages.isEmpty()) {
//            int randomIndex = random.nextInt(cardImages.size());
//            ImageIcon randomCard = cardImages.get(randomIndex);
//
//            cardLabel.setIcon(randomCard);
//            cardLabel.setText("Карта #" + (randomIndex + 1));
//            cardLabel.setVerticalTextPosition(JLabel.BOTTOM);
//            cardLabel.setHorizontalTextPosition(JLabel.CENTER);
//        } else {
//            cardLabel.setText("Изображения карт не загружены!");
//            cardLabel.setIcon(null);
//        }
//    }


    private void addNewPlayer() {
        Player player = CardGame.createPlayer();
        addPlayer(player);
        updateGameState();
    }

    public void addPlayer(Player player) {
        players.add(player);
        PlayerPanel playerPanel = new PlayerPanel(player);
        playerPanels.add(playerPanel);


        if (players.size() <= 4) {
            playersPanel.add(playerPanel);
        } else {

            JOptionPane.showMessageDialog(this,
                    "Слишком много игроков! Максимум 4 для комфортного отображения.",
                    "Предупреждение", JOptionPane.WARNING_MESSAGE);
            players.remove(player);
            return;
        }

        // Перераспределяем пространство
        playersPanel.revalidate();
        playersPanel.repaint();
        updateGameState();
    }

    private void dealCards() {
        if (players.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Сначала добавьте игроков!");
            return;
        }

        Stack<String> deck = CardGame.cardDeck();
        currentDeck = deck;
        updateTrumpCard();

        for (Player player : players) {
            player.resetHand();
            CardGame.dealCards(deck, player, 5);
        }

        updateGameState();
        updateDeckInfo();
        clearTable(); // Очищаем стол при новой раздаче
    }

    public void updateGameState() {
        for (PlayerPanel panel : playerPanels) {
            panel.updateCards();
        }
        revalidate();
        repaint();
    }

    public List<Player> getPlayers() {
        return players;
    }
}