package calculator;

import java.util.Scanner;

public class main {

    public static String operator;
    public static String text;
    public static double num1;
    public static double num2;
    public static double result;

    public static double sum(){
        result = num1 + num2;
        return result;
    }

    public static double sub(){
        result = num1 - num2;
        return result;
    }

    public static double mult(){
        result = num1 * num2;
        return result;
    }

    public static double div(){
        if (num1 == 0) {
            System.out.println("Бро к сожаление деление на 0 запрещено на территории РФ");
        }else result = num1 / num2;
        return result;
    }

    public static double inputNum1(){
        Scanner th = new Scanner(System.in);
        double num1 = th.nextDouble();
        return num1;
    }

    public static double inputNum2(){
        Scanner th = new Scanner(System.in);
        double num2 = th.nextDouble();
        return num2;
    }

    public static String operation(){
        Scanner th = new Scanner(System.in);
        String znak = th.nextLine();
        return znak;
    }



    public static void main(String[] args) {
        System.out.println("По братски бахни 2 числа и если не в напряг знак: +, -, *, /");
        num1 = inputNum1();
        num2 = inputNum2();
        operator = operation();

        while (true) {

            switch (operator) {
                case "+":
                    System.out.println("Сумма двух чисел = " + sum() + "\n" +
                            "Скажи честнро ты тупой? Не мог сам посчитать...");
                    System.out.println("Ладно не отвечай, это был риторический вопрос, " +
                            "лучше скажи продолжать будешь или нет?" +
                            "да - у, нет - n");
                    text = operation();
                    if (text == "y") {
                        result = 0;

                        num1 = inputNum1();
                        num2 = inputNum2();
                        operator = operation();
                    }else if(text == "n"){
                        System.exit(0);
                    }
                    break;
                case "-":
                    System.out.println("Разность двух чисел = " + sub() + "\n" +
                            "Скажи честнро ты тупой? Не мог сам посчитать...");
                    break;
                case "*":
                    System.out.println("Произведение двух чисел = " + mult() + "\n" +
                            "Скажи честнро ты тупой? Не мог сам посчитать...");
                    break;
                case "/":
                    System.out.println("Деление двух чисел = " + div() + "\n" +
                            "Скажи честнро ты тупой? Не мог сам посчитать...");
                    break;

                case "exit":
                    System.out.println("Будь другом больше напускай");
                    System.exit(0);
                    break;
            }



        }
    }
}
