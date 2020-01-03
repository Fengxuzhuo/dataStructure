package com.atguigu.algorithm.sortalgorithm;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        shellSort(arr);

        shellSort2(arr);

    }


    /**
     * 希尔排序（交换法）
     * @param arr
     */
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0; //记录排序轮数
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组元素，步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }

            System.out.println("第" + (++count) + "轮排序后为");
            System.out.println(Arrays.toString(arr));
        }


        /*
        //第一轮,将10个数分为5组
        for (int i = 5; i < arr.length; i++) {
            //遍历各组元素，每组有2个元素，步长5
            for (int j = i - 5; j >= 0; j -= 5) {

                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("第一轮排序后为");
        System.out.println(Arrays.toString(arr));

        //第二轮，将十个数据分成 5/2 = 2组
        for (int i = 2; i < arr.length; i++) {
            //遍历各组元素，每组有2个元素，步长5
            for (int j = i - 2; j >= 0; j -= 2) {

                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("第二轮排序后为");
        System.out.println(Arrays.toString(arr));

        //第三轮，将10个数分成 2 / 2 = 1组
        for (int i = 1; i < arr.length; i++) {
            //遍历各组元素，每组有2个元素，步长5
            for (int j = i - 1; j >= 0; j -= 1) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("第三轮排序后为");
        System.out.println(Arrays.toString(arr));
        */
    }


    /**
     * 对交换式希尔排序的优化  -->  移动式
     * @param arr
     */
    public static void shellSort2(int[] arr) {

        //增量gap,并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            //从第gap个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp <= arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当推出while循环时，说明找到插入的位置
                    arr[j] = temp;
                }
            }
        }

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

}


