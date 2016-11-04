package com.taejun.data_structure;

import java.util.Arrays;

/**
 * Created by leetaejun on 2016. 10. 23..
 */


public class BinarySearchDriver {
    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,34,35,40,60};
        Arrays.sort(arr);
        System.out.println(new BinarySearchDriver().findValueByBinarySearch(arr, 10));
        System.out.println(new BinarySearchDriver().findValueByRecursiveBinarySearch(arr, 10, 0, arr.length-1));
    }

    /**
     * 이진 탐색 (반복문)
     *
     * @param arr arr는 int[] 타입으로 정열된 이진 탐색을 가할 배열을 넣어줍니다.
     * @param target target은 int 타입으로 배열에서 찾을 값을 넣어줍니다.
     * @return int 해당 target 값이 있으면 배열의 index를 리턴합니다 없을 시에는 -1을 리턴합니다.
     */
    public int findValueByBinarySearch(int[] arr, int target) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }

        int minIndex = 0;
        int maxIndex = arr.length-1;

        while (minIndex <= maxIndex) {
            int midIndex = (minIndex + maxIndex) / 2;
            if (arr[midIndex] == target) {
                return midIndex;
            } else if (arr[midIndex] < target) {
                minIndex = midIndex + 1;
            } else {
                maxIndex = midIndex - 1;
            }
        }

        return -1;
    }

    /**
     * 이진 탐색 (재귀)
     *
     * @param arr arr는 int[] 타입으로 정열된 이진 탐색을 가할 배열을 넣어줍니다.
     * @param target target은 int 타입으로 배열에서 찾을 값을 넣어줍니다.
     * @return int 해당 target 값이 있으면 배열의 index를 리턴합니다 없을 시에는 -1을 리턴합니다.
     */
    public int findValueByRecursiveBinarySearch(int arr[], int target, int minIndex, int maxIndex) {
        if (minIndex > maxIndex) {
            return -1;
        }

        int midIndex = (minIndex + maxIndex) / 2;
        if (arr[midIndex] == target) {
            return midIndex;
        } else if (arr[midIndex] < target) {
            return findValueByRecursiveBinarySearch(arr, target, midIndex+1, maxIndex);
        } else {
            return findValueByRecursiveBinarySearch(arr, target, minIndex, midIndex-1);
        }
    }
}
