package src.first.tutorial;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Random random = new Random();
    private static final String MARK = "*";

    public static void main(String[] args) {
        exercise6();
        exercise7();
    }

    private static void exercise7() {
        System.out.println("Enter your number: ");
        String inputString = new Scanner(System.in).next();
        int n = Integer.parseInt(inputString);
        if(n < 5 || (n % 2) == 0) {
            System.out.println("Number is wrong. The number must be greater than 5 and must be odd.");
        }
        else {
            for(int i = 0; i < n; i++) {
                System.out.print(MARK);
            }
            System.out.println();
            for(int i = 1; i < n - 1; i++) {
                for(int j = 1; j <= n; j++) {
                    if(j == i + 1 || j == 1 || j == n) {
                        System.out.print(MARK);
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            for(int i = 0; i < n; i++) {
                System.out.print(MARK);
            }
        }
    }

    private static void exercise6() {
        int arrSize = 10;
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = random.nextInt(901) + 100;
        }
        printArr(arr, "Generated array:");
        sortArr(arr);
        printArr(arr, "Sorted array:");
    }

    private static void sortArr(int[] arr) {
        int tmp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr [j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    private static void printArr(int[] arr, String prefix) {
        System.out.print(prefix + " [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length -1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
