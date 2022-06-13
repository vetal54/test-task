package main.java.com.task.vitalii;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long answer = getFactorial(2 * n) / (getFactorial(n + 1) * getFactorial(n)); //catalan number formula
        System.out.println("Output: " + answer);
    }

    //method for getting factorial
    public static long getFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
