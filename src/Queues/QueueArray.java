package Queues;

public class QueueArray {
    private int[] arr;
    private int backOfQueue;
    private int nItems;
    private int beginningOfQueue;

    public QueueArray(int size) {
        this.arr = new int[size];
        this.backOfQueue = 0;
        this.nItems = 0;
        this.beginningOfQueue = 0;
        System.out.println("The queue is successfully created with size of: " + size);
    }

    // if thw queue is full
    public boolean isFull() {
      if (backOfQueue == nItems) {
          return true;
      }
      return false;
    }

    // if the queue is empty
    public boolean isEmpty() {
        return (nItems == 0);
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The queue is full");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            nItems++;
            arr[backOfQueue] = value;
            System.out.println("Successfully added " + value + " to the queue.");
        } else {
            backOfQueue++;
            nItems++;
            arr[backOfQueue] = value;
            System.out.println("Successfully added " + value + " to the queue.");
        }
    }

    public int deQueue() {
        int result = 0;
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            result = arr[beginningOfQueue];
            beginningOfQueue++;
            if (beginningOfQueue > backOfQueue) {
                beginningOfQueue = backOfQueue = -1;
            }
            nItems--;
        }
        return result;
    }

    public int peek() {
        if (!isEmpty()) {
            System.out.println("The queue is empty.");
            return arr[beginningOfQueue];
        } else {
            System.out.println("The queue is empty.");
            return -1;
        }
    }

    // delete
    public void deleteQueue() {
        arr = null;
        System.out.println("The queue is successfully deleted.");
    }
}
