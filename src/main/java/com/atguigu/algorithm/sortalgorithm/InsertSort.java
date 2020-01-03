package com.atguigu.algorithm.sortalgorithm;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        //定义一个二维数组
        int[] arr = {101, 34, 119, 1};

        insertSort(arr);

    }



    /**
     * 插入排序
     * 将待排序的n个元素分成一个有序表（只有一个元素）和一个无序表（n-1个元素）
     * 每次将无序表中的第一个元素的排序码跟有序表的排序码依次进行比较，找到合适的位置插入
     * @param arr
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;

            //insertIndex >=0 保证待插入的数下标不越界
            //insertVal < arr[insertIndex] 表明待插入的数还没有找到待插入的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //需要将arr[insertIndex] 后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //当while循环结束时，说明插入的位置找到，insertIndex+1
            //判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第" + i + "轮排序结果为");
            System.out.println(Arrays.toString(arr));
        }

    }
}
