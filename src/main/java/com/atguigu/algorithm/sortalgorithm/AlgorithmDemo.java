package com.atguigu.algorithm.sortalgorithm;


import java.util.*;

public class AlgorithmDemo {

    public static void main(String[] args) {

        String contents = "";
        byte[] bytes = contents.getBytes();

    }


    public static List<Node> getNodes(byte[] bytes) {

        List<Node> list = new ArrayList<>();

        Map<Byte, Integer> counts = new HashMap<>();

        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }


        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }

        return list;
    }


    public static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {

            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);

        }

        return nodes.get(0);
    }


}


class Node implements Comparable<Node> {

    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }


}

