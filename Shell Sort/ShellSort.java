package com.example.interview.util.sort;

/**
 * 希尔排序
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/20 21:00
 */
public class ShellSort {

    public static int[] shellSort(int[] arr) {
        int dk = arr.length / 3 + 1;
        while (dk != 1) {
            shellInsertSort(arr, dk);
            dk = dk / 3 + 1;
        }
        if (dk == 1) {
            shellInsertSort(arr, dk);
        }
        return arr;
    }

    public static void shellInsertSort(int[] a, int dk) {
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {
                int j;
                int x = a[i];
                a[i] = a[i - dk];
                for (j = i - dk; j >= 0 && x < a[j]; j = j - dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = x;
            }
        }
    }
}
