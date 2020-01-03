package com.atguigu.tree;

import java.util.Arrays;

public class ArrBinaryTreeDemo {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        //创建一个ArrBinaryTree
        ArrBinaryTree binaryTree = new ArrBinaryTree(arr);

        //前序遍历
        binaryTree.preOrder();
        //中序遍历
        binaryTree.infixOrder();
        //后序遍历
        binaryTree.postOrder();

    }
}


//定义一个arrBinaryTree
class ArrBinaryTree{

    private int[] arr;  //存放数据节点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //重载遍历方法
    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }


    /**
     * 前序遍历
     * @param index  数组下标
     */
    public void preOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组空，无法遍历");
        }

        //输出当前这个元素
        System.out.println(arr[index]);

        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        //向右递归遍历
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }


    /**
     * 中序遍历
     * @param index
     */
    public void infixOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组空");
        }

        if (2 * index + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }

        System.out.println(arr[index]);

        if (2 * index + 2 < arr.length) {
            infixOrder(2 * index + 2);
        }

    }


    /**
     * 后序遍历
     * @param index
     */
    public void postOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("arr is null");
        }

        if (2 * index + 1 < arr.length) {
            postOrder(2 * index + 1);
        }

        if (2 * index + 2 < arr.length) {
            postOrder(2 * index + 2);
        }

        System.out.println(arr[index]);
    }
}
