package com.boris.calculation.zcy.chapter7;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * Description:
 * 给定一棵二叉树的头节点head
 * 返回这棵二叉树中中最大的二叉搜索子树的节点个数
 * 搜索子树 头节点与左右节点(子树)比较 左节点(子树)小 右节点(子树)大
 *
 * @author boris
 * @date Created on 2021/5/31
 */
public class NodeTest9 {
    @Test
    public void test() {
        NodeInfo nodeInfo = searchNodeInfo(node);
        System.out.println(123);
    }

    public NodeInfo searchNodeInfo(Node head) {
        if (head == null) {
            return null;
        }

        NodeInfo leftNodeInfo = searchNodeInfo(head.left);
        NodeInfo rightNodeInfo = searchNodeInfo(head.right);
        int max = head.value;
        int min = head.value;
        int searchNodeNumber = 0;
        Node searchNodeHead = null;
        boolean isSearch = false;

        if (leftNodeInfo != null) {
            max = Math.max(max, leftNodeInfo.max);
            min = Math.min(min, leftNodeInfo.min);
        }

        if (rightNodeInfo != null) {
            max = Math.max(max, rightNodeInfo.max);
            min = Math.min(min, rightNodeInfo.min);
        }

        if (leftNodeInfo != null) {
            searchNodeNumber = leftNodeInfo.searchNodeNumber;
        }

        if (rightNodeInfo != null) {
            searchNodeNumber = Math.max(searchNodeNumber, rightNodeInfo.searchNodeNumber);
        }

        if ((leftNodeInfo != null ? leftNodeInfo.isSearch : true) &&
                (rightNodeInfo != null ? rightNodeInfo.isSearch : true) &&
                (leftNodeInfo != null ? leftNodeInfo.max < head.value : true) &&
                (rightNodeInfo != null ? rightNodeInfo.min > head.value : true)) {
            isSearch = true;
            searchNodeNumber = leftNodeInfo != null ? leftNodeInfo.searchNodeNumber : 0;
            searchNodeNumber += rightNodeInfo != null ? rightNodeInfo.searchNodeNumber : 0;
            searchNodeNumber += 1;
            searchNodeHead = head;
        }

        return new NodeInfo(max, min, searchNodeNumber, isSearch, searchNodeHead);
    }

    public static class NodeInfo {
        int max;
        int min;
        int searchNodeNumber;
        boolean isSearch;
        Node searchNodeHead;

        public NodeInfo(int max, int min, int searchNodeNumber, boolean isSearch, Node searchNodeHead) {
            this.max = max;
            this.min = min;
            this.searchNodeNumber = searchNodeNumber;
            this.isSearch = isSearch;
            this.searchNodeHead = searchNodeHead;
        }
    }

    Node node;

    @Before
    public void init() {
        node = new Node(1);
        Node node2 = new Node(9);
        Node node4 = new Node(4);
        Node node5 = new Node(19);
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
