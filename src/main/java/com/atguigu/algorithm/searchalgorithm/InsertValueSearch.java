package com.atguigu.algorithm.searchalgorithm;

import java.util.Arrays;

public class InsertValueSearch {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr));

        int index = insertValueSearch(arr, 0, arr.length - 1, 15);

        System.out.println("index = " + index);

    }


    /**
     * 插值查找
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        if (findVal > arr[mid]) {
            //向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            //向左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
