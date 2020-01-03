package com.atguigu.datastructure.queue;

import java.util.Scanner;

public class CircleQueueDemo {

    public static void main(String[] args) {

        /*
        数组队列问题：
        1）数组使用一次就不能使用，不能重复利用
        2）优化：应用一个算法，改成一个环形队列（取模）

        环形队列思路：
        front：指向队列的第一个元素，即arr[front]就是队列的第一个元素，front的初始值为0
        rear：指向队列的最后一个元素的后一个位置，因为希望空出一个位置作为约定，rear的初始值为0
        (rear + 1) % maxSize = front  队列满
        rear == front  队列空
        队列的有效个数  (rear + maxSize - front) % maxSize   //rear = 1   front = 0
         */

        CircleQueue queue = new CircleQueue(4);  //设置为4，说明队列的有效数据最大为3

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):输入数据到队列");
            System.out.println("g(get):从队列输出数据");
            System.out.println("h(head):查看队列头");
            System.out.println("m(mount):显示队列的有效个数");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);  //接受一个字符

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数是: %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.showHead();
                        System.out.printf("队列头是: %d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'm':
                    int mount = queue.size();
                    System.out.printf("有效个数为: %d\n", mount);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("退出程序~~~");

    }
}


//创建队列类
class CircleQueue{
    private int maxSize;  //队列最大容量
    private int front;    //队列头
    private int rear;     //队列尾
    private int[] arr;

    //创建队列构造函数
    public CircleQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //输入数据到队列"
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满，无法添加数据~~~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //从队列输入数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，没有数据可取出~~~");
        }
        //front是指向队列的第一个元素，先把front对应的值保存到一个临时变量tmp中，
        //然后将front后移，考虑取模，降临时保存的变量返回
        int tmp = arr[front];
        front = (front + 1) % maxSize;
        return tmp;
    }



    //显示队列中的全部数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空~~~~");
            return;
        }
        //从front开始遍历，考虑数据的个数
        for (int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    //显示队列中数据的有效个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }


    //显示队列的头
    public int showHead(){
        if (isEmpty()){
            throw new RuntimeException("队列空~~~~");
        }
        return arr[front];
    }

}
