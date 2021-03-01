package com.example.interview.util.sort;

/**
 * 归并排序
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/20 21:13
 */
public class MergeSort {

    /**
     * 归并排序入口
     *
     * @param data
     * @return
     */
    public static int[] mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
        return data;
    }

    /**
     * 对左右两边的数据进行递归
     *
     * @param data
     * @param left
     * @param right
     */
    public static void sort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }

        int center = (left + right) / 2;
        sort(data, left, center);
        sort(data, center + 1, right);
        merge(data, left, center, right);
    }

    /**
     * 将两个数组进行归并
     *
     * @param data
     * @param left
     * @param center
     * @param right
     */
    public static void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int mid = center + 1;
        int third = left;
        int tmp = left;
        while (left <= center && mid <= right) {
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }

        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }

        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }
}
