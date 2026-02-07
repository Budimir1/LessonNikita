package currencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter {

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

        JButton USDEUR = new JButton("Доллар ➔ Евро");
        JButton USDRUB = new JButton("Доллар ➔ Рубль");
        JButton EURUSD = new JButton("Евро ➔ Доллар");
        JButton EURRUB = new JButton("Евро ➔ Рубль");
        JButton RUBUSD = new JButton("Рубль ➔ Доллар");
        JButton RUBEUR = new JButton("Рубль ➔ Евро");

        buttonPanel.add(USDEUR);
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

    public void Converter(){
        double USD = 76.91;
        double UER = 91.11;
        double RUB = 1;
    }

    public static void main(String[] args) {
    new CurrencyConverter();

    }
}
