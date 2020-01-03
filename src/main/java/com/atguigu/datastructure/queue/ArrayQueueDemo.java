package com.atguigu.datastructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {


        /*
        队列是一个有序列表，可用数组或链表来实现， 先进先出原则

        数组模拟队列思路：
        队列本身是有序列表，用数组表示有以下几个参数
        maxSize: 该队列的最大容量
        front:队列前端的下表，会随着数据的输出而变化
        rear:队列后端的下表，会随着数据的输入二变化
        当我们将数据存入到队列中时称为"addQueue"
          1)将尾针往后移：rear+1, 当 front == rear, 队列空
          2)尾针 rear < maxSize - 1,可存入数据，rear == maxSize -1, 队列满，无法存入数据
         */


        //测试
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';  //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;  //为了控制循环

        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):输入数据到队列");
            System.out.println("g(get):从队列输出数据");
            System.out.println("h(head):查看队列头");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);  //接受一个字符

            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':    //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.showHead();
                        System.out.printf("队列的数据头是%d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("退出");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~~");
    }
}



//使用数据模拟队列 -- 创建一个队列类
class ArrayQueue {
    private int maxSize;  //队列最大容量
    private int front;  //队列头指针
    private int rear;   //队列尾指针
    private int[] arr;  //该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;  //指向队列头，分析出front指向队列头的前一个位置
        rear = -1;   //指向队列尾，指向队列尾的数据（即指向队列的最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        rear++; //rear后移
        arr[rear] = n;
    }

    //从队列中取出数据
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，没有数据可取出");
        }
        front++;
        return arr[front];
    }

    //显示队列中的全部数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空，没有数据可显示");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int showHead(){
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据~~~");
        }
        return arr[front+1];
    }
}

