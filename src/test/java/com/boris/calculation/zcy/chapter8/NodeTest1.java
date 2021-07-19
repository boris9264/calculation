package com.boris.calculation.zcy.chapter8;

import com.boris.calculation.util.JsonUtil;
import com.boris.calculation.zcy.chapter7.Node;
import org.junit.Before;
import org.junit.Test;

/**
 * Description: 给定一棵二叉树的头节点head，判断这棵二叉树是不是满二叉树
 *
 * 满二叉树的节点个数与层数相关 值都是固定的
 * @author boris
 * @date Created on 2021/6/1
 */
public class NodeTest1 {
    Node node;

    @Test
    public void test() {
        NodeInfo nodeInfo = getNodeInfo(node);
        System.out.println(1);
    }

    public NodeInfo getNodeInfo(Node head) {
        if (head == null) {
            return new NodeInfo(0, 0, true);
        }

        NodeInfo leftNodeInfo = getNodeInfo(head.left);
        NodeInfo rightNodeInfo = getNodeInfo(head.right);
        int height = Math.max(leftNodeInfo.height, rightNodeInfo.height) + 1;
        boolean isFull = leftNodeInfo.isFull && rightNodeInfo.isFull;
        int nodeNumber = leftNodeInfo.nodeNumber + rightNodeInfo.nodeNumber + 1;
        if (isFull) {
            int pow = (int) Math.pow(2, height) - 1;
            isFull = pow == nodeNumber;
            return new NodeInfo(height, nodeNumber, isFull);
        }
        return new NodeInfo(height, nodeNumber, isFull);

    }

    public static class NodeInfo {
        int height;
        int nodeNumber;
        boolean isFull;

        public NodeInfo(int height, int nodeNumber, boolean isFull) {
            this.height = height;
            this.nodeNumber = nodeNumber;
            this.isFull = isFull;
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
//        node3.right = node7;

        node.left = node2;
        node.right = node3;

        System.out.println(JsonUtil.toString(node));
    }
}
