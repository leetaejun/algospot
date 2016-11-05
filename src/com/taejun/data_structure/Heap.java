package com.taejun.data_structure;

/**
 * 힙 자료구조 구현하기
 * Created by leetaejun on 2016. 10. 29..
 */
public class Heap {
    public enum HeapType {
        MINHEAP,
        MAXHEAP
    }

    private HeapType heapType;
    private int[] data;
    private int capacity;
    private int size;

    public Heap(HeapType heapType, int capacity) {
        this.heapType = heapType;
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void swapValueByIndex(int firstIndex, int secondIndex) {
        int temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }

    public void insert(int value) {
        int pointer; // index pointer;

        if (isFull()) {
            System.out.println("힙이 가득 찼습니다");
        } else {
            // 가장 끝에 데이터 삽입
            data[size] = value;
            pointer = size;
            size++;
            if (heapType == HeapType.MINHEAP) {
                // 부모와 비교해서 스왑하기
                while (pointer > 0 && data[pointer] < data[(pointer - 1) / 2]) {
                    swapValueByIndex(pointer, (pointer - 1) / 2);
                    pointer = (pointer - 1) / 2;
                }
            } else if (heapType == HeapType.MAXHEAP) {
                // 부모와 비교해서 스왑하기
                while (pointer > 0 && data[pointer] > data[(pointer - 1) / 2]) {
                    swapValueByIndex(pointer, (pointer - 1) / 2);
                    pointer = (pointer - 1) / 2;
                }
            } else {
                // NONE.
            }
        }
    }

    public int delete() {
        int pointer = 0;
        if (isEmpty()) {
            return -1;
        } else {
            int rootValue = data[0];
            data[0] = data[--size];
            data[size] = 0;

            if (heapType == HeapType.MINHEAP) {
                while (pointer < size) {
                    int leftPointer = pointer * 2 + 1;
                    int rightPointer = pointer * 2 + 2;

                    if (leftPointer >= size) break;

                    if (rightPointer >= size) {
                        if (data[pointer] > data[leftPointer]) {
                            swapValueByIndex(pointer, leftPointer);
                            pointer = leftPointer;
                            continue;
                        } else {
                            break;
                        }
                    }

                    if (data[leftPointer] < data[rightPointer]) {
                        if (data[pointer] > data[leftPointer]) {
                            swapValueByIndex(pointer, leftPointer);
                            pointer = leftPointer;
                        } else {
                            break;
                        }
                    } else {
                        if (data[pointer] > data[rightPointer]) {
                            swapValueByIndex(pointer, rightPointer);
                            pointer = rightPointer;
                        } else {
                            break;
                        }
                    }
                }
            } else {

            }

            return rootValue;
        }
    }
}
