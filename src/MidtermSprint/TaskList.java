package MidtermSprint;

public class TaskList {
    private Task head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);

        // If list is empty, new task becomes the head
        if (head == null) {
            head = newTask;
            return;
        }

        // Otherwise, add to the end of the list
        Task current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newTask);
    }

    public void markTaskCompleted(String description) {
        Task current = head;

        while (current != null) {
            if (current.getDescription().equals(description)) {
                current.markCompleted();
                return;
            }
            current = current.getNext();
        }
    }

    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task current = head;
        while (current != null) {
            System.out.println("- " + current.getDescription() +
                    " [" + (current.isCompleted() ? "Completed" : "Pending") + "]");
            current = current.getNext();
        }
    }
}