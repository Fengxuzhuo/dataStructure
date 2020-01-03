package com.atguigu.algorithm.sortalgorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {8, 4, 5, 7 ,1, 3, 6 ,2};
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("排序后" + Arrays.toString(arr));

    }


    /**
     * 分 + 合 的方法
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {

            int mid = (left + right) / 2;

            //向左递归合并
            mergeSort(arr, left, mid, temp);
            //向右递归合并
            mergeSort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }



    /**
     * 合并的方法
     * @param arr    原始数组
     * @param left   左边有序序列的初始索引
     * @param mid    中间索引
     * @param right  右边有序序列的初始索引
     * @param temp   临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int t = 0;

        //先把左右两边的有序序列的数据移动到temp中
        while (i <= mid && j <= right) {
            //
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }


        //把左边或右边的剩余的数据全部依次移动到temp中
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //把temp中的数据全部移到数组中
        t = 0;
        int tempLeft = left;

        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

}
