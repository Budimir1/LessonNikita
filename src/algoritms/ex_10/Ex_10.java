package algoritms.ex_10;

/**
 * Задание: Нахождение Медианы
 * Описание:
 * Напишите программу на Java, которая находит и выводит медиану массива целых чисел.
 *
 * Пример:
 * Вход: {3, 1, 2, 5, 4}
 * Выход: Медиана: 3
 */

public class Ex_10 {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1 ; i++) {
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swap = true;
                }
            }
            if (!swap) break;
        }
    }

    public static int mediana(int[] array){
        int n = array.length;

        if (n % 2 == 1) {
            n = (n / 2) + 1;
            System.out.println(n);
        }else System.out.println(n - 1);

        return n;
    }

    public static void main(String[] args) {
        int[] num = {3, 1, 2, 5, 4, 7, 6};
        bubbleSort(num);
        mediana(num);
    }
}