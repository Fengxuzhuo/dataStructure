package com.atguigu.algorithm.sortalgorithm;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {101, 34, 119, 1};

        selectSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

    }


    //选择排序  时间复杂度为 O(n^2)
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            //假定这个数使最小
            int minIndex = i;
            int min = arr[i];
            for (int j =i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    //重置最小值和对应下标
                    min = arr[j];
                    minIndex = j;
                }
            }

            //将最小值 放在arr[o], 交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println("第" + (i+1) + "轮排序后");
            System.out.println(Arrays.toString(arr));
        }

    }
}
