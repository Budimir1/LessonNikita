package algoritms.ex_12;

import java.util.Arrays;

/**
 * Сортировка выбором (Selection Sort) — это простой алгоритм сортировки, который работает по принципу постепенного выбора минимального элемента и перемещения его на своё место.
 * Массив делится на две части:
 * отсортированная (слева)
 * неотсортированная (справа)
 * На каждом шаге:
 * Берём текущую позицию i
 * Ищем минимальный элемент в диапазоне от i до конца массива
 * Меняем местами найденный минимум с элементом на позиции i
 * [64, 25, 12, 22, 11]
 */

public class Ex_12 {
    public static int minNum = 0;
    public static int temp = 0;

    public static void selectionSort(int[] arr){
        int arrLength = arr.length;

        for (int i = 0; i < arrLength - 1; i++) {
            minNum = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[j] < arr[minNum]) {
                    minNum = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minNum];
            arr[minNum] = temp;
        }
    }

    public static void main(String[] args) {
        int[] num = {64, 25, 12, 22, 11};
        System.out.println("Before: " + Arrays.toString(num));
        selectionSort(num);
        System.out.println("After:  " + Arrays.toString(num));
    }
}
