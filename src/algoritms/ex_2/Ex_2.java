package algoritms.ex_2;

/**
 * ### Задание 2: Динамическое программирование: Нахождение максимальной суммы подпоследовательности
 * Напишите метод, который находит максимальную сумму подпоследовательности в массиве целых чисел.
 * [1, 20, 2, 4, 26, 7, 4, 32, 2, 134, 343] =  1, 2, 4, 32, 134, 343 их сумма
 */



public class Ex_2 {

    public static int dinamic(int[] array){
        if (array.length == 0) {
            return 0;
        }
        int totalSum = array.length;
        int[] maxSum = new int[totalSum];

        for (int i = 0; i < totalSum; i++) {
            maxSum[i] = array[i];
        }

        for (int i = 1; i < totalSum; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    if (maxSum[i] < maxSum[j] + array[i]) {
                        maxSum[i] = maxSum[j] + array[i];
                    }
                }
            }
        }
        int result = maxSum[0];
        for (int i = 1; i < totalSum; i++) {
            if (maxSum[i] > result) {
                result = maxSum[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] number = {1, 20, 2, 4, 26, 7, 4, 32, 2, 134, 343};
        System.out.println(dinamic(number));
    }


}
