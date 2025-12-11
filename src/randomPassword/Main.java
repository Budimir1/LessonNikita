package randomPassword;

import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+";

        String allCharacters = upperCaseLetters + lowerCaseLetters + digits + specialCharacters;

        System.out.print("Введите желаемую длину пароля: ");
        int passwordLength = scanner.nextInt();

        if (passwordLength <= 0) {
            System.out.println("Длина пароля должна быть положительным числом!");
            return;
        }

        StringBuilder password = new StringBuilder(passwordLength);

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }

        System.out.println("Сгенерированный пароль: " + password.toString());

        scanner.close();
    }










//    public static SecureRandom random;
//    public static int passwordLength;
//    public static String upSimvol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    public static String downSimvol = "abcdefghijklmnopqrstuvwxyz";
//    public static String num = "0123456789";
//    public static String specSimvol = "_/.,?><-=+)(*&^%$#@!~`':|}{";
//
//    private static Scanner scanner = new Scanner(System.in);
//    public static String allCharacters = upSimvol + downSimvol + num + specSimvol;
//
//
//
//
//    public static void main(String[] args) {
//        System.out.println("Введите количиство символов в пароле:");
//
//        passwordLength = scanner.nextInt();
//
//        StringBuilder password = new StringBuilder(passwordLength);
//
//        for (int i = 0; i < passwordLength; i++) {
//            int randomIndex = random.nextInt(allCharacters.length());
//            password.append(allCharacters.charAt(randomIndex));
//        }
//        System.out.println(password.toString());
//        scanner.close();
//    }
}
