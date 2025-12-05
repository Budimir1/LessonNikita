package toDoList;

import java.util.Scanner;

public class Main {

    public int numTask;
    public static int meny;
    public  String createTask;
    public  int killTask;
    public  int viewTask;
    public  int completedTask;
    public  int exit;

    public static String inputTextConsol(){
        Scanner th = new Scanner(System.in);
        String text = th.nextLine();
        return text;
    }

    public static int inputIntConsol(){
        Scanner th = new Scanner(System.in);
        int num = th.nextInt();
        return num;
    }

    public void menyBar(){
        createTask = inputTextConsol();
        killTask = inputIntConsol();
        viewTask = inputIntConsol();
        completedTask = inputIntConsol();
        exit = inputIntConsol();
    }

    Main(int numTask, String createTask, int completedTask){
        this.numTask = numTask;
        this.createTask = createTask;
        this.completedTask = completedTask;
    }

    public static void createTask(int numTask, String createTask, int completedTask){
        System.out.println("Добро пожаловать, здесь вы можете добавить задачу");
        Main newTask = new Main(inputTextConsol();

    }
    Main(int killTask){
        this.killTask = killTask;
    }
    public static void killTask(){
        System.out.println("Добро пожаловать, здесь вы можете удалить задачу написав её номер");
        System.out.println("Введите номер задачи: ");

    }
    public static void viewTask() {
        System.out.println("Добро пожаловать, здесь вы можете просмотреть существующие задачи");
    }
    public static void completedTask() {
        System.out.println("Добро пожаловать, здесь вы можете изменить статус задачи, 0 невыполнена, 1 выполнена");
    }
    public static void exit(){
        System.out.println("Спасибо, что воспользовались To-Do List!");
    }



    public static void main(String[] args) {
        System.out.println("Добро пожаловать в To-Do List!");
        System.out.println("Выберите действие:");

        menyBar();
//        switch (meny){
//            case 1: meny = createTask; break;
//        }
    }
}