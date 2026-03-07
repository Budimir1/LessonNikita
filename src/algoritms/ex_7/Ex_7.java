package algoritms.ex_7;


/**
 Алгоритм: Поиск минимума/максимума
 Описание
 Этот алгоритм используется для нахождения минимального или максимального значения в массиве.
 */

public class Ex_7 {

    public static int findMin(int[] array){
        int minNum = array[0];

        for (int i = 0; i < array.length; i++) {
            if (minNum > array[i]) {
                minNum = array[i];
            }
        }
        return minNum;
    }
    public static int findMax(int[] array){
        int maxNum = array[0];

        for (int i = 0; i < array.length; i++) {
            if (maxNum < array[i]) {
                maxNum = array[i];
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] numbers =  {1, 12 ,23, 34, 3, 4, 6, 34, 2, 5, 5, 76};

        System.out.println(findMin(numbers) + " " + findMax(numbers));
    }

}

