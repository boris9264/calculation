package com.boris.calculation.zcy.chapter7;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: 二叉树序列化和反序列化 需要考虑子节点为空值
 *
 * @author boris
 * @date Created on 2021/5/27
 */
public class NodeTest3 {
    Node node;

    @Test
    public void test() {
        Queue<Integer> queue = nodeSerialize(node);
        Node node = buildNodeFromSerialize(queue);
        System.out.println(JsonUtil.toString(node));
    }

    public Node buildNodeFromSerialize(Queue<Integer> nodeQueue) {
        Integer value = nodeQueue.poll();
        if (value == null) {
            return null;
        }
        Node node = new Node(value);
        node.left = buildNodeFromSerialize(nodeQueue);
        node.right = buildNodeFromSerialize(nodeQueue);
        return node;
    }

    public Queue<Integer> nodeSerialize(Node node) {
        Queue<Integer> nodeQueue = new LinkedList<>();
        createNodeSerialize(node, nodeQueue);
        return nodeQueue;
    }

    public void createNodeSerialize(Node node, Queue<Integer> nodeQueue) {
        if (node == null) {
            nodeQueue.offer(null);
        } else {
            createNodeSerialize(node.left, nodeQueue);
            nodeQueue.offer(node.value);
            createNodeSerialize(node.right, nodeQueue);
        }
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
