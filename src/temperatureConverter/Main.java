package temperatureConverter;

import java.util.Scanner;

public class Main {
    public static double C;
    public static double F;
    public static int input;

    public static double Cel(){
        C = (F - 32) * 5/9;
        return C;
    }

    public static double Fara(){
        F = (C * 9/5) + 32;
        return F;
    }

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true){

            System.out.println("Выберите конвертацию:");
            System.out.println("Для этого впишите значения в градусах");

            input = scanner.nextInt();

            if (input == 1){
                Fara();
                C = scanner.nextInt();
                System.out.println(Fara());
            }else if(input == 2){
                Cel();
                F = scanner.nextInt();
                System.out.println(Cel());
            }else System.out.println("error");
        }
    }
}
