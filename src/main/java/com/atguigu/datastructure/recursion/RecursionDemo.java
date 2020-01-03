package com.atguigu.datastructure.recursion;

public class RecursionDemo {

    public static void main(String[] args) {

        /**
         * 递归（recursion）
         * 递归就是方法自己调用自己，每次调用时传入不同得变量
         *
         *
         * 递归调用机制
         * 1.打印问题
         * 2.阶乘问题
         *
         * 递归遵循规则：
         * 1.当程序运行到一个方法时，就会在栈中开辟一个独立的空间
         * 2.每个空间得数据（局部变量）是独立的
         * 3.如果方法中使用的是引用类型变量（如数组），就会共享该引用类型的数据
         * 4.递归必须向退出递归的条件逼近，否则就无限递归，出现StackOverFlowError
         * 5.当一个方法执行完或者遇到return，就返回。遵守谁调用就将结果返回给谁，
         * 同时当方法执行完毕或者返回时，该方法也就执行完毕
         *
         * 递归解决实际问题
         * 1.各种数学问题：8皇后问题，汉诺塔，阶乘问题，迷宫问题，球和蓝子得问题
         * 2.各种算法中：快排，归并排序，二分查找，分治算法
         * 3.将用栈解决的问题  --> 递归代码比较简洁
         *
         */

        //通过打印问题，回顾调用机制
        //print(4);

        int res = factorial(3);
        System.out.println("res=" + res);


    }


    //打印问题
    public static void print(int n) {
        if (n > 2) {
            print(n - 1);
        } else {
            System.out.println("n=" + n);
        }
    }


    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
