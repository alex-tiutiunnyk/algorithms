package lab4;

import lab5.listStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class linkedList<T> {
    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> first = null;

    public void addElement(T data) {
        Node<T> newFirst = new Node<T>(data);
        newFirst.next = first;
        first = newFirst;
    }

    public T deleteElement() {
        Node<T> oldFirst = first;
        first = first.next;
        return oldFirst.data;
    }

    @Override
    public String toString() {
        StringBuilder listBuilder = new StringBuilder();
        Node<T> currentNode = first;
        while (currentNode != null) {
            listBuilder.append(currentNode).append(", ");
            currentNode = currentNode.next;
        }
        return listBuilder.toString();
    }

    public static void negativeNums(listStack<Integer> list) {
        boolean haveNegatives = false;
        int maxElement = 0;
        int maxElementIndex = 0;
        List<Integer> nums = new ArrayList<>();
        String tempList = list.getLinkedList().toString();
        List<String> numList = new ArrayList<>(Arrays.asList(tempList.split(", ")));
        for (String i: numList) {
            nums.add(Integer.valueOf(i));
        }
        System.out.println(nums);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < 0) {
                    if(nums.get(i) < maxElement){
                        maxElement = nums.get(i);
                        maxElementIndex = i;
                    }
                haveNegatives = true;
            }
        }
        if (haveNegatives) {
            System.out.println("MaxNegativeElement index: " + maxElementIndex + "   value: " + maxElement);
            int i = 0;
            do {
                list.pop();
                i++;
            } while (i <= maxElementIndex);
        } else  //інакше вивід, що від'ємних елементів взагалі немає
            System.out.println("there is no negative");
    }

    public boolean isEmpty() {
        return first == null;
    }
}
