package com.atguigu.tree;

public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {

        ThreadedHeroNode root = new ThreadedHeroNode(1, "tom");
        ThreadedHeroNode node1 = new ThreadedHeroNode(3, "joke");
        ThreadedHeroNode node2 = new ThreadedHeroNode(6, "tim");
        ThreadedHeroNode node3 = new ThreadedHeroNode(8, "smith");
        ThreadedHeroNode node4 = new ThreadedHeroNode(10, "lisi");
        ThreadedHeroNode node5 = new ThreadedHeroNode(14, "wangwu");

        //手动创建二叉树
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);

        //后序，在创建二叉树的时候，需要将parent进行保存
        node1.setParent(root);
        node2.setParent(root);
        node3.setParent(node1);
        node4.setParent(node1);
        node5.setParent(node2);


        //测试中序线索二叉树
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        //threadedBinaryTree.threadedNodes();
        //threadedBinaryTree.preThreadedNodes();
        threadedBinaryTree.postThreadedNodes();


        //以10号测试
        ThreadedHeroNode leftNode = node4.getLeft();
        System.out.println("前驱节点是：" + leftNode);
        ThreadedHeroNode rightNode = node4.getRight();
        System.out.println("后继节点是：" + rightNode);


        //测试遍历线索二叉树
        //System.out.println("前序线索化二叉树遍历");
        //threadedBinaryTree.preList();//1 3 8 10 6 14
        //System.out.println("中序线索化二叉树遍历");
        //threadedBinaryTree.infixList(); //8 3 10 1 14 6


        System.out.println("后序线索化二叉树遍历");
        threadedBinaryTree.postList();//8 10 3 14 6 1

    }
}


//创建线索化二叉树
class ThreadedBinaryTree {

    private ThreadedHeroNode root;
    //为了实现线索化，需要创建指向当前节点的前驱节点指针pre
    private ThreadedHeroNode pre;


    public void setRoot(ThreadedHeroNode root) {
        this.root = root;
    }

    //重载threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    public void preThreadedNodes() {
        this.preThreadedNodes(root);
    }

    public void postThreadedNodes() {
        this.postThreadedNodes(root);
    }

    //前序遍历线索化二叉树
    public void preList() {

        ThreadedHeroNode node = root;

        while (node != null) {

            while (node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }

            System.out.println(node);
            node = node.getRight();
        }

    }


    //中序遍历线索化二叉树
    public void infixList() {

        ThreadedHeroNode node = root;

        while (node != null) {

            //循环遍历找到leftType == 1的节点，
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            //输出该节点
            System.out.println(node);

            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getLeftType() == 1) {
                //获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }

            //循环完，替换这个遍历的节点
            node = node.getRight();
        }
    }


    /**
     * 后序线索化二叉树遍历
     * 后序遍历的时候需要在建立二叉树的时候，将节点的parent进行赋值，否则不能遍历
     */
    public void postList() {

        ThreadedHeroNode node = root;

        while (node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }

        while (node != null) {

            //右节点是线索
            if (node.getRightType() == 1) {
                System.out.println(node);
                pre = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == pre) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }
                    pre = node;
                    node = node.getParent();
                } else {
                    //如果从左节点进入则找到右子树的最左节点
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }



    //前序线索化二叉树
    public void preThreadedNodes(ThreadedHeroNode node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        if (node.getLeftType() != 1) {
            preThreadedNodes(node.getLeft());
        }

        if (node.getRightType() != 1) {
            preThreadedNodes(node.getRight());
        }

    }

    /**
     * 编写中序线索二叉树的方法
     * @param node
     */
    public void threadedNodes(ThreadedHeroNode node) {

        //node == null 不能索引化，直接返回
        if (node == null) {
            return;
        }

        //先线索化左子树
        threadedNodes(node.getLeft());
        //线索化当前节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());


    }

    //后序线索化二叉树
    public void postThreadedNodes(ThreadedHeroNode node) {

        if (node == null) {
            return;
        }

        threadedNodes(node.getLeft());

        threadedNodes(node.getRight());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;
    }


}



//创建HeroNode节点
class ThreadedHeroNode {

    private int id;
    private String name;
    private ThreadedHeroNode left;
    private ThreadedHeroNode right;

    private ThreadedHeroNode parent; //父节点指针，为了后序遍历线索二叉树

    //leftType == 0 表示指向左子树，1 表示指向前驱节点
    //rightType == 0 表示指向右子树，1 表示指向后继节点
    private int leftType;
    private int rightType;

    public ThreadedHeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThreadedHeroNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedHeroNode left) {
        this.left = left;
    }

    public ThreadedHeroNode getRight() {
        return right;
    }

    public void setRight(ThreadedHeroNode right) {
        this.right = right;
    }


    public ThreadedHeroNode getParent() {
        return parent;
    }

    public void setParent(ThreadedHeroNode parent) {
        this.parent = parent;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "ThreadedHeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}