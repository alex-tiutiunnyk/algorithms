package lab6;

public class Data {
    private final int key;
    private final int value;

    Data(int k, int v) {
        key = k;
        value = v;
    }
    int getKey() { return key; }
    void print() {
        System.out.print("[" + key + ", " + value + "] ");
    }
}
