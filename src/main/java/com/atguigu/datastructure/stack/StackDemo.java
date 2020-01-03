package com.atguigu.datastructure.stack;

import java.util.Scanner;

public class StackDemo {

    public static void main(String[] args) {

        /**
         * 对计算机而言，他接受到的就是一个字符串
         * stack
         * 1.先入后出的有序列表
         * 2.只能在线性表的一端插入或删除，允许操作的一端，称为Top.另一端为Bottom
         * 3.根据定义，最先放入的在栈底，最后放入的在栈顶，删除刚好相反
         * 4.出栈（pop）和入栈（push）
         *
         * 栈的应用：
         * 1.处理递归调用：将下个指令的地址存储在堆栈中，还有参数，区域变量等数据
         * 也存如堆栈中
         * 2.表达式的转化（中缀表达式转后缀表达式）与求值（实际解决）
         * 3.二叉树的遍历
         * 4.图形的深度优先搜索法
         *
         * 栈的快速入门（用数组）
         * 思路分析：
         * 1.定义一个top来表示栈顶，初始化为-1
         * 2.入栈的操作，当有数据加入栈中时，top++，stack[top] = data
         * 3.出栈的操作， int value = stack[top]; top--; return value
         *
         */

        //测试
        //创建ArrayStack对象
        ArrayStack stack = new ArrayStack(4);

        String key = "";
        boolean loop = true;  //控制是否退出循环
        Scanner scanner = new Scanner(System.in);

        while (loop) {

            System.out.println("exit: 退出");
            System.out.println("list: 显示");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("请输入数据：");
            key = scanner.next();

            switch (key) {
                case "list":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("要出栈的元素：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("退出~~~~");

    }
}


//定义一个ArrayStack表示栈
class ArrayStack {

    private int maxSize;  //栈的大小
    private int[] stack;  //数据存放在该数组中
    private int top = -1;      //栈顶

    //construstor
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法添加~~~");
            return;
        }

        top++;

        stack[top] = value;
    }

    //出栈,将栈顶元素返回
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~~");
        }

        int value = stack[top];
        top--;

        return value;

    }

    //显示（遍历）需要从栈顶开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空~~~");
            return;
        }

        //遍历
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }

    }



}