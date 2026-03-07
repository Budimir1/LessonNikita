package algoritms.ex_9;

/**
 * Задание: Нахождение Суммы Положительных и Отрицательных Чисел
 * Описание:
 * Напишите программу на Java, которая находит и выводит сумму положительных и сумму отрицательных чисел в массиве целых чисел.
 */

public class Ex_9 {

    public static int sumPsitiveNum(int[] array){
        int positiveNumber = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 ) {
                positiveNumber += array[i];
            }
        }
        return positiveNumber;
    }

    public static int sumNegativeNum(int[] array){
        int negativeNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 0) {
                negativeNumber += array[i];
            }
        }
        return negativeNumber;
    }

    //"Сумма положительных чисел: " "Сумма отрицательных чисел: "
    public static void main(String[] args) {
        int[] numbers =  {1, 2, 3, 4, 5, -9, -8, -7, -6, -5};
        System.out.println(sumPsitiveNum(numbers));
        System.out.println(sumNegativeNum(numbers));
    }
}

