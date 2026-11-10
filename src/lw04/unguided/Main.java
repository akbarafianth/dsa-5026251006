package lw04.unguided;
import java.util.Scanner;

public class Main {
    static int steps;

    static void bubbleSort(int[] array, int awal, int akhir) {
        for (int i = awal; i < akhir; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }

    static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        steps = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int a = sc.nextInt();
        int[] array = new int[a];
        for (int i = 0; i < a; i++) {
            array[i] = sc.nextInt();
        }

        int b = sc.nextInt();
        int[] targets = new int[b];
        for (int i = 0; i < b; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        bubbleSort(array, 0, 2);
        int[] afterTwoPasses = array.clone();
        bubbleSort(array, 2, a - 1);

        System.out.println("==== After 2 Passes ====");
        for (int i = 0; i < a; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(afterTwoPasses[i]);
        }
        System.out.println();

        System.out.println("==== Fully Sorted ====");
        for (int i = 0; i < a; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(array[i]);
        }
        System.out.println();

        System.out.println("==== Search Results ====");
        for (int i = 0; i < b; i++) {
            int idxketemu = binarySearch(array, targets[i]);
            if (idxketemu != -1) {
                System.out.println(targets[i] + ": FOUND at index " + idxketemu + " (steps: " + steps + ")");
            } else {
                System.out.println(targets[i] + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }
}