package MidtermSprint;

import java.util.Scanner;

public class Main {
    // this will store UP TO 10 users
    private static User[] users = new User[10];
    private static int userCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to the To-Do List Manager!");

        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Create new user");
            System.out.println("2. Select user");
            System.out.println("3. Show all users");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter choice: ");
            System.out.println();

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    selectUser();
                    break;
                case 3:
                    showAllUsers();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private static void createUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        // Check if name is unique
        if (!isNameUnique(name)) {
            System.out.println("Error: User with this name already exists!");
            return;
        }

        users[userCount] = new User(name);
        System.out.println("User created with ID: " + users[userCount].getId());
        userCount++;
    }

    private static void selectUser() {
        if (userCount == 0) {
            System.out.println("No users available!");
            return;
        }

        showAllUsers();
        System.out.print("Select user number: ");
        int index = getIntInput() - 1;

        if (index < 0 || index >= userCount) {
            System.out.println("Invalid user number!");
            return;
        }

        userMenu(users[index]);
    }

    private static void userMenu(User user) {
        boolean inUserMenu = true;

        while (inUserMenu) {
            System.out.println("\n===== USER: " + user.getName() + " =====");
            System.out.println("1. Add task");
            System.out.println("2. Mark task as completed");
            System.out.println("3. Show all tasks");
            System.out.println("4. Return to main menu");
            System.out.print("Enter choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addTask(user);
                    break;
                case 2:
                    markTaskCompleted(user);
                    break;
                case 3:
                    user.printTasks();
                    break;
                case 4:
                    inUserMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addTask(User user) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        user.addTask(description);
        System.out.println("Task added!");
    }

    private static void markTaskCompleted(User user) {
        System.out.print("Enter task description to mark as completed: ");
        String description = scanner.nextLine();
        user.markTaskCompleted(description);
        System.out.println("Task marked as completed (if it exists)!");
    }

    private static void showAllUsers() {
        if (userCount == 0) {
            System.out.println("No users available!");
            return;
        }

        System.out.println("\n===== USERS =====");
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ". " + users[i].getName() + " (ID: " + users[i].getId() + ")");
        }
    }

    private static boolean isNameUnique(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}