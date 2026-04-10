package algoritms.ex_3;

/**
 *### Задание 3: Алгоритм Дейкстры
 * Реализуйте алгоритм Дейкстры для нахождения кратчайшего пути в графе.
 */

public class Ex_3 {
    public static int deikstr (int[] array){

          int num = array.length;;

          if (array == null || num == 0) {
              return 0;
          }

          for (int i = num; i <= num; i--) {

              if (i == 5) {
                  continue;
              }

              System.out.println(i);

              if (i == 4) {
                  System.out.println("Никита хороший реп");
                  break;
              }
          }
          return 0;
      }

      public static void main(String[] args) {
          int[] num = {1, 3, 6, 4, 2, 7};
          deikstr(num);
      }
}


/**
 * public static int deikstr (int[] array){
 *
 *         int num = array.length;;
 *
 *         if (array == null || num == 0) {
 *             return 0;
 *         }
 *
 *         for (int i = num; i <= num; i--) {
 *
 *             if (i == 5) {
 *                 continue;
 *             }
 *
 *             System.out.println(i);
 *
 *             if (i == 4) {
 *                 System.out.println("Никита хороший реп");
 *                 break;
 *             }
 *         }
 *         return 0;
 *     }
 *
 *     public static void main(String[] args) {
 *         int[] num = {1, 3, 6, 4, 2, 7};
 *         deikstr(num);
 *     }
 */