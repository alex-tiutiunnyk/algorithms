/*Тютюнник Олександра ТІ-92 варіант 13
 * сортування злиттям та сортування за розрядами*/

import java.util.*;
import java.lang.*;

public class lab2MergeSort {

    public static Integer[] a = new Integer[20];


    public static void createArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
    }
    public static void sortAscendingArr(Integer[] arr) {
        Arrays.sort(arr);
    }

    public static void sortDescendingArr(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
    }

    public static void merge(int begin, int end) {
        int mid = (begin + end) / 2;
        int[] t = new int[end - begin + 1];
        int index_1 = begin;
        int index_2 = mid + 1;
        int index_t = 0;
        while ((index_1 <= mid) || (index_2 <= end)) {
            if (index_1 > mid) {
                t[index_t++] = a[index_2++];
                continue;
            }
            if (index_2 > end) {
                t[index_t++] = a[index_1++];
                continue;
            }
            if (a[index_2] > a[index_1]) {
                t[index_t++] = a[index_1++];
            } else {
                t[index_t++] = a[index_2++];
            }
        }
        for (int i = 0; i < end - begin + 1; i++) {
            a[i + begin] = t[i];
        }
        System.out.println(Arrays.toString(t));
    }

    public static void mergeSort(int start, int finish) {
        if (start == finish)
            return;
        int mid = (start + finish) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, finish);
        merge(start, finish);
    }

    public static void main(String[] args) {
        createArr(a);
        System.out.println(Arrays.toString(a));

        long startTime1 = System.nanoTime();

        mergeSort(0, a.length - 1);

        long stopTime1 = System.nanoTime();
        long time1 = stopTime1 - startTime1;
        System.out.println("Execution time: " + time1 + " nanoseconds");


        sortAscendingArr(a);
        System.out.println(Arrays.toString(a));

        long startTime2 = System.nanoTime();

        mergeSort(0, a.length - 1);

        long stopTime2 = System.nanoTime();
        long time2 = stopTime2 - startTime2;
        System.out.println("Execution time: " + time2 + " nanoseconds");



        sortDescendingArr(a);
        System.out.println(Arrays.toString(a));

        long startTime3 = System.nanoTime();

        mergeSort(0, a.length - 1);
        long stopTime3 = System.nanoTime();
        long time3 = stopTime3 - startTime3;
        System.out.println("Execution time: " + time3 + " nanoseconds");
    }
}

