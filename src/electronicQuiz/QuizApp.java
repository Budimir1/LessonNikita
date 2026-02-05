package electronicQuiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QuizApp extends JFrame {
    private JLabel questionLabel;
    private JRadioButton[] options;
    private JButton nextButton;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private int score = 0;
    private int currentQuestion = 0;
    private int timeLeft = 30;
    private javax.swing.Timer timer;

    // Вопросы
    String[][] questions = {
            {"Столица Франции?", "Лондон", "Берлин", "Париж", "Мадрид", "3"},
            {"Сколько планет в Солнечной системе?", "7", "8", "9", "10", "2"},
            {"Какой язык мы изучаем?", "Python", "C++", "Java", "JavaScript", "3"},
            {"2+2*2=?", "6", "8", "4", "2", "1"},
            {"Самое большое животное?", "Слон", "Кит", "Жираф", "Медведь", "2"},
            {"Как назывался особый головной убор, который носили фараоны в Древнем Египте?", "Картуз", "Немес", "Корона", "Убрус", "2"},
            {"Детинцем на Руси называли...", "Кремль", "Школу", "Княжеский терем", "Монастырь", "1"}
    };

    public QuizApp() {
        // Настройка окна
        setTitle("Викторина");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создаем верхнюю панель, которая будет содержать и вопрос, и информацию
        JPanel topPanel = new JPanel(new BorderLayout());

        // Панель с вопросом - размещаем в центре верхней панели
        JPanel questionPanel = new JPanel();
        questionLabel = new JLabel(questions[0][0]);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionPanel.add(questionLabel);
        topPanel.add(questionPanel, BorderLayout.CENTER);

        // Панель с информацией (таймер и счет) - размещаем внизу верхней панели
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        timerLabel = new JLabel("Время: 30");
        scoreLabel = new JLabel("Счет: 0");
        infoPanel.add(timerLabel);
        infoPanel.add(scoreLabel);
        topPanel.add(infoPanel, BorderLayout.SOUTH);

        // Добавляем всю верхнюю панель в окно
        add(topPanel, BorderLayout.NORTH);

        // Панель с вариантами ответов
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();

        for(int i = 0; i < 4; i++) {
            options[i] = new JRadioButton(questions[0][i+1]);
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        // Панель с кнопками
        JPanel buttonPanel = new JPanel();
        nextButton = new JButton("Ответить");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                nextQuestion();
            }
        });
        buttonPanel.add(nextButton);

        JButton saveButton = new JButton("Сохранить");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveResult();
            }
        });
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Запуск таймера
        startTimer();

        setVisible(true);
    }

    private void startTimer() {
        timer = new javax.swing.Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Время: " + timeLeft);

                if(timeLeft <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Время вышло!");
                    nextQuestion();
                }
            }
        });
        timer.start();
    }

    private void checkAnswer() {
        for(int i = 0; i < 4; i++) {
            if(options[i].isSelected()) {
                int correct = Integer.parseInt(questions[currentQuestion][5]) - 1;
                if(i == correct) {
                    score += 10;
                    JOptionPane.showMessageDialog(null, "Правильно!");
                } else {
                    JOptionPane.showMessageDialog(null, "Неправильно! Правильный ответ: " + questions[currentQuestion][correct+1]);
                }
                break;
            }
        }
        scoreLabel.setText("Счет: " + score);
    }

    private void nextQuestion() {
        currentQuestion++;
        if(currentQuestion < questions.length) {
            // Сброс таймера
            timeLeft = 30;
            timerLabel.setText("Время: 30");
            timer.restart();

            // Новый вопрос
            questionLabel.setText(questions[currentQuestion][0]);
            for(int i = 0; i < 4; i++) {
                options[i].setText(questions[currentQuestion][i+1]);
                options[i].setSelected(false);
            }
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        timer.stop();
        String result = "Викторина окончена!\nВаш счет: " + score;
        JOptionPane.showMessageDialog(null, result);

        // Показать кнопку сохранения
        nextButton.setEnabled(false);
    }

    private void saveResult() {
        try {
            FileWriter writer = new FileWriter("результаты.txt");
            writer.write("Результат викторины: " + score + " баллов");
            writer.close();
            JOptionPane.showMessageDialog(null, "Результат сохранен в файл!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при сохранении");
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}