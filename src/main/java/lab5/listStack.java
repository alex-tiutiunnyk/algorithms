package lab5;

import lab4.linkedList;

import java.util.Arrays;


public class listStack<T> {
    private final lab4.linkedList<T> linkedList = new linkedList<>();

    public lab4.linkedList<T> getLinkedList() {
        return linkedList;
    }

    public void push(T data) {
        linkedList.addElement(data);
    }

    public T pop() {
        return linkedList.deleteElement();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void display() {
        System.out.println(getLinkedList().toString());
    }
    public void deleteMaxNegElement(listStack<Integer> list) {
        boolean haveNegatives = false;
        int maxElement = 0;
        int maxElementIndex = 0;
int size = list.toString().length();

        for (int i = 0; i< size; i++){

        }


       /*
        String elList = getLinkedList().toString();
//        System.out.println(elList);
//        int temp = Integer.parseInt(elList);
       *//* String[] tempList = elList.split(", ");
        System.out.println(Arrays.toString(tempList));*//*
        String[] items = elList.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\\s", "").split(", ");
        System.out.println(Arrays.toString(items));
        int[] results = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            results[i] = Integer.parseUnsignedInt(items[i]);
        }
        System.out.println(Arrays.toString(results));*/
       /* int[] t = new int[tempList.length];
        for (int i = 0; i< tempList.length; i++){
            t[i] = Integer.divideUnsigned((int)elList, );
        }
        System.out.println(Arrays.toString(t));*/

       /* for (int i = 0; i < tempList.length; i++) {
            System.out.print(tempList[i] + " ");
            if(tempList[i] < 0){
                if(haveNegatives){
                    if(tempList[i])
                }
            }
        }
        System.out.println();*/
    }
}
