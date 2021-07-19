package com.boris.calculation.zcy.chapter7;

import org.junit.Before;
import org.junit.Test;

/**
 * Description: 根据二叉树的某个节点，返回该节点的后继节点 顺序为中序遍历
 *
 * @author boris
 * @date Created on 2021/5/28
 */
public class NodeTest5 {
    public static class Node<V> {
        V value;
        Node left;
        Node right;
        Node parent;

        public Node(V value) {
            this.value = value;
        }
    }

    Node<Integer> node;

    @Test
    public void test() {
        Node<Integer> nextNode = getNextNode(node.right.right);
        System.out.println(123);
    }

    public static <V> Node<V> getNextNode(Node<V> node) {
        if (node == null) {
            return null;
        }

        if (node.parent == null) {
            if (node.right == null) {
                return null;
            }
            Node<V> curNode = node.right;
            while (true) {
                if (curNode.left == null) {
                    return curNode;
                }

                curNode = curNode.left;
            }

        }

        if (node == node.parent.left) {
            if (node.right == null) {
                return node.parent;
            } else {
                Node<V> curNode = node.right;
                while (true) {
                    if (curNode.left == null) {
                        return curNode;
                    }
                    curNode = curNode.left;
                }
            }

        } else {
            Node<V> curNode = node.parent;
            while (curNode.parent != null && curNode != curNode.parent.left) {
                curNode = curNode.parent;
            }
            return curNode.parent;
        }
    }

    public static <V> Node<V> getParentNode(Node<V> node) {
        return null;
    }

    @Before
    public void init() {
        node = new Node(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        node2.parent = node;
        node3.parent = node;

        node4.parent = node2;
        node5.parent = node2;

        node6.parent = node3;
        node7.parent = node3;

    }
}
