package com.taejun.problem_solving;

import java.util.Scanner;

/**
 * index로 장난을 해보자
 * 5를 입력하면
 * 54321
 * 5432
 * 543
 * 54
 * 5
 * 와 같이 출력되도록 구현하기
 * Created by leetaejun on 2016. 10. 27..
 */
public class IndexJoke {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            new IndexJoke().printIndexJoke(scanner.nextInt());
        }
    }

    public void printIndexJoke(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = num; j > i; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
