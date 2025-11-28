import java.util.Scanner;

public class Main {

    public static int number;
    public static int randomNum;
    public static int countTry = 0;
    public  static String text, y, n;

    public static int random() {
        int min = 1;
        int max = 100;
        int range = (max - min) + 1;
        randomNum = (int) ((range * Math.random() + min));
        return randomNum;

    }

    public static int inputUser() {
        Scanner th = new Scanner(System.in);
        number = th.nextInt();
        return number;
    }

    public static String userInput() {
        Scanner th = new Scanner(System.in);
        text = th.nextLine();
        return text;
    }

    public static void main(String[] args) {
        random();
        System.out.println("Я загадал число от 1 до 100. Попробуй угадать его!");

        while (true) {
            System.out.println("Введите ваше предположение (или \"exit\" для выхода):");
            inputUser();

//            if (userInput().equalsIgnoreCase("exit")) {
//                System.out.println("Спасибо за игру!");
//                System.exit(0);
//            }

            if (number < randomNum) {
                System.out.println("Слишком маленькое число, попробуй снова.");
            } else if (number > randomNum) {
                System.out.println("Слишком большое число, попробуй снова.");
            } else {
                System.out.println("Поздравляю! Вы угадали число " + randomNum + " Вы совешили " + countTry + " попыток");
                random();
            }

            countTry ++;

        }
    }
}
