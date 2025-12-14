package toDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }

        @Override
        public String toString() {
            return "Task ID: " + id + ", Description: " + description +
                    ", Completed: " + (isCompleted ? "Yes" : "No");
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 0;

    public static void main(String[] args) {
        int action;

        do {
            System.out.println("Welcome to the To-Do List!");
            System.out.println("Choose an action:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Thank you for using the To-Do List!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (action != 5);
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(nextId++, description, false));
        System.out.println("Task added successfully.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private static void completeTask() {
        System.out.print("Enter task ID to complete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("Task completed successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted successfully.");
    }
}