package casino;

import java.util.Scanner;

public class Casino {


    public static Scanner scanner = new Scanner(System.in);
    public static int randomNum;
    public static String[] slot = {"🍒", "🍋", "🍊", "💰"};
    public static int[] results = new int[3];


    public static int random() {
        int min = 0;
        int max = 3;
        int range = (max - min) + 1;
        randomNum = (int) ((range * Math.random() + min));
        return randomNum;
    }

    public static void spin() {
        for (int i = 0; i < 3; i++) {
            results[i] = random();
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(slot[results[i]] + " ");
        }
        System.out.println();
    }

    public static void checkWin(){
                if (results[0] == results[1] && results[1] == results[2]) {
                    System.out.println("🎉 ЧеееееЕЕЕЕллллеЕЛЛЕЛЕ! Не зНаЮ кАк Но тЫ ПобЕДил с комбинэшн политреёшен: \n ХОЧЕШЬ ЕЩЁ?" +
                            slot[results[0]] + slot[results[1]] + slot[results[2]]);
                    switch(results[0]) {
                        case 0:
                            System.out.println("Выигрыш: 3 вишни! 🍒🍒🍒");
                            break;
                        case 1:
                            System.out.println("Выигрыш: 3 лимона! 🍋🍋🍋");
                            break;
                        case 2:
                            System.out.println("Выигрыш: 3 апельсина! 🍊🍊🍊");
                             break;
                        case 3:
                            System.out.println("ДЖЕКПОТ! 3 монетки! 💰💰💰");
                            break;
                    }
                }else System.out.println("ТЫ ПРОИГРАЛ БЭТМАН \nЛИВАЙ С ПОЗОРОМ \nЛибо играй ещё раз?)");
    }




    public static void main(String[] args) {

        System.out.println("Здарова лудик! \nХочешь поиграть, тогда плати... \nПопытка 1 рубль\n");
        System.out.println("Для запуска напишите да, если играть не хотите напишите выход");
        while (true){

            String inputPlayer = scanner.nextLine();

            inputPlayer = inputPlayer.toLowerCase();

            if (inputPlayer.equals("да")) {
                spin();
                checkWin();

            }else if (inputPlayer.equals("выход")){
                System.out.println("Ясненько сколко слил?) \n Ну ты это, заходи если чё!");
                break;
            }else System.out.println("Бро выше вроде на русском написано, либо ДА запуск либо выход и всё закончиться))) \n");

        }
    }
}
