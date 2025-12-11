package toDoList;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String inputString;
    public static int inputInt;

    public static class Task {
        private int id;
        private String description;
        private boolean isCompleted;

        public Task(int id, String description, boolean isCompleted) {
            this.id = id;
            this.description = description;
            this.isCompleted = isCompleted;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }
    }

    public String  inputStr(){
        Scanner th = new Scanner(System.in);
        inputString = th.nextLine();
        return inputString;
    }

    public int inputNum(){
        Scanner th = new Scanner(System.in);
        inputInt = th.nextInt();
        return inputInt;
    }



    public static void main(String[] args) {

        ArrayList<Task> Task = new ArrayList<>();

        int  nextId = 0;

        Task.add('0', "Сделать дз", "Не выполнена");

    }





















//    public int numTask;
//    public static int meny;
//    public  String createTask;
//    public  int killTask;
//    public  int viewTask;
//    public  int completedTask;
//    public  int exit;
//
//    public static String inputTextConsol(){
//        Scanner th = new Scanner(System.in);
//        String text = th.nextLine();
//        return text;
//    }
//
//    public static int inputIntConsol(){
//        Scanner th = new Scanner(System.in);
//        int num = th.nextInt();
//        return num;
//    }
//
//    public void menyBar(){
//        createTask = inputTextConsol();
//        killTask = inputIntConsol();
//        viewTask = inputIntConsol();
//        completedTask = inputIntConsol();
//        exit = inputIntConsol();
//    }
//
//    Main(int numTask, String createTask, int completedTask){
//        this.numTask = numTask;
//        this.createTask = createTask;
//        this.completedTask = completedTask;
//    }
//
//    public static void createTask(int numTask, String createTask, int completedTask){
//        System.out.println("Добро пожаловать, здесь вы можете добавить задачу");
//        Main newTask = new Main(inputTextConsol();
//
//    }
//    Main(int killTask){
//        this.killTask = killTask;
//    }
//    public static void killTask(){
//        System.out.println("Добро пожаловать, здесь вы можете удалить задачу написав её номер");
//        System.out.println("Введите номер задачи: ");
//
//    }
//    public static void viewTask() {
//        System.out.println("Добро пожаловать, здесь вы можете просмотреть существующие задачи");
//    }
//    public static void completedTask() {
//        System.out.println("Добро пожаловать, здесь вы можете изменить статус задачи, 0 невыполнена, 1 выполнена");
//    }
//    public static void exit(){
//        System.out.println("Спасибо, что воспользовались To-Do List!");
//    }
//
//
//
//    public static void main(String[] args) {
//        System.out.println("Добро пожаловать в To-Do List!");
//        System.out.println("Выберите действие:");
//
//        menyBar();
//        switch (meny){
//            case 1: meny = createTask; break;
//        }
//    }
}