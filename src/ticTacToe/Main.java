package ticTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static boolean isWin = false;
    public static int num;

    public static void checkingForMatch (char[][] field) {

        for (int i = 0; i < field.length; i++) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] || // сравнение по горизонтали
                    field[0][i] == field[1][i] && field[0][i] == field[2][i] || // сравнение по вертикали
                    field[0][0] == field[1][1] && field[0][0] == field[2][2] || // сравнение по
                    field[2][0] == field[1][1] && field[2][0] == field[0][2]) { // диагоналям

                isWin = true;
                break;
            }
        }
    }
    public static void printField (char[][] field) {
        for (int i = 0; i < field.length; i++) {
            System.out.print("|");
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int randomPlayer = (int) (Math.random() * 2 + 1);
        if (randomPlayer == 1)
            System.out.println("Player1 ходит первым!" + '\n');
        else System.out.println("Player2 ходит первым!" + '\n');

        System.out.println("Введите число от 1 до 9, чтобы сделать Ваш ход: " + '\n');

        char[][] field = {{'1','2','3'},
                          {'4','5','6'},
                          {'7','8','9'}};



        char player;
        int switcher = 0;
        while (true) {

            if (switcher % 2 == 0)
                player = 'x';
            else player = 'o';

            printField(field);

            try {
                num = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Число, только число!");
                continue;
            }

            if (Arrays.deepToString(field).contains(Integer.toString(num)) && num <= 9 && num > 0) {
                switch (num) {
                    case 1: field[0][0] = player; break;
                    case 2: field[0][1] = player; break;
                    case 3: field[0][2] = player; break;
                    case 4: field[1][0] = player; break;
                    case 5: field[1][1] = player; break;
                    case 6: field[1][2] = player; break;
                    case 7: field[2][0] = player; break;
                    case 8: field[2][1] = player; break;
                    case 9: field[2][2] = player; break;
                }
            } else {
                System.out.println("Введите число из оставшихся на поле!");
                continue;
            }

            switcher++;

            checkingForMatch(field);

            if (isWin) {
                System.out.println("YOU WIN!!!");
                printField(field);
                break;
            }

        }
    }
}