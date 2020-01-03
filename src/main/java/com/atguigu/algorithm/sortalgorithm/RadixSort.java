package com.atguigu.algorithm.sortalgorithm;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {

        int[] arr = {53, 3, 542, 748, 14, 214};

        radixSort(arr);



    }


    public static void radixSort(int[] arr) {

        //假设第一个数就是最大的
        int max = arr[0];

        //获取数组中最大数的位数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //得到最大数位数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组表示10个桶，每个桶就是一个一位数组
        //1.二维数组包含10个一维数组
        //2.为了防止在放入数据是溢出，每个桶的大小设为 arr.length
        //3.基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际放的数据个数，定义一个一维数组来记录每个桶每次放入数据的个数
        //bucketElementCounts[0] 记录的使bucket[0]中有效元素的个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {

                //取出每个元素对应的值
                int digitOfElement = arr[j] / n % 10;

                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
            int index = 0;
            //遍历每一个桶，并将取出的数据放入原来的数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放入原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr中
                        arr[index++] = bucket[k][l];
                    }
                }

                //第（i+1）轮结束后，需要使每个bucketElementCounts[k] = 0;
                bucketElementCounts[k] = 0;

            }

            System.out.println("第"+(i+1)+"轮排序后" + Arrays.toString(arr));
        }




        /*
        //第一轮，针对每个数的个位数进行比较
        for (int i = 0; i < arr.length; i++) {

            //取出每个元素的个位数的值
            int digitOfElement = arr[i]/1%10;
            //放入到对应的桶中

            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
        int index = 0;
        //遍历每一个桶，并将取出的数据放入原来的数组中
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中有数据，才放入原数组
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第k个桶
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到arr中
                    arr[index++] = bucket[k][l];
                    System.out.println(arr[index++]);
                }
            }

            //第一轮结束，需要使每个bucketElementCounts[k] = 0;
            bucketElementCounts[k] = 0;

        }

        System.out.println("第一轮排序后" + Arrays.toString(arr));


        //第二轮，针对每个数的十位数进行比较
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 10 % 10;

            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        index = 0;

        for (int k = 0; k < bucketElementCounts.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    arr[index++] = bucket[k][l];
                }
            }
            bucketElementCounts[k] = 0;
        }

        System.out.println("第二轮排序" + Arrays.toString(arr));

        */

    }

}
