package algoritms.ex_11;

/**
 * Задание: Реверс Масссива
 * Описание:
 * Напишите программу на Java, которая реверсирует массив целых чисел.
 *
 * Пример:
 * Вход: {1, 2, 3, 4, 5}
 * Выход: {5, 4, 3, 2, 1}
 */

public class Ex_11 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}