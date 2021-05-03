package lab4;

import java.util.Objects;

public class SinglyLinkedList<T> {
    public static class Node<T> {
        private T data;
        private Node<T> next;

        @Override
        public boolean equals(Object o) {
            if (this.data == o) return true;
            if (o == null) return false;
            T newData = (T) o;
            return Objects.equals(data, newData);
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }
    }

    public Node<T> head, tail = null;

    public void addEndNode(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void addFirstNode(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void addNodeAfter(Node<T> prevNode, T data) {
        if (prevNode == null) {
            System.out.println("The previous node cannot be null");
            return;
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    public int countNodes() {
        int count = 0;
        Node<T> current = head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void display() {
        Node<T> current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void remove(int position) {
        if (head == null)
            return;
        Node<T> newNode = head;
        if (position == 0) {
            head = newNode.next;
            return;
        }
        for (int i = 0; newNode != null && i < position - 1; i++) {
            newNode = newNode.next;
        }
        if (newNode == null || newNode.next == null) {
            System.err.println("The position is out of the list");
        }
        if (newNode != null) {
            newNode.next = newNode.next.next;
        }
    }


    public void reverse(Node<T> current) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            if (current.next == null) {
                System.out.print(current.data + " ");
                return;
            }
            reverse(current.next);
            System.out.print(current.data + " ");
        }
    }
    public void removeReverseElement(T findElement) {
        Node<T> runnerNode = head;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        for (int i = 0; runnerNode != null; i++) {
            if (runnerNode.equals(findElement)) {
                nextNode = runnerNode.next;
                remove(i);

                if (nextNode == null || nextNode.next == null)
                    return;

                Node<T> tempNode = nextNode.next;
                nextNode.next = nextNode.next.next;
                tempNode.next = nextNode;

                if (previousNode == null) {
                    head = tempNode;
                } else {
                    previousNode.next = tempNode;
                }
            }
            previousNode = runnerNode;
            runnerNode = runnerNode.next;
        }
    }

    public SinglyLinkedList<Integer> findMaxUnpairedNums() {
        Node<T> runnerNode = head;
        SinglyLinkedList<Integer> countList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> currentCountList = new SinglyLinkedList<>();
        for (int i = 0; runnerNode != null; i++) {
            if (((Integer) runnerNode.getData()) % 2 != 0) {
                currentCountList.addEndNode((Integer) (runnerNode.data));
            } else {
                if (currentCountList.countNodes() > countList.countNodes())
                    countList = currentCountList;
                currentCountList = new SinglyLinkedList<>();
            }
            runnerNode = runnerNode.next;
        }
        return countList;
    }
}

