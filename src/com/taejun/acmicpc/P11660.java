package com.taejun.acmicpc;

import java.util.Scanner;

/**
 * 구간 합 구하기 5
 * https://www.acmicpc.net/problem/11660
 * Created by leetaejun on 2016. 11. 9..
 */
public class P11660 {

    static int a[][] = new int[1025][1025];
    static int s[][] = new int[1025][1025];

    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scanner.nextInt();
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
            }
        }

        while (m > 0) {
            int x1, y1, x2, y2;
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            System.out.println(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1]);
            m--;
        }
    }
}
