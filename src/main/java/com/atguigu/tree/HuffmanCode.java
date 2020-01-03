package com.atguigu.tree;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {

        String contents = "i like like like java do you like a java";
        //获取contents的字节数组
        byte[] bytes = contents.getBytes();

        List<HuffmanNode> nodes = getNodes(bytes);

        HuffmanNode huffmanTreeRoot = createHuffmanTree(nodes);

        huffmanTreeRoot.preOrder();


    }


    /**
     * 存放node节点到list中
     * @param bytes  接受字节数组
     * @return       返回List
     */
    public static List<HuffmanNode> getNodes(byte[] bytes) {

        //创建list
        ArrayList<HuffmanNode> huffmanLists = new ArrayList<>();

        //遍历bytes，统计每一个byte出现的次数，--> map[key, value]
        Map<Byte, Integer> counts = new HashMap<>();
        for (Byte b : bytes) {
            //尝试从map中获取字符b
            Integer count = counts.get(b);
            if (count == null) {
                //map还没有这个字符数据，放入，第一次
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //把每一个键值对转换成node节点，并加入到huffmanLists中
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            huffmanLists.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        return huffmanLists;

    }


    /**
     * 通过list创建赫夫曼树
     * @param nodes
     * @return
     */
    public static HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {

        while (nodes.size() > 1) {

            Collections.sort(nodes);

            HuffmanNode leftNode = nodes.get(0);
            HuffmanNode rightNode = nodes.get(1);

            HuffmanNode parent = new HuffmanNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);

        }

        return nodes.get(0);


    }



}


class HuffmanNode implements Comparable<HuffmanNode>{

    Byte data;
    int weight;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        //从小到大
        return this.weight - o.weight;
    }


    public void preOrder() {

        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }



}
