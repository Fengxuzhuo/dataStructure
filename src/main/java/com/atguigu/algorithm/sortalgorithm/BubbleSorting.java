package com.atguigu.algorithm.sortalgorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSorting {

    public static void main(String[] args) {

        /**
         * 冒泡排序
         *
         * 1.一共进行了 arr.length - 1 轮循环
         * 2.每一轮的次数在减少
         * 3.如果我们发现某轮排序没有发生一次数据交换，可提前结束冒泡排序（优化）
         */

        //bubble sorting
        //将5个无序的数：3， 9， -1， 10， -2 使用冒泡排序将其排成一个从小到大的有序数列

        int arr[] = {3, 9, -1, 10, -2};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        /*
        //测试80000个数据排序时间
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        System.out.println("排序开始时间");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date1));
        */

        bubbleSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));

        /*
        System.out.println("排序结束时间");
        Date date2 = new Date();
        System.out.println(simpleDateFormat.format(date2));
        */

    }


    //将冒泡排序封装为一个方法
    public static void bubbleSort(int[] arr) {

        int temp = 0;   //临时变量
        boolean flag = false;  // 标记数据是否进行过交换

        //冒泡排序的 时间复杂度为 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            //System.out.println("第" + (i+1) + "轮的排序后的数组为：");
            //System.out.println(Arrays.toString(arr));

            if (!flag) {
                break;
            } else {
                flag = false;  //重置flag，进行下次判断
            }
        }

    }


}
