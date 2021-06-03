package lab6;

public class Main {
    public static void main(String[] args) {
        Hash myHash = new Hash();

        myHash.put(1, 23);
        myHash.put(8, 44);
        myHash.put(7, 25);
        myHash.put(7, 90);
        myHash.put(21, 77);
        myHash.put(7, 88);
        myHash.put(9, 24);
        myHash.put(8, 43);
        myHash.put(8, 56);
        myHash.put(100, 22);
        myHash.put(55, 88);
        myHash.put(22, 99);

        Data data = myHash.search(8);
        data.print();
        data = myHash.search(16);
        data.print();
        data = myHash.search(5);
        data.print();


        myHash.display();
    }
}
