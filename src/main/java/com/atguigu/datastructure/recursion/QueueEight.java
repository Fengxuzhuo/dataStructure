package com.atguigu.datastructure.recursion;

public class QueueEight {

    public static void main(String[] args) {

        /**
         * 八皇后问题（回溯算法）
         * 在8*8格的国际象棋上摆放8个皇后，使其不能相互攻击，即：任意两个皇后都不能出去同一行，
         * 同一列或同意斜线上，问有多少种摆法（92种）
         *
         * 思路分析：
         * 1.第一个皇后放在第一行第一列
         * 2.第二个皇后放在第二行第一列，判断是否OK，如果不OK，继续放在第二列，第三列，依次把
         * 所有列都放完，找到一个合适
         * 3.继续放第三个皇后，还是第一列，第二列...直到第8个皇后也能放在一个不冲突的位置，算
         * 是找到了一个正确解
         * 4.当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后放在第一列
         * 的所有正确解，全部得到
         * 5.然后回头继续第一个皇后放第二列，后面继续循环执行1，2，3，4步骤
         *
         * 说明：
         * 理论上应该创建一个二维数组来表示棋盘，但实际上可以通过算法，用一个一维数组即可解决
         * 问题。 arr[8] = {0, 4, 7, 5, 2, 6, 1, 3}
         * 对应arr下表表示第几行，即第几个皇后，arr[i] = val,val表示第i+1个皇后，放在i+1
         * 行的第val+1列
         *
         */


        //测试
        QueueEight queue = new QueueEight();

        queue.check(0);

        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("判断冲突的次数：%d次", judgeCount);


    }

    //定义一个max表示共有多少个皇后
    int max = 8;

    //定义一个数组，保存皇后防止后位置的结果
    int[] arr = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    //编写一个放置第n个皇后的方法
    //check是每一次递归时，进入到check都有  for(int i = 0; i < max; i++) 因此会有回溯
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n放到该行的第一列
            arr[n] = i;
            //判断当放置第n个皇后到第i列时是否冲突
            if (judge(n)) {
                //如果不冲突，接着放第n+1个皇后，即开始递归
                check(n + 1);
            }

            //如果冲突，就继续执行array[n] = i,即将第n个皇后放置在本行的后移一个位置
        }
    }


    /**
     * 查看当放置第n个皇后后，就去检查该皇后是否和前面已经摆放好的皇后冲突
     * @param n  表示第n个皇后
     * @return
     */
    private boolean judge(int n) {

        judgeCount++;
        for (int i = 0; i < n; i++) {
            //1.arr[i] = arr[n],表示 判断第n个皇后是否和前面的第n-1个皇后在同一列
            //2.Math.abs(n-i) == Math.abs(arr[n]-arr[i]) 判断第n个皇后是否和第i个皇后在同一斜线上

            //判断是否在同一行
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }

        return true;
    }


    /**
     * 输出皇后摆放的位置
     */
    private void print() {

        count++;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

}
