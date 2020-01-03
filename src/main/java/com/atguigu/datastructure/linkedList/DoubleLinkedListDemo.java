package com.atguigu.datastructure.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        HeroNode2 newHeroNode = new HeroNode2(3, "吴勇", "智多星~~");
        doubleLinkedList.updateNode(newHeroNode);

        doubleLinkedList.deleteNode(2);

        doubleLinkedList.list();
    }
}



//定义一个双向链表类
class DoubleLinkedList{

    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回
    public HeroNode2 getHead() {
        return head;
    }


    //从双向链表中删除一个节点
    //1)对于双向链表，直接找到要删除的这个节点
    //2）找到后直接删除，则 temp.pre.next = temp.next且 temp.next.pre = temp.pre
    public void deleteNode(int no) {

        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) { //已经到链表的最后
                break;
            }

            if (temp.no == no) {
                //找到待删除节点的前一个节点
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            //如果是最后一个节点就不需要执行下面这句话，否则空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            } else {
                System.out.printf("要删除的节点编号%d不存在\n", no);
            }
        }

    }


    //修改双向链表中的某个节点
    public void updateNode(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }

        //根据no编号找到要修改的节点
        HeroNode2 temp = head.next;
        boolean flag = false;  //标识是否找到

        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }

            if (temp.no == newHeroNode.no) {
                //已经找到
                flag = true;
                break;
            }

            temp = temp.next;
        }

        //判断flag
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到要修改节点的编号%d,不能修改\n", newHeroNode.no);
        }
    }



    //添加一个节点到双向链表的最后
    //1）先找到双向链表的最后的节点
    //2）让temp.next 指向 新节点newHeroNode,同时newHeroNode.pre指向 temp
    public void add(HeroNode2 heroNode) {
        //因为头节点不能动，辅助变量
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }

            //如果没有找到最后，将temp后移
            temp = temp.next;

        }

        //当退出循环时，temp就指向了链表的最后，形成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;

    }




    //遍历双向链表
    //显示链表
    public void list() {
        //判断链表是否空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }

}




//定义HeroNode2,每个HeroNode对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;  //指向下一个节点，默认为null
    public HeroNode2 pre;   //指向前一个节点，默认为null

    //构造方法
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
