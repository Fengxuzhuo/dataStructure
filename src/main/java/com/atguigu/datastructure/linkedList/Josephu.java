package com.atguigu.datastructure.linkedList;

public class Josephu {

    public static void main(String[] args) {

        //测试
        CircleSingleLinkedListDemo circleSingleLinkedListDemo = new CircleSingleLinkedListDemo();

        circleSingleLinkedListDemo.addBoy(5);

        circleSingleLinkedListDemo.showBoy();

        circleSingleLinkedListDemo.outOrder(1, 2, 5);


    }
}


//创建环形单向链表
class CircleSingleLinkedListDemo{

    //先创建第一个节点first
    private BoyNode first = null;

    //添加小孩节点,构建单向环形链表
    public void addBoy(int nums) {

        if (nums < 1) {
            System.out.println("数据有误");
            return;
        }

        //创建辅助节点curboy,帮助构建环形链表
        BoyNode curboy = null;

        //通过for循环来创建
        for (int i = 1; i <= nums; i++) {

            //根据编号创建小孩节点
            BoyNode boy = new BoyNode(i);

            if (i == 1) {
                first = boy;
                first.setNext(first);  //构成环
                curboy = first;   //让curboy指向第一个
            } else {
                curboy.setNext(boy);
                boy.setNext(first);
                curboy = boy;
            }
        }
    }


    //显示环形链表
    public void showBoy() {

        if (first == null) {
            System.out.println("聊表为空");
            return;
        }

        BoyNode curboy = first;

        while (true) {
            System.out.printf("小孩节点编号：%d\n", curboy.getNo());
            if (curboy.getNext() == first) {
                //说明已遍历完
                break;
            }

            curboy = curboy.getNext();
        }
    }




    /**
     * 根据用户输入计算出圈小孩节点顺序
     * @param startno   表示从第几个小孩开始报数
     * @param countnum  表示数几下
     * @param nums      表示最初有多少个小孩在圈中
     * @return
     */
    public void outOrder(int startno, int countnum, int nums) {

        //现队数据进行校验
        if (first == null || startno < 0 || startno > countnum) {
            System.out.println("输入的数据有误");
            return;
        }

        //创建辅助节点helper指向最后的那个节点。帮助完成小孩出圈
        BoyNode helper = first;
        while (true) {
            if (helper.getNext() == first) { //说明helper节点指向最后的那个节点
                break;
            }

            helper = helper.getNext();
        }

        //小孩报数前，先让first和helper移动 startno - 1
        for (int i = 1; i < startno - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first和helper指针同时移动 countnum - 1
        while (true) {
            //只有一个节点
            if (helper == first) {
                break;
            }

            //移动first和helper指针
            for (int i = 0; i < countnum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //此时，first节点指向的就是要出圈的小孩
            System.out.printf("小孩%d要出圈\n", first.getNo());

            //让该节点出圈
            first = first.getNext();
            helper.setNext(first);
        }

        //最后留在圈中的小孩
        System.out.printf("最后留在圈中的小孩编号:%d\n", first.getNo());

    }





}



//创建boy类，表示一个节点
class BoyNode{
    private int no;  //编号
    private BoyNode next;  //指向下一个节点，默认为null

    public BoyNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }
}
