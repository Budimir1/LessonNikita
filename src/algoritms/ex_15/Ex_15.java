package algoritms.ex_15;

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
 **/

public class Ex_15 {

    public static void linearSearch(int[] arr){

        for (int i = 0; i >= arr.length; i--) {
            System.out.print(i);

        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 7, 1, 4, 9, 4, 6};

        linearSearch(arr);
    }
}
