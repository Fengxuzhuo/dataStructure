package com.atguigu.datastructure.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        /*
        带头节点的单链表
        应用：实现排行榜管理完成对数据（英雄人物）的增删改查
        操作（可以考虑带学员单独完成，也可以带学员完成）

        第一种方法在添加英雄时，直接添加到链表的尾部(不考录排序）
        思路：
        添加（创建）HeroNode
        1）先创建一个head头节点（不存放具体数据，作用就是表示单链表的
        头），作用就是表示单链表的头
        2）后面我们每添加一个节点，就直接加入到链表的最后
        遍历
        通过一个辅助变量遍历，帮助遍历整个链表



        第二种方法在添加英雄时，根据排名将英雄插入指定位置（如果有这个排名，则添加失败）
        需要按编号的顺序添加
        1）首先找到新添加的节点的位置，通过辅助变量，通过遍历来搞定
        2）新的节点的.next = temp.next
        3）将temp.next = 新的节点


        */


        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList list = new SingleLinkedList();

        /*//添加节点到链表中
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
*/
        //按照编号添加节点到链表中
        list.addByOrder(hero2);
        list.addByOrder(hero4);
        list.addByOrder(hero1);
        list.addByOrder(hero3);

        //显示
        list.list();


        //修改节点信息
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟！！");
        list.update(newHeroNode);

        list.delete(1);
        list.delete(3);

        //显示
        System.out.println("修改后的信息为~~~~");
        list.list();

        //测试查找链表的节点的有效个数
        System.out.println("有效节点个数为：" + getLength(list.getHead()));


        /*
        栈的基本使用：先进后出原则
         */
        Stack<String> stack = new Stack();

        //入栈
        stack.add("tom");
        stack.add("jack");
        stack.add("rose");

        //出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }


    }




    /**
     * 4.从尾到头打印单链表（要求方式1：反向遍历； 方式2：stack栈）
     * 1).方式一：将链表反转，然后遍历即可，这样会破坏原链表的结构，不建议
     * 2).方式二：利用栈这个数据结构，将各个节点压入到栈中，利用栈的先进后出原则
     * @param head
     */
    public static void printLinkedList(HeroNode head) {

        if (head.next == null) {
            return;
        }

        HeroNode temp = head.next;
        Stack<HeroNode> stack = new Stack<>();

        //将链表中的节点全部压入栈中
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        //将节点从栈中压出
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }


    }


    /**
     * 3.单链表的反转
     * 1).定义一个辅助变量temp，当前节点的下一个节点next，以及一个新节点reverseHead = new HeroHead()
     * 2).从头遍历原来的链表，每遍历一个节点，就将其取出，并放在新链表的最前端，将temp连接到新的链表上
     * 3).将原来链表的 head.next 指向 reverseHead.next 实现链表的反转
      * @param head
     */
    public static void reverseLinkedList(HeroNode head) {

        //若链表为空或只有一个节点，直接返回
        if (head.next == null && head.next.next == null) {
            return;
        }

        HeroNode temp = head.next;
        HeroNode next = null; //指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");

        while (temp != null) {
            temp = temp.next;   //当前节点的下一个节点
            temp.next = reverseHead.next;  //将当前节点的下一个节点放在新链表的最前端
            reverseHead.next = temp;  //将temp连接到新的链表上
        }

        //将head.next 指向 reverseHead.next 实现链表的反转
        head.next = reverseHead.next;


    }


    /**
     * 2.查找单链表中的第k个节点
     * 1).编写一个方法，接受head节点和index节点
     * 2).先把链表从头到尾遍历，得到链表的长度size
     * 3).得到size后，再从链表的第一个开始遍历（size - index）个，就可以得到，找到了就返回该节点，否则返回null
     * @param head  头节点
     * @param index  倒是第index个节点
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断链表是否位空
        if (head.next == null) {
            return null;
        }

        //遍历获取链表的长度
        int size = getLength(head);
        //遍历到size - index位置，就是我们要找的节点
        //先做一个index校验
        if (index <= 0 || index > size) {
            return null;
        }

        //辅助变量，for循环定位到倒数的index
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }

        return temp;
    }


    /**
     * 1.求单链表中节点的有效个数（如果是带头节点的链表，不统计头节点）
     * @param head   链表的头节点
     * @return
     */
    public static int getLength(HeroNode head) {
        //判断链表是否为空
        if (head.next == null) {
            return 0;
        }

        int length = 0;
        //定义一个辅助变量，不统计头节点
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        return length;
    }
}


//定义SingleLinkedList单链表  管理我们的英雄
class SingleLinkedList{

    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单项链表
    /*
    思路：当不考虑编号顺序时
    1）找到当前链表的最后节点
    2）将这个最后节点的 next 指向 新的节点
     */
    public void add(HeroNode heroNode){
        //应为head节点不能动，因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }

        //当退出循环时，temp就指向了链表的最后，将最后这个节点的next 指向新的节点
        temp.next = heroNode;

    }

    //第二种方法添加英雄
    //根据排名将英雄插入指定位置（如果有这个排名，则添加失败）
    //需要按编号的顺序添加
    public void addByOrder(HeroNode heroNode){
        //头节点不能动，需要通过辅助变量遍历来找到添加的位置
        //单链表，因为我们找到的temp是位于添加位置的前一个节点，负责插入不了
        HeroNode temp = head;
        boolean flag = false;  //flag标识添加的节点编号是否存在，默认为false

        while (true) {
            if (temp.next == null) {  //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) { //说明需要添加的节点的编号已经存在
                flag = true;  //说明编号已经存在
                break;
            }
            //temp后移，遍历当前链表
            temp = temp.next;

        }
        //判断flag的值
        if (flag) { //不能添加，说明编号已经存在
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    //修改节点的信息，根据no编号修改，即no编号不能改变

    //根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否空
        if (head.next == null) {
            System.out.println("链表位空~~~");
            return;
        }
        //根据no找到需要修改的节点
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; //标识是否找到节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            //将temp后移
            temp = temp.next;

        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }


    //删除节点
    /*
    思路：1）head不能动，需要一个temp辅助变量来找到待删除节点的前一个节点
         2）说明在比较时，是 temp.next.no 和 需要删除的节点 no 来比较
     */
    public void delete(int no) {
        //辅助变量
        HeroNode temp = head;
        boolean flag = false;  //标识是否找到要删除的节点

        while (true) {
            if (temp.next == null) {
                break; //标识已经在链表的最后
            }

            if (temp.next.no == no) {
                //找到待删除的节点
                flag = true;
                break;
            }

            temp = temp.next;  //后移， 遍历

        }
        if (flag) {//找到，可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的节点%d不存在\n", no);
        }

    }





    //显示链表（遍历）
    public void list(){
        //判断链表是否空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //通过辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否链表到最后
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //该temp后移,一定，否则死循环
            temp = temp.next;
        }
    }
}

//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;  //指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方法，我们重写toString()方法
    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no
                + ", name='" + name + '\''
                + ", nickname='" + nickname + '\''
                + '}';
    }

}