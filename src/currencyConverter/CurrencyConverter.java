package currencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CurrencyConverter {

    private HashMap<String, Double> rates;

    String[][] currency = {
            {"USD"},
            {"EUR"},
            {"RUB"}
    };

    public CurrencyConverter() {
        JFrame converter = new JFrame("Converter");
        converter.setSize(1000, 400);
        converter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridBagLayout для фрейма
        converter.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Основная панель для ввода
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Введите сумму которую хотели бы конвертировать");
        JTextField input, result;
        JButton lastResult = new JButton("Конвертировать");
        input = new JTextField(15);
        result = new JTextField(15);

        // Панель для кнопок конвертации
        JPanel buttonPanel = new JPanel();

        // Добавление места ввода
        panel.add(label);
        panel.add(input);
        panel.add(lastResult);
        panel.add(result);
        input.setToolTipText("");
        result.setToolTipText("");

        // Настройка GridBagLayout
        gbc.gridx = 0; // Позиция по горизонтале в сетке 1 столбец
        gbc.gridy = 0; // Позиция по вертикале в сетке 1 строка
        gbc.weightx = 1; // 1 означает что компонент получит всё доступное дополнительное пространство по горизонтали
        gbc.weighty = 0; // 0 означает, что компонент НЕ будет получать дополнительное вертикальное пространство, сохраняя свою исходную высоту.
        gbc.fill = GridBagConstraints.HORIZONTAL; // растягивается по горизонтали
        gbc.anchor = GridBagConstraints.CENTER; // Центрирование как по горизонтали так и по вертикали
        gbc.insets = new Insets(10,10,10,10); // Отступы
        converter.add(panel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;  // растягивается по вертикали
        gbc.fill = GridBagConstraints.BOTH;  // растягивается во всех направлениях
        converter.add(buttonPanel, gbc);

        rates = new HashMap<>();
        initRates();

        JButton USDEUR = new JButton("Доллар ➔ Евро");
        JButton USDRUB = new JButton("Доллар ➔ Рубль");
        USDEUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == USDEUR) {
                    getExchangesRate("USD", "EUR");
                    System.out.println("Доллар ➔ Евро");
                } else if (e.getSource() == USDRUB) {
                    getExchangesRate("USD", "RUB");
                    System.out.println("Доллар ➔ Рубль");
                }
            }
        });
        USDRUB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == USDRUB) {
                    getExchangesRate("USD", "RUB");
                    System.out.println("Доллар ➔ Рубль");
                } else if (e.getSource() == USDEUR) {
                    getExchangesRate("USD", "EUR");
                    System.out.println("Доллар ➔ Евро");
                }
            }
        });

        JButton EURUSD = new JButton("Евро ➔ Доллар");
        JButton EURRUB = new JButton("Евро ➔ Рубль");
        EURUSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == EURUSD) {
                    getExchangesRate("EUR", "USD");
                    System.out.println("Евро ➔ Доллар");
                } else if (e.getSource() == EURRUB) {
                    getExchangesRate("EUR", "RUB");
                    System.out.println("Евро ➔ Рубль");
                }
            }
        });
        EURRUB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == EURRUB) {
                    getExchangesRate("EUR", "RUB");
                    System.out.println("Евро ➔ Рубль");
                } else if (e.getSource() == EURUSD) {
                    getExchangesRate("EUR", "USD");
                    System.out.println("Евро ➔ Доллар");
                }
            }
        });

        JButton RUBUSD = new JButton("Рубль ➔ Доллар");
        JButton RUBEUR = new JButton("Рубль ➔ Евро");
        RUBUSD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == RUBUSD) {
                    getExchangesRate("RUB", "USD");
                    System.out.println("Рубль ➔ Доллар");
                } else if (e.getSource() == RUBEUR) {
                    getExchangesRate("RUB", "EUR");
                    System.out.println("Рубль ➔ Евро");
                }
            }
        });
        RUBEUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == RUBEUR) {
                    getExchangesRate("RUB", "EUR");
                    System.out.println("Рубль ➔ Евро");
                } else if (e.getSource() == RUBUSD) {
                    getExchangesRate("RUB", "USD");
                    System.out.println("Рубль ➔ Доллар");
                }
            }
        });

        buttonPanel.add(USDEUR);
        buttonPanel.add(USDRUB);
        buttonPanel.add(EURUSD);
        buttonPanel.add(EURRUB);
        buttonPanel.add(RUBUSD);
        buttonPanel.add(RUBEUR);

        converter.setVisible(true);
    }

    public class PressButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void initRates(){
        rates.put("USD", 76.91);
        rates.put("EUR", 91.11);
        rates.put("RUB", 1.0);
    }

    private double getExchangesRate(String from, String to){
        double fromRate = rates.get(from);
        double toRate = rates.get(to);
        return fromRate / toRate;
    }

    public static void main(String[] args) {
        new CurrencyConverter();


    }
}