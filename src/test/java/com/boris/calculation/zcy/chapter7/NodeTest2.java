package com.boris.calculation.zcy.chapter7;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Description:
 *
 * @author boris
 * @date Created on 2021/5/27
 */
public class NodeTest2 {
    Node node;

    @Test
    public void test() {
//        nodePrint(node);
        System.out.println(nodeMaxWidth(node));

    }

    //找二叉树的最大宽度
    public int nodeMaxWidth(Node node) {
        int result = 0;
        //当前遍历的层数
        int currentLevel = 1;
        //当前遍历层的节点数
        int currentLevelWidth = 0;
        //key为二叉树节点, value为节点所在层数
        Map<Node, Integer> nodeMap = new HashMap<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);
        nodeMap.put(node, 1);

        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            int curNodeLevel = nodeMap.get(curNode);
            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                nodeMap.put(curNode.left, curNodeLevel + 1);
            }

            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                nodeMap.put(curNode.right, curNodeLevel + 1);
            }

            if (curNodeLevel == currentLevel) {
                currentLevelWidth++;
            } else {
                currentLevel++;
                result = result > currentLevelWidth ? result : currentLevelWidth;
                currentLevelWidth = 1;
            }
        }
        result = result > currentLevelWidth ? result : currentLevelWidth;
        return result;
    }

    //按层遍历二叉树
    public void nodePrint(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            System.out.println(curNode.value);

            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
            }

            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
            }
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
