package DoubleLinkedList;

/**
 * Implement an application that support undo/redo functionality.
 * Use a linked list to maintain a sequence of states.
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    public T undo() {
        if (currentState == null || currentState.prev == null) {
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }

    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState == null) {
            currentState = newNode;
            return;
        }

        // Clear any forward (redo) states
        currentState.next = newNode;
        newNode.prev = currentState;
        currentState = newNode;
    }

    public T redo() {
        if (currentState == null || currentState.next == null) {
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }

    // Nested test class, run this rather than the file to see it working
    static class Test {
        public static void main(String[] args) {
            UndoRedoManager<String> textEditor = new UndoRedoManager<String>();

            textEditor.addState("Hello");
            textEditor.addState("Hello World");
            textEditor.addState("Hello World!");

            // Hello World
            System.out.println(textEditor.undo());
            // Hello
            System.out.println(textEditor.undo());
            // Hello World
            System.out.println(textEditor.redo());
        }
    }
}