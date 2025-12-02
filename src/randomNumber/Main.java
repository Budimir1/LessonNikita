package randomNumber;

import java.util.Scanner;

public class Main {

    public static int number;
    public static int randomNum;
    public static int countTry = 0;
    public  static String input;

    public static int random() {
        int min = 1;
        int max = 100;
        int range = (max - min) + 1;
        randomNum = (int) ((range * Math.random() + min));
        return randomNum;
    }

    public static String inputUser() {
        Scanner th = new Scanner(System.in);
        input = th.nextLine();
        return input;
    }

    public static void main(String[] args) {
        random();
        System.out.println("Я загадал число от 1 до 100. Попробуй угадать его!");

        while (true) {
            System.out.println("Введите ваше предположение (или \"exit\" для выхода):");
            input = inputUser();

            countTry ++;

            if (input.equalsIgnoreCase("exit")){
                System.out.println("Спасибо за игру!");
                break;
            }

            try {
                number = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Пожалуйста, введите число или 'exit'");
                continue;
            }

            if (number < randomNum) {
                System.out.println("Слишком маленькое число, попробуй снова.");
            } else if (number > randomNum) {
                System.out.println("Слишком большое число, попробуй снова.");
            } else {
                System.out.println("Поздравляю! Вы угадали число " + randomNum + " Вы совешили " + countTry + " попыток");
                countTry = 0;
                random();
            }
        }
    }
}
