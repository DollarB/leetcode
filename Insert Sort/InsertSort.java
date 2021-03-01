package com.example.interview.util.sort;

/**
 * 插入排序
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/19 22:06
 */
public class InsertSort {

    public static int[] insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int index = i - 1;
            while (index >= 0 && insertVal < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = insertVal;
        }
        return arr;
    }
}
