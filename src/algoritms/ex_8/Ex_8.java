package algoritms.ex_8;

/**
 * Задание: Подсчет Частоты Элементов в Массиве
 * Описание:
 * Напишите программу на Java, которая будет подсчитывать и выводить частоту каждого элемента в массиве целых чисел.
 * Вывести повторяющиеся элементы
 */

public class Ex_8 {


    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 3, 1, 4, 4, 4};

        int[] nums = new int[5];
        for (int i: numbers) {
            nums[i]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                System.out.println(i + " " + nums[i]);
            }
        }
    }
}
