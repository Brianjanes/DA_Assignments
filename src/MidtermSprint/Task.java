package MidtermSprint;

public class Task {
    private String description;
    private boolean completed;
    private Task next;

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.next = null;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public Task getNext() {
        return next;
    }

    public void setNext(Task next) {
        this.next = next;
    }
}