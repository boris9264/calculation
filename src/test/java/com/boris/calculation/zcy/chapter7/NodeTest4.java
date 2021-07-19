package com.boris.calculation.zcy.chapter7;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Description: 打印整棵二叉树(形状)
 *
 * @author boris
 * @date Created on 2021/5/27
 */
public class NodeTest4 {
    Node node;

    @Test
    public void test() {
//        print(node);
        System.out.println(depth(node));
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);
        //节点和层数坐标
        Map<Node, Integer> nodeLevelMap = new HashMap<>();
        nodeLevelMap.put(node, 1);
        int printLevel = 1;

        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            int currentNodeLevel = nodeLevelMap.get(curNode);

            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                nodeLevelMap.put(curNode.left, currentNodeLevel + 1);
            }

            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                nodeLevelMap.put(curNode.right, currentNodeLevel + 1);
            }

            if (printLevel != currentNodeLevel) {
                System.out.println();
                printLevel++;
            }
            System.out.print(curNode.value);

        }
    }

    public int depth(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
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
