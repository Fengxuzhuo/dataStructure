package com.atguigu.algorithm.searchalgorithm;

public class SearchAlgorithm {

    /**
     *
     * 查找算法
     *
     * 1.线性查找
     * 2.二分查找（有序序列）
     * 2.1 确定该数组中间的下标
     *     int mid = (left + right) / 2
     * 2.2 让需要查找的数findVal 与 arr[mid] 比较
     *     findVal > arr[mid] 向右递归查找，反之向左递归查找
     *     findVal = arr[mid] 找到，返回
     * 2.3 当找到对应值或 left > right 时结束
     *
     *
     * 3.插值查找
     * 数据量比较大，且分布比较均匀的情况下使用
     * 类似二分查找，不同的是每次自适应从mid处开始查找
     * 插值索引：int mid = left - (right - left)*(findVal - arr[left])/(arr[right] - arr[left])
     *
     *
     * 4.斐波拉契查找
     *
     *
     *
     *
     *
     */
}
