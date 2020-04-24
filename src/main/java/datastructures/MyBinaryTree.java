package datastructures;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:deng
 * @date: 2020/4/24
 * @time: 9:32 上午
 * @desc： 数据结构-二叉树
 */
public class MyBinaryTree {
    /**
     * 树节点
     */
    private static class TreeNode {
        Integer data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(Integer data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     *
     * @param inputList 输入链表
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        //移除链表首位元素做树的父节点
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            //递归创建子节点、先左节点后右节点
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历
     *
     * @param node 二叉树节点
     */
    public static void areOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        areOrderTraversal(node.leftChild);
        areOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 二叉树非递归前序遍历 压栈
     *
     * @param node 二叉树根节点
     */
    public static void preOrderTraversalWithStack(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = node;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历 队列
     *
     * @param node 二叉树根节点
     */
    public static void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        //父节点入队
        queue.offer(node);
        while (!queue.isEmpty()) {
            //父节点出队
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                System.out.println(treeNode.data == null ? "" : treeNode.data);
                //子节点入队
                if (treeNode.leftChild != null) {
                    queue.offer(treeNode.leftChild);
                }
                if (node.rightChild != null) {
                    queue.offer(treeNode.rightChild);
                }
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.
                asList(3, 2, 9, null, null, 10, null,
                        null, 8, null, 4));

        TreeNode binaryTree = createBinaryTree(inputList);
        System.out.println("二叉树前序遍历：");
        areOrderTraversal(binaryTree);
        System.out.println("二叉树中序遍历：");
        inOrderTraversal(binaryTree);
        System.out.println("二叉树后序遍历");
        postOrderTraversal(binaryTree);
        System.out.println("二叉树非递归前序遍历");
        preOrderTraversalWithStack(binaryTree);
        System.out.println("二叉树层序遍历");
        levelOrderTraversal(binaryTree);

    }
}
