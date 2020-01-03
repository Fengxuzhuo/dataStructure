package com.atguigu.datastructure.hashTable;

import java.util.Scanner;

public class HashTable {

    public static void main(String[] args) {

        HashTab hash = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add: 添加员工");
            System.out.println("find: 查找员工");
            System.out.println("delete: 删除员工");
            System.out.println("list: 显示员工");
            System.out.println("exit: 退出系统");

            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("请输入员工id");
                    int id = scanner.nextInt();
                    System.out.println("请输入员工姓名");
                    String name = scanner.next();
                    //创建员工
                    Emp emp = new Emp(id, name);
                    hash.add(emp);
                    break;
                case "find":
                    System.out.println("请输入员工id");
                    id = scanner.nextInt();
                    hash.find(id);
                    break;
                case "delete":
                    System.out.println("请输入员工id");
                    id = scanner.nextInt();
                    hash.delete(id);
                    break;
                case "list":
                    hash.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

//创建哈希表
class HashTab {

    EmpLinkedList[] empLinkedLists;
    private int size;  //表示又多少条链表

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化empLinkedList
        empLinkedLists = new EmpLinkedList[size];
        //不要分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加员工
    public void add(Emp emp) {
        //根据员工id得到员工在那个链表
        int empLinkedListNo = hashFun(emp.id);

        //将emp添加到对应的链表中
        empLinkedLists[empLinkedListNo].add(emp);

    }

    //遍历所有链表，遍历hash,显示员工信息
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }


    //查找员工
    public void find(int id) {
        //使用散列函数确定在那条链表里
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNo].find(id);

        if (emp != null) {
            System.out.printf("在第%d条链表中找到员工id = %d\n", (empLinkedListNo + 1), id);
        } else {
            System.out.println("没有找到该员工");
        }
    }

    //删除员工
    public void delete(int id) {
        int empLinkedListNo = hashFun(id);

        Emp emp = empLinkedLists[empLinkedListNo].delete(id);

        if (emp != null) {
            System.out.printf("在第%d条链表中找到员工id = %d\n", (empLinkedListNo + 1), id);

        } else {
            System.out.println("没有找到要删除的员工");
        }
    }


    //哈希函数
    public int hashFun(int id) {
        return id % size;
    }
}


//员工信息类
class Emp{

    public int id;
    public String name;
    public Emp next;   //默认为null

    //构造器
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


//创建链表 EmpLinkedList
class EmpLinkedList{

    public Emp head; //默认null

    //添加员工到链表
    //添加员工是，id自增长（从小到大），因此将员工直接加入到本链表的最后
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        //如果不是第一个使用一个辅助指针，找到最后的指针
        Emp curHead = head;
        while (true) {
            if (curHead.next == null) {
                //说明到最后，退出
                break;
            }

            //后移curHead
            curHead = curHead.next;
        }

        //退出循环时，将emp直接加入链表
        curHead.next = emp;
    }

    //显示员工信息（根据链表编号 no）
    public void list(int no) {

        if (head == null) {
            System.out.println("第" + (no+1) + "条链表为空");
            return;
        }

        System.out.print("第" + (no+1) + "条链表信息为：");
        Emp curHead = head;
        while (true) {
            System.out.printf("员工信息：id = %d name = %s", curHead.id, curHead.name);

            if (curHead.next == null) {
                break;
            }
            //后移，遍历
            curHead = curHead.next;
        }

        System.out.println();

    }

    //查找员工(根据员工id),找到返回emp,没有找到返回null
    public Emp find(int id) {

        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        Emp curHead = head;
        while (true) {
            if (curHead.id == id) {
                break;
            }

            if (curHead.next == null) {
                //说明没有找到
                curHead = null;
                break;
            }

            curHead = curHead.next;
        }

        return curHead;
    }


    //删除员工（根据员工id）
    public Emp delete(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        Emp curHead = head;
        while (true) {
            if (curHead.id == id) {
                break;
            }
        }

        return curHead;
    }
}




