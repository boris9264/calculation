package com.boris.calculation.zcy.chapter7;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * Description:
 * 二叉树遍历
 * 先序: 头左右
 * 中序: 左头右
 * 后序: 左右头
 *
 * @author boris
 * @date Created on 2021/5/26
 */
public class NodeTest1 {
    Node node;

    //递归遍历
    @Test
    public void run() {
        preOut(node);
        middleOut(node);
        lastOut(node);
    }

    //不使用递归遍历
    @Test
    public void test() {
//        preOut1(node);
//        middleOut1(node);
        lastOut2(node);
    }

    public void lastOut2(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (!nodeStack.isEmpty() || node != null) {
            Node curNode = nodeStack.peek();

        }
    }

    public void middleOut1(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        while (!nodeStack.isEmpty() || node != null) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                Node curNode = nodeStack.pop();
                System.out.println(curNode.value);
                node = curNode.right;
            }

        }
    }

    public void lastOut1(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        Stack<Node> printStack = new Stack<>();
        nodeStack.push(node);
        while (!nodeStack.isEmpty()) {
            Node curNode = nodeStack.pop();
            printStack.push(curNode);

            if (curNode.left != null) {
                nodeStack.push(curNode.left);
            }

            if (curNode.right != null) {
                nodeStack.push(curNode.right);
            }
        }

        while (!printStack.isEmpty()) {
            System.out.println(printStack.pop().value);
        }

    }

    public void preOut1(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (!nodeStack.isEmpty()) {
            Node curNode = nodeStack.pop();
            System.out.println(curNode.value);
            if (curNode.right != null) {
                nodeStack.push(curNode.right);
            }

            if (curNode.left != null) {
                nodeStack.push(curNode.left);
            }
        }
    }

    public void lastOut(Node node) {
        if (node == null) {
            return;
        }

        lastOut(node.left);
        lastOut(node.right);
        System.out.println(node.value);
    }

    //中序遍历
    public void middleOut(Node node) {
        if (node == null) {
            return;
        }


        middleOut(node.left);
        System.out.println(node.value);
        middleOut(node.right);
    }

    //前序遍历
    public void preOut(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOut(node.left);
        preOut(node.right);
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
