package com.atguigu.algorithm.sortalgorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {-9, 28, 0, 23, -567, 70};

        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后" + Arrays.toString(arr));

    }


    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {

        int l = left;  //左下标
        int r = right;  //右下标
        int pivot = arr[(left + right) / 2];
        int temp = 0;

        //while循环使比pivot小的放到左边，大的放到右边
        while (l < r) {

            //在pivot左边一直找，直到找到比pivot大的，退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot右边一直找，直到找到比pivot小的，退出
            while (arr[r] > pivot) {
                r -= 1;
            }

            //如果 l >= r，说明pivot两边的值，已经按照左边全部是小于pivot值，右边全部是大于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[l] == pivot, r--前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现arr[r] == pivot, l++后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        //当 l == r 时，必须让 l++, r--，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr,l, right);
        }

    }
}
