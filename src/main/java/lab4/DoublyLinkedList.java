package lab4;

import java.util.Objects;

public class DoublyLinkedList<T> {

    public static class Node<T> {
        private T data;
        private Node<T> previous;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this.data == o) return true;
            if (o == null) return false;
            T newData = (T) o;
            return Objects.equals(data, newData);
        }
    }

    Node<T> head, tail = null;

    public void addNode(T data) {
        Node<T> newNode = new Node<T>(data);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public int countNodes() {
        int counter = 0;
        Node<T> current = head;

        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    public void display() {
        Node<T> current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void removeNode(Node<T> node) {
        if (head == null || node == null)
            return;

        // If node to be deleted is head node
        if (head == node)
            head = node.next;

        // Change next only if node to be
        // deleted is NOT the last node
        if (node.next != null)
            node.next.previous = node.previous;

        // Change prev only if node to be
        // deleted is NOT the first node
        if (node.previous != null)
            node.previous.next = node.next;

        node = null;
    }

    public void removeByIndex(int position) {
        if (head == null || position < 0)
            return;
        Node<T> current = head;
        for (int i = 0; current != null && i < position; i++) {
            current = current.next;
        }
        if (current == null)
            return;

        removeNode(current);
    }

    public void removeByElement(T findElement) {
        Node<T> runnerNode = head;
//        Node<T> previousNode = null;
        Node<T> nextNode = null;

        for (int i = 0; runnerNode != null; i++) {
            if (runnerNode.equals(findElement)) {
                nextNode = runnerNode.next;
                removeByIndex(i);

                if (nextNode == null || nextNode.next == null)
                    return;
            }
//            previousNode = runnerNode;
            runnerNode = runnerNode.next;
        }
    }
}
