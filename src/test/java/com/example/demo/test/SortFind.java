package com.example.demo.test;

import java.util.Arrays;

/**
 * Created by ChenLY on 2017-09-14.
 */
public class SortFind {


    public static void main(String[] args) {
        int[] a = {5, 2, 6, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(find(a, 9));
    }


    /**
     * bubbleSort
     * @param a
     */
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) { //n-1次排序
            for (int j = 0; j < a.length - i; j++) { //第i次排序进行n-i次比较
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


    /**
     * binarySearch
     * @param a
     * @param key
     * @return
     */
    public static int find(int[] a, int key) {
        sort(a);
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] > key) {
                end = mid -1;
            } else if (a[mid] < key) {
                start = mid + 1;
            } else if (a[mid] == key) {
                return mid;
            }
        }
        return -1;
    }

}
