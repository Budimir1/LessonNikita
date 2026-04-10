package algoritms.ex_13;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Задание: «Найти второй минимальный элемент через Selection Sort»
 * Дан массив чисел. Нужно найти второй по величине (второй минимум), используя идею сортировки выбором.
 * Условия:
 * Использовать подход Selection Sort
 * Сделать только 2 прохода
 * Работать in-place
 */

public class Ex_13 {

    public static int numMin = 0;
    public static int temp = 0;

    public static void selectionSort(int[] arr){
        int arrLength = arr.length;

        for(int i = 0; i < arrLength - 1; i++){
            numMin = i;
            for (int j = i + 1; j < arrLength; j++){
                if(arr[j] < arr[numMin]){
                    numMin = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[numMin];
            arr[numMin] = temp;
            if (arr[i] == arr[1]) {
                System.out.println("Второе минимальное число: " + arr[i]);
                break;
            }

        }
    }


    public static void main(String[] args){
        int[] num = {11, 33, 55, 22, 44};
        System.out.println("Неотсартрированный массив" + Arrays.toString(num));
        selectionSort(num);
        System.out.println("Отсартированный массив" + Arrays.toString(num));
    }

}
