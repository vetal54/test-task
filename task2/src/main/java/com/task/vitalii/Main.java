package main.java.com.task.vitalii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
        the main method is actually only needed to enter data, and to display the answer,
        the main task is performed by the dijkstra method, which works according to the dijkstra algorithm,
        this method returns an array of numbers, which will have a set of minimum trips from each city,
        it remains only to subtract the necessary costs and get, sort of, the right answer
    */
       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int size;
        int count;
        int testCount;
        List<String> sitesName = new ArrayList<>();
        int[][] array;
        for (int i = 0; i < a; i++) {
            size = Integer.parseInt(scanner.nextLine());
            array = new int[size][size];
            for (int j = 0; j < size; j++) {
                sitesName.add(scanner.nextLine());
                count = Integer.parseInt(scanner.nextLine());
                for (int k = 0; k < count; k++) {
                    int[] arr = getArray(scanner.nextLine());
                    array[j][arr[0] - 1] = arr[1];
                    array[arr[0] - 1][j] = arr[1];
                }
            }
            testCount = Integer.parseInt(scanner.nextLine());
            int[] minCost = dijkstra(size, array);
            for (int j = 0; j < testCount; j++) {
                String[] sites = scanner.nextLine().split(" ");
                System.out.println(minCost[sitesName.indexOf(sites[1])] - minCost[sitesName.indexOf(sites[0])]);
            }
        }
    }

    public static int[] dijkstra(int size, int[][] array) {
        int[] d = new int[size];
        int[] v = new int[size];
        int temp;
        int minIndex;
        int min;
        int beginIndex = 0;

        for (int i = 0; i < size; i++) {
            d[i] = 10000;
            v[i] = 1;
        }

        d[beginIndex] = 0;

        do {
            minIndex = 10000;
            min = 10000;
            for (int i = 0; i < size; i++) {
                if ((v[i] == 1) && (d[i] < min)) {
                    min = d[i];
                    minIndex = i;
                }
            }
            if (minIndex != 10000) {
                for (int i = 0; i < size; i++) {
                    if (array[minIndex][i] > 0) {
                        temp = min + array[minIndex][i];
                        if (temp < d[i]) {
                            d[i] = temp;
                        }
                    }
                }
                v[minIndex] = 0;
            }
        } while (minIndex < 10000);
        return d;
    }

    public static int[] getArray(String str) {
        return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
