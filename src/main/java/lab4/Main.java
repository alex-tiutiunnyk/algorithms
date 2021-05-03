package lab4;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> temp = new SinglyLinkedList<>();
        temp.addEndNode(1);
        temp.addEndNode(2);
        temp.addFirstNode(3);
        temp.addFirstNode(4);
        temp.addEndNode(7);
        temp.addEndNode(9);
        temp.addEndNode(1);
        temp.addEndNode(3);
        temp.addEndNode(5);
        temp.addEndNode(9);
        temp.addEndNode(8);

        temp.display();
        System.out.println();
        System.out.println("Checking, removing and reversing...");
        temp.removeReverseElement(1);
        temp.display();

        System.out.println();
        System.out.println("The max sequence of unpaired numbers:");
        SinglyLinkedList<Integer> singlyLinkedList = temp.findMaxUnpairedNums();
        singlyLinkedList.display();


        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addNode("a");
        doublyLinkedList.addNode("c");
        doublyLinkedList.addNode("e");
        doublyLinkedList.addNode("f");
        doublyLinkedList.addNode("l");
        doublyLinkedList.display();
        doublyLinkedList.removeByElement("l");
        doublyLinkedList.display();
        doublyLinkedList.removeByIndex(3);
        doublyLinkedList.display();



 /*  SinglyLinkedList<String> test = new SinglyLinkedList<>();
        test.addEndNode("a");
        test.addEndNode("b");
        test.addFirstNode("c");

        test.display();
        test.remove(1);
        test.display();*/
    }
}
