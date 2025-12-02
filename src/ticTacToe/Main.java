package ticTacToe;

import java.util.Scanner;

public class Main {
    public static boolean gameOver = false;
    public static int num;

    public static void statusGame(){

    }

    public static void queue(){

    }
    public static int inpurMan(){
        Scanner th = new Scanner(System.in);
        int num = th.nextInt();
        return num;
    }

    public static void playField(String[][] filed){
        for (int i = 0; i < filed.length; i++) {
            System.out.print("|");
            for (int j = 0; j < filed.length; j++) {
                System.out.print(filed[i][j] + "|");
            }
            System.out.println();
        }

    }



    public static void main(String[] args) {

        int randomPlayer = (int) ((Math.random() * 2 + 1));
        if (randomPlayer % 2 == 1){
            System.out.println("Игрок №1 ходит первый \n");
        }else System.out.println("Игрок №2 ходит первый \n");

        System.out.println("Для хода вы должны выбрать число от 1 до 9");
        num = inpurMan();

        String [][] filed = {{"1", "2", "3"},
                             {"4", "5", "6"},
                             {"7", "8", "9"}
        };

        String motion;

        int switcher = 0;

        while (true){
            if (switcher % 2 == 0){
                motion = "x";
            }else motion = "o";

            playField(filed);

            switch (num){
                case 1: filed[0][0] = motion; break;
                case 2: filed[1][1] = motion; break;
                case 3: filed[2][2] = motion; break;
                case 4: filed[0][1] = motion; break;
                case 5: filed[0][2] = motion; break;
                case 6: filed[1][0] = motion; break;
                case 7: filed[2][0] = motion; break;
                case 8: filed[2][1] = motion; break;
                case 9: filed[1][2] = motion; break;
            }
//            try{
//                num = Integer.parseInt(num);
//            }catch (NumberFormatException e){
//                System.out.println("Пожалуйста, введите число или 'exit'");
//                continue;
//            }
        }

    }
}