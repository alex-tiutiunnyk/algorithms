package lab5;

public class arrStack implements IStack {
    public int max;
    public int top;
    public int[] a;

    public arrStack(int size) {
        max = size;
        a = new int[max];
        top = -1;
    }

    public void push(int element) {
        if (top >= (max - 1)) {
            System.err.println("Stack Overflow");
        } else {
            a[++top] = element;
        }
    }

    public void pop() {
        if (top < 0) {
            System.err.println("Stack Underflow");
        } else {
            top--;
        }
    }

    public int peek() {
        if (top < 0) {
            System.err.println("Stack Underflow");
            return 0;
        } else {
            return a[top];
        }
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(a[i] + "   ");
        }
        System.out.println();
    }

    public static void deleteMaxNegative(arrStack s) {
        boolean haveNegatives = false;
        int maxElement = 0;
        int maxElementIndex = 0;
        //пошук максимально від'ємного елемента стеку
        for (int i = 0; i < s.a.length; i++) {
            if (s.a[i] < 0) {
                    if (s.a[i] < maxElement) {
                        maxElement = s.a[i];
                        maxElementIndex = i;
                    }
                haveNegatives = true;
            }
        }
        //видалення усіх елементів до максимального
        if (haveNegatives) {
            System.out.println("MaxNegativeElement index: " + maxElementIndex + "   value: " + maxElement);
            int i = s.a.length-1;
            do {
                s.pop();
                i--;
            } while (i >= maxElementIndex);
        } else  //інакше вивід, що від'ємних елементів взагалі немає
            System.out.println("there is no negative");
    }
}

