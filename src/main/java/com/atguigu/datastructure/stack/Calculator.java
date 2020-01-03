package com.atguigu.datastructure.stack;

import javax.swing.text.html.Option;

public class Calculator {

    public static void main(String[] args) {

        /**
         * 栈实现综合计算器（中缀表达式）
         *
         * 思路分析：
         * 1.通过一个index值（索引），来遍历我们的表达式
         * 2.如果发现是一个数字就直接入数栈
         * 3.如果发现是一个符号：
         *   发现当前的符号栈为空，直接入栈
         *   如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于
         * 栈中的操作符，就需要从数栈中pop出两个数，再从符号栈中pop出一个符号，
         * 进行运算，将得到的结果如数栈，然后将当前的操作符入符号栈，如果当前的
         * 操作符的优先级大于栈中的操作符，就直接入栈
         * 4.当表达式扫描完毕，就顺序的从数栈中和符号栈中pop出相应的数和符号，并
         * 运行
         * 5.最后在数栈中只有一个数，就是表达式的结果
         *
         *
         *
         *
         * 处理多位数：
         * 1.需要向expression的表达式的index后再看一位，如果是数就进行扫描，
         * 如果是符号才入栈
         * 2.定义一个变量 字符串，用于拼接
         *
         */

        //根据表达式完成运算
        String expression = "7*2*2-5+1-5+3-4";

        //创建两个栈，一个数栈，一个符号栈
        ArrStack numstack = new ArrStack(10);
        ArrStack operstack = new ArrStack(10);

        //创建需要的变量
        int index = 0;  //用于遍历
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  //每次扫描得到的char保存到ch中

        String keepnum = ""; //用于拼接多位数

        //while循环扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);

            //判断的到的ch是数字还是符号
            if (operstack.isOper(ch)) {
                //判断的到的字符是不是空字符
                if (!operstack.isEmpty()) {
                    //非空，进行比较
                    //如果当前操作符的优先级小于护着等于栈中的操作符，就从数栈中pop出两个数，从符号栈中pop出一个符号
                    //进行运算，将得到的结果入数栈，将当前的运算符入符号栈
                    if (operstack.priority(ch) <= operstack.priority(operstack.peek())) {
                        num1 = numstack.pop();
                        num2 = numstack.pop();
                        oper = operstack.pop();
                        res = numstack.cal(num1, num2, oper);

                        //把运算结果入栈
                        numstack.push(res);
                        operstack.push(ch);
                    } else {
                        operstack.push(ch);
                    }
                } else {
                    operstack.push(ch);
                }
            } else {
                //如果是数，直接入栈
                //numstack.push(ch - 48);

                //注意，如果是多位数，不能直接入栈
                //1.处理多位数时，需要向expression的表达式的index后再看一位，是数就进行扫描，是符号才入栈
                //2.定义一个变量 字符串， 用于拼接

                //处理多位数
                keepnum += ch;

                //如果ch已经是expression的最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numstack.push(Integer.parseInt(keepnum));
                } else {

                    //判断下一个字符是不是字符，如果是数字，就继续扫描，如果是运算符，则入栈
                    if (operstack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {

                        //如果后一位是运算符，则入栈，keepnum = "1" 或者 "123"
                        numstack.push(Integer.parseInt(keepnum));
                        //然后一定要将keepnum清空
                        keepnum = "";
                    }
                }
            }

            //让index+1，判断是否扫描到expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }

        }

        //当表达式扫描玩，就顺序的从数栈和符号栈中pop出数和运算符，进行运算
        while (true) {
            //如果符号栈为空，则计算得到最后得结果，数栈中只有一个数（结果）
            if (operstack.isEmpty()) {
                break;
            }

            num1 = numstack.pop();
            num2 = numstack.pop();
            oper = operstack.pop();
            res = numstack.cal(num1, num2, oper);

            numstack.push(res);

        }

        //将数栈中的数取出，就是计算结果
        int res2 = numstack.pop();
        System.out.printf("表达式%s = %d", expression, res2);


    }

}


//创建ArrStack栈
class ArrStack {
    private int maxSize;  //栈大小
    private int[] stack;  //存放数据
    private int top;      //栈顶

    public ArrStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //返回栈顶的值
    public int peek() {
        return stack[top];
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
            System.out.println("栈满~~");
            return;
        }

        top++;

        stack[top] = value;

    }


    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空~~~");
        }

        int value = stack[top];
        top--;
        return value;

    }

    //显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空~~~");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }


    //返回运算符的优先级，优先级由程序员自己确定，用数字表示
    //数字越大，优先级越高
    public int priority(int oper) {

        //假定目前的运算符只有+，-，*，/
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {

        return val == '=' || val == '-' || val == '*' || val == '/';
    }


    //计算方法
    public int cal(int num1, int num2, int oper) {

        int res = 0;  //用于存放计算结果

        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }

        return res;
    }









}
