package com.atguigu.tree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {

    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};

        Node root = huffmanTree(arr);

        root.preOrder();


    }

    /**
     * 前序遍历
     * @param root 赫夫曼树根节点
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("huffmanTree is null");
        }
    }


    /**
     * 创建赫夫曼数方法
     * @param arr
     * @return
     */
    public static Node huffmanTree(int[] arr) {

        //为了操作方便，遍历arr数组，将arr的每个元素称为一个node,存在ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();

        for (int value : arr) {
            nodes.add(new Node(value));
        }

        //重复一下步骤直到结合中剩一个节点，
        while (nodes.size() > 1) {
            //从小到大进行排序
            Collections.sort(nodes);

            //从排序后的集合中取出最小的两个值
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //构成一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //将取出两个值从集合ArrayList中删除，并将parent加入
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

        }

        //返回赫夫曼树的root节点
        return nodes.get(0);
    }
}


//创建node对象，为了支持Collections集合排序，让node实现Comparable接口
class Node implements Comparable<Node> {

    int value;  //节点的权
    Node left;  //左子节点
    Node right; //右子节点

    /**
     * 前序遍历
     */
    public void preOrder() {

        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //constructor
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序，-（this.value-o.value）表示从大到小
        return this.value - o.value;
    }
}
