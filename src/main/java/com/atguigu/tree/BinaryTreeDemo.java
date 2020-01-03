package com.atguigu.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {

        //先创建一个二叉树
        BinaryTree tree = new BinaryTree();

        //创建节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node1 = new HeroNode(2, "吴用");
        HeroNode node2 = new HeroNode(3, "卢俊义");
        HeroNode node3 = new HeroNode(4, "林冲");
        HeroNode node4 = new HeroNode(5, "唐三");
        HeroNode node5 = new HeroNode(6, "里斯");
        HeroNode node6 = new HeroNode(7, "王五");
        HeroNode node7 = new HeroNode(8, "李四");

        //先手动创建二叉树，后面学习递归创建
        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);
        node3.setLeft(node5);
        node4.setLeft(node6);
        node4.setRight(node7);

        tree.setRoot(root);


        //前序遍历
        System.out.println("前序遍历");
        tree.preOrder();

        System.out.println("中序遍历");
        tree.infixOrder();

        System.out.println("后序遍历");
        tree.postOrder();


        //前序查找
        HeroNode node = tree.preOrderSearch(5);
        if (node != null) {
            System.out.printf("找到了，员工信息为 no = %d name = %s", node.getNo(), node.getName());
        } else {
            System.out.println("没有找到");
        }


    }
}

//定义二叉树
class BinaryTree {

    private HeroNode root;

    public void BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {

        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }

    }

    //中序遍历
    public void infixOrder() {

        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }

    }

    //后序遍历
    public void postOrder() {

        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }


    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }


    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除节点
    public void deleteNode(int no) {

        if (root != null) {
            //如果只有一个root节点，判断是否是要删除的节点，是则 root = null
            if (root.getNo() == no) {
                root = null;
            } else {
                //不是，递归删除该节点
                root.deleteNode(no);
            }
        } else {
            System.out.println("数为空，不能删除");
        }
    }



}


//先创建HeroNode节点
class HeroNode{

    private int no;
    private String name;
    private HeroNode left;  //左节点，默认为null
    private HeroNode right;  //右节点，默认为null

    //构造器
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    //前序遍历
    public void preOrder(){
        //输出当前节点
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }


    //前序查找
    public HeroNode preOrderSearch(int no) {

        if (this.no == no) {
            return this;
        }

        HeroNode resNode = null;
        if (this.left != null) {
            resNode =  this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            //说明找到
            return resNode;
        }

        if (this.right != null) {
            resNode =  this.right.preOrderSearch(no);
        }

        return resNode;
    }


    //中序查找
    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }

        return resNode;


    }


    //后序查找
    public HeroNode postOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }

        return resNode;
    }


    //删除节点
    public void deleteNode(int no) {

        if (this.left != null && this.left.getNo() == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.getNo() == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.deleteNode(no);
        }

        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }




}

