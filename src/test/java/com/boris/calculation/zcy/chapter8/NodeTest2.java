package com.boris.calculation.zcy.chapter8;

import com.boris.calculation.util.JsonUtil;
import com.boris.calculation.zcy.chapter7.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Description: 给定一棵二叉树的头节点head，判断这棵二叉树是不是完全二叉树
 * <p>
 * 完全二叉树：左右子树在形成满二叉树的趋势中
 * 1. 任意一个node只有右节点没有左节点一定是不是完全二叉树
 * 2. 任意一个node只有左节点没有右节点，以层序遍历的顺序，
 * 之后的节点只能是叶子节点，该二叉树才能是完全二叉树
 *
 * @author boris
 * @date Created on 2021/6/1
 */
public class NodeTest2 {
    Node node;

    @Test
    public void test() {
        System.out.println(isCompleteBinaryTree(node));
    }


    /**
     * @param a:1
     * @param b:2
     * @description: test01
     * @return: int
     * @date: 2021/7/14
     * @auther: boris
     */
    public int test01(int a, String b) {
        return 0;
    }

    public boolean isCompleteBinaryTree(Node head) {
        if (head == null) {
            return true;
        }

        new HashMap<>();

        boolean haveRight = true;
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(head);

        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            if (curNode.right != null && curNode.left == null) {
                return false;
            }

            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
            }

            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
            }

            if (!haveRight && (curNode.left != null || curNode.right != null)) {
                return false;
            }

            if (curNode.left != null && curNode.right == null) {
                haveRight = false;
            }
        }
        return true;
    }

    @Before
    public void init() {
        node = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;

        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node3.left = node6;
        node3.right = node7;

        node.left = node2;
        node.right = node3;

        System.out.println(JsonUtil.toString(node));
    }
}
