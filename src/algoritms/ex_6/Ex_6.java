package algoritms.ex_6;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *### Задание 6: Алгоритм А* (A*)
 * Реализуйте алгоритм A* для поиска кратчайшего пути в графе.
 * [1, 3, 5, 6, 2, 7, 4, 2]
 */

public class Ex_6 {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int x = 0, y = 0;
        int goalX = 2, goalY = 2;

        System.out.println("Путь:");
        while (x != goalX || y != goalY) {
            System.out.println("(" + x + "," + y + ")");

            if (x < goalX && grid[x+1][y] == 0) {
                x++;
            }
            else if (y < goalY && grid[x][y+1] == 0) {
                y++;
            }
            else if (x < goalX && y < goalY && grid[x+1][y+1] == 0) {
                x++; y++;
            }
            else {
                System.out.println("Путь заблокирован!");
                break;
            }
        }

        System.out.println("(" + x + "," + y + ")");
    }
}


//        if (n > 4) {
//            for (int i = n; i == 4; i--) {
//                System.out.println(i);
//            }
//            System.out.println("Никита НЕ ШАРИТ ЗА ПРОГРАММИРОВАНИЕ!!!!!");
//        } else if (n < 4) {
//            for (int i = n; i == 4; i++) {
//                System.out.println(i);
//            }
//            System.out.println("Никита НЕ ШАРИТ ЗА ПРОГРАММИРОВАНИЕ!!!!!");
//        }
//        if (n == 4) {
//            System.out.println("Никита НЕ ШАРИТ ЗА ПРОГРАММИРОВАНИЕ!!!!!");
//        }


