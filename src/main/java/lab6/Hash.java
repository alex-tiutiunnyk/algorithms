package lab6;

import java.util.Hashtable;

public class Hash {
        private int size;
        private Data[] hashTable = new Data[4];

        int hash(int key) {
            return key % hashTable.length;
        }
        int rehash(int key, int iteration) {
            if (iteration <= 0)
                throw new IllegalArgumentException("Second argument in 'rehash()' must be more than 0");
            return hash(key) + iteration * iteration;
        }
        void rebuild() {
            Data[] temp = new Data[(int)(hashTable.length * 1.5)];
            System.arraycopy(hashTable, 0, temp, 0, hashTable.length);
            hashTable = temp;
        }

        void put(int key, int value) {
            if (size >= (3 * hashTable.length) / 4)
                rebuild();

            int index = hash(key);

            int i = 1;
            while ((hashTable[index]) != null) {
                index = rehash(key, i);
                ++i;
                while (index >= hashTable.length)
                    rebuild();
            }
            hashTable[index] =  new Data(key, value);
            ++size;
        }

        public Data search(int key) {
            int index = hash(key);
            Data val;
            int i = 1;

            while ((val = hashTable[index]) != null) {
                if (val.getKey() == key)
                    return val;
                index = rehash(key, i);
                ++i;
                if (index >= hashTable.length) {
                    System.out.println("\n There's no element with key" + key);
                    return null;
                }
            }
            System.out.println("\n There's no element with key" + key);
            return null;
        }

        public void display() {
            Data val;
            for (Data i : hashTable) {
                if (i != null) {
                    val = i;
                    val.print();
                } else
                    System.out.print(i + " ");
            }
        }
}
