package lab5;

//Реалізувати стек на основі масиву, виконати завдання.
//Потім реалізувати стек на основі зв’язаного
//списку і теж виконати завдання.


import lab4.linkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Array Stack");
        arrStack arrStack = new arrStack(7);
        arrStack.push(5);
        arrStack.push(20);
        arrStack.push(-20);
        arrStack.push(-40);
        arrStack.push(10);
        arrStack.push(-30);
        arrStack.push(30);
        System.out.println("isEmpty:  " + arrStack.isEmpty());
        System.out.println("topElement:  " + arrStack.peek());
        arrStack.display();
        lab5.arrStack.deleteMaxNegative(arrStack);
        arrStack.display();

        System.out.println();
        System.out.println();

        System.out.println("List Stack");
        listStack<Integer> list = new listStack<>();
        System.out.println("isEmpty: " + list.isEmpty());
        list.push(1);
        list.push(2);
        list.push(-9);
        list.push(3);
        list.push(-3);
        list.push(-11);
        list.push(0);

        list.display();
        linkedList.negativeNums(list);
        list.display();


    }
}
