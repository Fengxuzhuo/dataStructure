package com.atguigu.algorithm.searchalgorithm;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndex = " + resIndex);

        int[] array = {1, 8, 10, 89, 1000, 1000, 1234};
        List<Integer> indexList = binarySearch2(array, 0, arr.length - 1, 1000);
        System.out.println("indexList = " + indexList);
        List<Integer> resIndexList = binarySearch2(array, 0, arr.length - 1, 11);
        System.out.println("resIndexList = " + resIndexList);

    }


    /**
     * 二分查找(有序)
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return  找到要找的值，返回其对应的下标，若没有找到，返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        // 当 left > right 时，说明递归完整个数组没有找到，返回 -1
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (findVal > arr[mid]) {
            //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            //向左递归
            return binarySearch(arr, 0, mid - 1, findVal);
        } else {
            //找到返回对应下标
            return mid;
        }

    }


    /**
     * 二分查找数组中右多个相同值
     * 1.找到mid后先不要返回
     * 2.向 mid 索引左边扫面，将满足条件的所有元素对应的下标加入集合 list
     * 3.向 mid 索引右边扫面，将满足条件的所有元素对应的下标加入集合 list
     * 4.将 list 返回
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        //当left > right，说明没有找到，然会空集合
        if (left > right) {
            //利用size() 自动装箱
            return new ArrayList<>();
        }

        int mid = (left + right) / 2;

        if (findVal > arr[mid]) {
            //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {

            List<Integer> list = new ArrayList<Integer>();

            //向mid索引左边扫描，将所有满足条件的元素对应下标加入到 list 中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }

                list.add(temp);
                temp -= 1; //temp左移
            }

            list.add(mid);


            //向mid索引右边扫面
            temp = mid + 1;
            while (true) {
                if (temp > right || arr[temp] != findVal) {
                    break;
                }

                list.add(temp);
                temp += 1; //temp右移
            }

            return list;
        }
    }


}
