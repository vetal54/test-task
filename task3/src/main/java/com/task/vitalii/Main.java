package main.java.com.task.vitalii;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Output: " + getSum(n));
    }

    //method for getting factorial
    public static BigInteger getFactorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /*
        method that calculates the sum of the numbers of a number
        we use a large integer because the factorial of 100 doesn't fit into an integer or long
    */
    public static BigInteger getSum(int n) {
        BigInteger factorial = getFactorial(n);
        BigInteger result = BigInteger.valueOf(0);
        while (factorial.compareTo(BigInteger.valueOf(0)) > 0) {
            result = result.add(factorial.mod(BigInteger.valueOf(10)));
            factorial = factorial.divide(BigInteger.valueOf(10));
        }
        return result;
    }
}
