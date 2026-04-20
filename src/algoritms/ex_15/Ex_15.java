package algoritms.ex_15;

import java.util.Arrays;

/**
 * Бинарный поиск и Линейный поиск
 * ЛИНЕЙНЫЙ ПОИСК!
 * O(n) и O(1) Стремимся к O(logn)
 * public static int linearSearch(int[] arr, int target) {
 *         for (int i = 0; i < arr.length; i++) {
 *             if (arr[i] == target) {
 *                 return i;
 *             }
 *         }
 *         return -1;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] arr = {5, 3, 8, 1, 9, 2, 7};
 *         int target = 9;
 *
 *         int result = linearSearch(arr, target);
 *
 *         if (result != -1) {
 *             System.out.println("Элемент " + target + " найден на индексе: " + result);
 *         } else {
 *             System.out.println("Элемент " + target + " не найден.");
 *         }
 *     }
 *
 *
 *     Реверс:
 *
 *     for (int i = arr.length - 1; i >= 0; i--) {
 *             System.out.print(arr[i]);
 *         }
 *
 *
 *         Сумма двух в массиве
 *     public static int linearSearch(int[] arr, int target){
 *         for (int i = 0; i < arr.length; i++) {
 *             for (int j = i + 1; j < arr.length; j++) {
 *                 if (arr[i] + arr[j] == target) {
 *                     System.out.println(arr[i] + " " + arr[j]);
 *                 }
 *             }
 *         }
 *         return -1;
 *     }
 *
 *
 *     public static int[] linearSearch(int[] arr, int target){
 *         int idx = -1;
 *         for (int i = 0; i < arr.length; i++) {
 *             if (arr[i] == target) {
 *                 idx = i;
 *                 break;
 *             }
 *
 *         }
 *         int[] result = new int[arr.length];
 *         int rightLen = arr.length - idx;
 *
 *         for (int i = 0; i < rightLen; i++) {
 *             result[i] = arr[idx + i];
 *         }
 *
 *         for (int i = 0; i < idx; i++) {
 *             result[rightLen + i] = arr[i];
 *         }
 *
 *         return result;
 *     }
 *
 **/

public class Ex_15 {

    public static void linearSearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40, 50, 60, 70, 80};
        int target1 = 40;   // ожидаемый индекс 3

        int[] arr2 = {5, 15, 25, 35, 45, 55, 65, 75};
        int target2 = 55;   // ожидаемый индекс 5

        linearSearch(arr1, target1);
        linearSearch(arr2, target2);


    }
}
