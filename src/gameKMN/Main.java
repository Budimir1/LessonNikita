package gameKMN;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean winGame  = false;
    private static int playerNumber;
    private static String str;
    public static void main(String[] args) {


        System.out.println("Добро пожаловать в игру \"Камень, Ножницы, Бумага\"!");
        System.out.println("Введите ваш выбор (камень, ножницы, бумага) или \"выход\" для завершения:");
        String inputPlayer = scanner.nextLine();

        Random random = new Random();
        int computer = random.nextInt(3) + 1;
        if (computer == 1){
            str = Integer.toString(computer);
            str = "Камень";
        }else if(computer == 2){
            str = Integer.toString(computer);
            str = "Ножницы";
        }else if (computer == 3){
            str = Integer.toString(computer);
            str = "Бумага";
        }else System.out.println(" устав что-то придумывать");


        System.out.println("Компютер выбрал: " + str);

        inputPlayer = inputPlayer.toLowerCase();

        switch (inputPlayer.toLowerCase()) {
            case "камень": playerNumber = 1; break;
            case "ножницы": playerNumber = 2; break;
            case "бумага": playerNumber = 3; break;
        }

        if (playerNumber == computer) {
            System.out.println("Ничья");
        } else if ((playerNumber == 1 && computer == 2) ||
                (playerNumber == 2 && computer == 3) ||
                (playerNumber == 3 && computer == 1)) {
            System.out.println("Победа");
        } else {
            System.out.println("Поражение");
        }


    }
}
