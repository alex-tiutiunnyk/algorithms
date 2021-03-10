/*Тютюнник Олександра ТІ-92 варіант 13
 * сортування злиттям та сортування за розрядами*/

import java.util.Arrays;
import java.util.Collections;

public class lab2RadixSort {

    public static void createArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 5000);
        }
    }

    public static void sortAscendingArr(Integer[] arr) {
        Arrays.sort(arr);
    }

    public static void sortDescendingArr(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
    }

    // Using counting sort to sort the elements in the basis of significant places
    void countingSort(Integer[] array, int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
            count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
            count[(array[i] / place) % 10]++;

        // Calculate cummulative count
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
            array[i] = output[i];
    }

    // Function to get the largest element from an array
    int getMax(Integer[] array, int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    // Main function to implement radix sort
    void radixSort(Integer[] array, int size) {
        // Get maximum element
        Integer max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
            countingSort(array, size, place);
    }

    public static void main(String args[]) {


        lab2RadixSort rs = new lab2RadixSort();
        Integer[] data = new Integer[50000];
        int size = data.length;
        createArr(data);
        System.out.println(Arrays.toString(data));

        long startTime1 = System.nanoTime();
        rs.radixSort(data, size);

        System.out.println(Arrays.toString(data));
        long stopTime1 = System.nanoTime();
        long time1 = stopTime1 - startTime1;
        System.out.println("Execution time: " + time1 + " nanoseconds");


        sortAscendingArr(data);
        System.out.println(Arrays.toString(data));

        long startTime2 = System.nanoTime();
        rs.radixSort(data, size);

        System.out.println(Arrays.toString(data));
        long stopTime2 = System.nanoTime();
        long time2 = stopTime2 - startTime2;
        System.out.println("Execution time: " + time2 + " nanoseconds");


        sortDescendingArr(data);
        System.out.println(Arrays.toString(data));

        long startTime3 = System.nanoTime();
        rs.radixSort(data, size);

        System.out.println(Arrays.toString(data));
        long stopTime3 = System.nanoTime();
        long time3 = stopTime3 - startTime3;
        System.out.println("Execution time: " + time3 + " nanoseconds");




    }
}
