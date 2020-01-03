package com.atguigu.algorithm.searchalgorithm;

public class SeqSearch {

    public static void main(String[] args) {

        int[] arr = {1, 9, 11, -1, 34, 89};

        int index = seqSearch(arr, -11);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("要找的元素对应下标位：" + index);
        }
    }


    /**
     * 线性查找
     * 找到一个满足的值，返回对应下标，若找不到，返回-1
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
