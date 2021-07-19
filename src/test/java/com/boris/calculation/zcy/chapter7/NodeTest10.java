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
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * @author boris
 * @date Created on 2021/6/1
 */
public class NodeTest10 {
    @Test
    public void test() {
        System.out.println(nodeWidth(node));
    }

    Node node;

    public int nodeWidth(Node head) {
        int maxNodeWidth = 0;
        if (head == null) {
            return maxNodeWidth;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(head);
        Map<Node, Integer> nodeLevelMap = new HashMap<>();
        nodeLevelMap.put(head, 1);
        Integer nodeLevel = 1;
        Integer curLevelWidth = 0;

        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            Integer curLevel = nodeLevelMap.get(curNode);

            if (curNode.left != null) {
                nodeQueue.offer(curNode.left);
                nodeLevelMap.put(curNode.left, curLevel + 1);
            }

            if (curNode.right != null) {
                nodeQueue.offer(curNode.right);
                nodeLevelMap.put(curNode.right, curLevel + 1);
            }

            if (!nodeLevel.equals(curLevel)) {
                maxNodeWidth = Math.max(curLevelWidth, maxNodeWidth);
                curLevelWidth = 1;
                nodeLevel++;
            } else {
                curLevelWidth++;
            }
        }
        maxNodeWidth = Math.max(curLevelWidth, maxNodeWidth);
        return maxNodeWidth;
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
