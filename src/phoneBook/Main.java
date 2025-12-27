package phoneBook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String name;

    public static class Book {
        public int id;
        public static String name;
        public static String phoneNumber;
        public static String email;

        public Book(int id, String name, String phoneNumber, String email) {
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }
        @Override
        public String toString(){
            return "Book ID " + id + " Name " + name + " PhoneNumber " + phoneNumber + " email " + email;
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Book> books = new ArrayList<>();
    private static int nextId = 0;

    public static void main(String[] args) {
        int action;

        do {
            System.out.println("Добро пожаловать в телефонную книгу!");
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Найти контакт по имени");
            System.out.println("4. Просмотреть все контакты");
            System.out.println("0. Выйти");
            action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 1: addBook(); break;
                case 2: deleteBook(); break;
                case 3: serchName(); break;
                case 4: viewsBook(); break;
                case 0: System.out.println("Thank you for using the To-Do List!");; break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while (action != 4);
    }

    private static void addBook(){
        System.out.println("Ку-ку!");
        System.out.println("Введите имя контакта: ");
        String name = scanner.nextLine();
        System.out.println("Введите номер телефлона: ");
        String numTp = scanner.nextLine();
        System.out.println("Введите чё нибудь");
        String email = scanner.nextLine();
        books.add(new Book(nextId++, name, numTp,email));
        System.out.println("Ты это болше не создавай памяти мало)))");
    }

    private static void deleteBook(){
        System.out.println("Выбери контак который хочешь удалить: " + nextId);
        int num = scanner.nextInt();
        boolean removed = books.removeIf(book -> book.getId()  == num);
        if (removed) {
            System.out.println("Контак удалён");
        }else System.out.println("Такого контакта нет)");
    }

    private static void serchName(){
        System.out.println("Напишите имя контакта для его поиска: ");
        String name = scanner.nextLine();
        boolean bb = false;
        for (Book book : books) {
            if(book.getName().equalsIgnoreCase(name)){
            bb = true;
            }
        }
        if(!bb){
            System.out.println("ffsg");
        }
    }
    private static void viewsBook(){
        System.out.println("Просмотр всех контактов: ");
        System.out.println(books);
    }
}
