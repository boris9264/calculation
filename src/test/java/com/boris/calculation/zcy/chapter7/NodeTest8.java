package com.boris.calculation.zcy.chapter7;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * Description: 给定一棵二叉树的头节点head，任何两个节点之间都存在距离，返回整棵二叉树的最大距离
 *
 * @author boris
 * @date Created on 2021/5/31
 */
public class NodeTest8 {
    Node node;

    @Test
    public void test() {
        NodeDistanceInfo nodeDistanceInfo = maxDistanceInfo(node);
        System.out.println(nodeDistanceInfo.height + "   " + nodeDistanceInfo.maxDistance);
    }

    public NodeDistanceInfo maxDistanceInfo(Node node) {
        if (node == null) {
            return new NodeDistanceInfo(0, 0);
        }

        NodeDistanceInfo leftDistanceInfo = maxDistanceInfo(node.left);
        NodeDistanceInfo rightDistanceInfo = maxDistanceInfo(node.right);
        int maxHeight = Math.max(leftDistanceInfo.height, rightDistanceInfo.height) + 1;
        int maxDistance = Math.max(leftDistanceInfo.maxDistance, rightDistanceInfo.maxDistance);
        maxDistance = Math.max(maxDistance, leftDistanceInfo.height + rightDistanceInfo.height + 1);

        return new NodeDistanceInfo(maxHeight, maxDistance);
    }

    public static class NodeDistanceInfo {
        int height;

        int maxDistance;

        public NodeDistanceInfo(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
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
