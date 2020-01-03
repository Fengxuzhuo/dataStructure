package com.atguigu.tree;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {4, 6, 8, 5, 9};

        heapSort(arr);

        System.out.println("排序后数组 = " + Arrays.toString(arr));
    }


    /**
     * 堆排序方法
     * @param arr
     */
    public static void heapSort(int[] arr) {

        int temp = 0;
        //将数组（二叉树）构建成一个堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //将堆顶元素域末尾元素交换
        for (int j = arr.length - 1; j >= 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //重新调整，使其满足对定义，直到有序
            adjustHeap(arr, 0, j);
        }

    }


    /**
     * 将数组（二叉树）构建成一个堆
     * @param arr
     * @param i       表示非叶子节点在数组中的索引
     * @param length  表示对多少个元素继续调整，length是逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        //先取出当前元素的值，保存在一个临时变量中
        int temp = arr[i];

        //k=2*i+1  k表示 i 节点的左子节点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //说明当前节点的左子节点的值小于右子节点的值,让k指向右子节点
                k++;
            }

            //如果子节点大于父节点
            if (arr[k] > temp) {
                //把较大的值赋给当前节点
                arr[i] = arr[k];
                //i 指向 k,继续循环比较
                i = k;
            } else {
                break;
            }
        }

        //for循环结束时，我们已将i为父节点的树的最大值放在了顶端,将temp值放到调整后的位置
        arr[i] = temp;


    }


}
