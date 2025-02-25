package MidtermSprint;

import java.util.Random;

public class User {
    private String name;
    private long id;
    private TaskList todoList;

    public User(String name) {
        this.name = name;
        this.id = generateUniqueId();
        this.todoList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void addTask(String description) {
        todoList.addTask(description);
    }

    public void markTaskCompleted(String description) {
        todoList.markTaskCompleted(description);
    }

    public void printTasks() {
        System.out.println("\nTasks for user: " + name + " (ID: " + id + ")");
        todoList.printTasks();
    }

    // Generate a random unique ID
    private static long generateUniqueId() {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }
}