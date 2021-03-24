import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab3Sort {

    static Integer numberOfWords = 0;
    public static String[] randomStrings = new String[numberOfWords];

    public static String[] generateRandomWords(Integer numberOfWords) {
        randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static void main(String[] args) {

        int indexOfWord = 0;

        /*System.out.println(Arrays.toString(generateRandomWords(100)));

        System.out.println();*/
        System.out.println("Рекурсивный алгоритм:");
        generateRandomWords(100);
        long startTime1 = System.nanoTime();
        indexOfWord = algorithmRecursive(randomStrings, 0, randomStrings.length-1, 'a');

        long stopTime1 = System.nanoTime();
        long time1 = stopTime1 - startTime1;
        System.out.println("Знайдене слово на літеру а:  " + randomStrings[indexOfWord]);
        System.out.println("Execution time: " + time1 + " nanoseconds");



       /* System.out.println(Arrays.toString(generateRandomWords(5000)));

        System.out.println();*/
        generateRandomWords(5000);
        long startTime2 = System.nanoTime();
        indexOfWord = algorithmRecursive(randomStrings, 0, randomStrings.length-1, 'a');

        long stopTime2 = System.nanoTime();
        long time2 = stopTime2 - startTime2;
        System.out.println("Знайдене слово на літеру а:  " + randomStrings[indexOfWord]);
        System.out.println("Execution time: " + time2 + " nanoseconds");



        /*System.out.println(Arrays.toString(generateRandomWords(14000)));

        System.out.println();*/
        generateRandomWords(14000);
        long startTime3 = System.nanoTime();
        indexOfWord = algorithmRecursive(randomStrings, 0, randomStrings.length-1, 'a');

        long stopTime3 = System.nanoTime();
        long time3 = stopTime3- startTime3;
        System.out.println("Знайдене слово на літеру а:  " + randomStrings[indexOfWord]);
        System.out.println("Execution time: " + time3 + " nanoseconds");


        System.out.println();
        /*System.out.println(Arrays.toString(generateRandomWords(100)));

        System.out.println();*/
        System.out.println("Итеративный алгоритм:");
        generateRandomWords(100);
        long start1 = System.nanoTime();
        algorithmIterative(randomStrings);

        long stop1 = System.nanoTime();
        long tim1 = stop1 - start1;
        System.out.println("Execution time: " + tim1 + " nanoseconds");



        /*System.out.println(Arrays.toString(generateRandomWords(5000)));

        System.out.println();*/
        generateRandomWords(5000);
        long start2 = System.nanoTime();
        algorithmIterative(randomStrings);

        long stop2 = System.nanoTime();
        long tim2 = stop2 - start2;
        System.out.println("Execution time: " + tim2 + " nanoseconds");



        /*System.out.println(Arrays.toString(generateRandomWords(14000)));

        System.out.println();*/
        generateRandomWords(14000);
        long start3 = System.nanoTime();
        algorithmIterative(randomStrings);

        long stop3 = System.nanoTime();
        long tim3 = stop3 - start3;
        System.out.println("Execution time: " + tim3 + " nanoseconds");
    }


    public static int algorithmRecursive(String []arr, int l, int r, char x)
    {
        if (r < l)
            return -1;
        if (arr[l].charAt(0)==x)
            return l;
        if (arr[r].charAt(0)==x)
            return r;
        return algorithmRecursive(arr, l+1, r-1, x);
    }

    public static void algorithmIterative(String[] words) {
        System.out.print("Знайдене слово на літеру а:  ");
        boolean found = false;
        for (String s : words) {
            String word = s.toLowerCase();
            String first = String.valueOf(word.charAt(0));
            if ("a".equals(first)) {
                System.out.print(word);
                found = true;
            }
            if (found) break;
        }
        System.out.println();
    }
}


