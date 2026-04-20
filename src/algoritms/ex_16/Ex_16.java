package algoritms.ex_16;

/**
 * Бинарный поиск и Линейный поиск
 * БИНАРНЫЙ ПОИСК!
 *
 * public static int binarySearch(int[] arr, int target) {
 *         int lo = 0, hi = arr.length - 1;
 *
 *         while (lo <= hi) {
 *             int mid = lo + (hi - lo) / 2;
 *
 *             if (arr[mid] == target) {
 *                 return mid;
 *             } else if (arr[mid] < target) {
 *                 lo = mid + 1;
 *             } else {
 *                 hi = mid - 1;
 *             }
 *         }
 *
 *         return -1;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] arr = {3, 7, 11, 15, 19, 23, 28, 33, 37, 42, 47, 51, 58, 64, 70};
 *
 *         int target = 37;
 *         int result = binarySearch(arr, target);
 *
 *         if (result != -1) {
 *             System.out.println("Найдено: " + target + " на индексе " + result);
 *         } else {
 *             System.out.println("Элемент " + target + " не найден");
 *         }
 *     }
 *
 *         public static int finedSearch(int[] arr, int target) {
 *         int lo = 0, hi = arr.length - 1;
 *         int result = -1;
 *
 *         while (lo <= hi) {
 *             int mid = lo + (hi - lo) / 2;
 *
 *             if (arr[mid] == target) {
 *                 result = mid;
 *                 lo = mid + 1;
 *             } else if (arr[mid] < target) {
 *                 lo = mid + 1;
 *             } else {
 *                 hi = mid - 1;
 *             }
 *         }
 *
 *         return result;
 *     }
 *
 *     public static int finedSearch2(int[] arr, int target) {
 *         int lo = 0, hi = arr.length - 1;
 *         int result = -1;
 *
 *         while (lo <= hi) {
 *             int mid = lo + (hi - lo) / 2;
 *
 *             if (arr[mid] == target) {
 *                 result = mid;
 *                 hi = mid - 1;
 *             } else if (arr[mid] < target) {
 *                 lo = mid + 1;
 *             } else {
 *                 hi = mid - 1;
 *             }
 *         }
 *         return result;
 *     }
 *
 **/

public class Ex_16 {

    public static int finedSearch2(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) {
                result = mid;
                hi = mid - 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    public static int searchFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                firstIndex = mid;
                right = mid - 1;
            }
            else if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
            }
            else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return firstIndex;
    }


    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 6, 7, 7, 7, 8, 9, 1, 2, 3, 3, 3};
        int target = 7;

        int first = finedSearch2(arr1, target);
        System.out.println("Первое вхождение: индекс " + first);

        int second = searchFirst(arr1, target);
        System.out.println("Первое вхождение: индекс " + second);


    }
}
