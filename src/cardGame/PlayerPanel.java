package cardGame;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class PlayerPanel extends JPanel {
    private Player player;
    private JLabel nameLabel;
    private JPanel cardsPanel;
    private static final Map<String, String> cardImages = new HashMap<>();

    static {
        String[] suits = {"♥", "♦", "♠", "♣"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String value : values) {
                String card = suit + value;

                // cardImages.put(card, "images/cards/" + value + "_" + suit + ".png");
                cardImages.put(card, getCardUnicode(suit, value));
            }
        }
    }

    public PlayerPanel(Player player) {
        this.player = player;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(""));

        nameLabel = new JLabel(player.getName(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(nameLabel, BorderLayout.NORTH);

        cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        updateCards();
        add(cardsPanel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        JLabel cardsCountLabel = new JLabel("Карт: " + player.getHand().size());
        infoPanel.add(cardsCountLabel);
        add(infoPanel, BorderLayout.SOUTH);
    }

    public void updateCards() {
        cardsPanel.removeAll();
        nameLabel.setText(player.getName() + " (Карт: " + player.getHand().size() + ")");

        for (String card : player.getHand()) {
            JPanel cardPanel = createCardPanel(card);
            cardsPanel.add(cardPanel);
        }

        revalidate();
        repaint();
    }

    private JPanel createCardPanel(String card) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(80, 120));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Color suitColor = card.startsWith("♥") || card.startsWith("♦") ? Color.RED : Color.BLACK;

        JLabel topLabel = new JLabel(card);
        topLabel.setFont(new Font("Arial", Font.BOLD, 14));
        topLabel.setForeground(suitColor);
        panel.add(topLabel, BorderLayout.NORTH);

        JLabel centerLabel = new JLabel(getCardSymbol(card), SwingConstants.CENTER);
        centerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        centerLabel.setForeground(suitColor);
        panel.add(centerLabel, BorderLayout.CENTER);

        JLabel bottomLabel = new JLabel(card);
        bottomLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bottomLabel.setForeground(suitColor);
        bottomLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(bottomLabel, BorderLayout.SOUTH);


        panel.setToolTipText(card);

        return panel;
    }

    private String getCardSymbol(String card) {
        String suit = card.substring(0, 1);
        String value = card.substring(1);

        if (value.equals("J")) return "J";
        if (value.equals("Q")) return "Q";
        if (value.equals("K")) return "K";
        if (value.equals("A")) return "A";

        return value;
    }

    private static String getCardUnicode(String suit, String value) {
        return suit + value;
    }
}