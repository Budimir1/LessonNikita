package tableSquares;

import java.util.Scanner;

public class Squares {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            int y = i * i;
            System.out.println(i + ":" + y);
        }
    }
}
