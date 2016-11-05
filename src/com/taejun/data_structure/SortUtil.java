package com.taejun.data_structure;

/**
 * Created by leetaejun on 2016. 10. 24..
 */
public class SortUtil {
    public static void main(String[] args) {
        /*
        int[] arr = {10, 1, 5, 2, 8, 20, 17, 11, 3};
        for (int value : arr) {
            System.out.print(value + ", ");
        }
        System.out.println();
        //new SortUtil().insertionSort(arr);
        //new SortUtil().selectionSort(arr);
        new SortUtil().bubbleSort(arr);
        for (int value : arr) {
            System.out.print(value + ", ");
        }
        */

        int[] countingArr = {0,4,5,9,10,50,100,100,60,4,7,4,5,9,100,50,55,55};
        countingArr = new SortUtil().countingSort(countingArr);
        for (int value : countingArr) {
            System.out.print(value + ", ");
        }
    }

    private int[] countingSort(int[] arr) {
        int[] countArr = new int[101];
        int[] resultArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        for (int i = 0; i < countArr.length-1; i++) {
            countArr[i+1]+=countArr[i];
        }

        for (int i = arr.length-1; i >= 0; i--) {
            resultArr[--countArr[arr[i]]] = arr[i];
        }

        return resultArr;
    }

    private void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i-1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    minIndex = j;
                } else {
                    break;
                }
            }

            int temp = array[i];
            for (int k = i; k > minIndex; k--) {
                array[k] = array[k-1];
            }
            array[minIndex] = temp;
        }
    }

    private void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    private void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean isChange = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    isChange = true;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }

            if (!isChange) {
                break;
            }
        }
    }
}
