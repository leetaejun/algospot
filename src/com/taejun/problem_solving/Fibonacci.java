package com.taejun.problem_solving;

import java.util.Scanner;

/**
 * 피보나치 수 구하기
 * Created by leetaejun on 2016. 11. 5..
 */
public class Fibonacci {

    static int[] fibonacciArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            long fibonacciNumber = scanner.nextLong();
            System.out.println(findFiboNumber(fibonacciNumber));
            //System.out.println(findFiboNumberByRecursive(fibonacciNumber));
        }
    }

    private static long findFiboNumber(long fibonacciNumber) {
        long firstNumber = 0, secondNumber = 1;
        long resultNumber = 1;
        for (int i = 2; i <= fibonacciNumber; i++) {
            resultNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = resultNumber;
        }

        return resultNumber;
    }

    private static int findFiboNumberByRecursive(int fibonacciNumber) {
        if (fibonacciNumber == 0) {
            return 0;
        } else if (fibonacciNumber == 1) {
            return 1;
        }

        return findFiboNumberByRecursive(fibonacciNumber-1) + findFiboNumberByRecursive(fibonacciNumber-2);
    }
}
