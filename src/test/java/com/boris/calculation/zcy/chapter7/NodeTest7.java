package com.boris.calculation.zcy.chapter7;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * Description: 给定一颗二叉树的头节点head，判断这颗二叉树是不是平衡二叉树
 * <p>
 * 左右子树必须是平衡的，左右子树高度不能相差超过1
 *
 * @author boris
 * @date Created on 2021/5/31
 */
public class NodeTest7 {
    Node node;

    @Test
    public void test() {
        NodeBalanceInfo nodeBalanceInfo = nodeIsBalance(node);
        System.out.println(JsonUtil.toString(nodeBalanceInfo));
    }

    public NodeBalanceInfo nodeIsBalance(Node node) {
        if (node == null) {
            return new NodeBalanceInfo(0, true);
        }

        NodeBalanceInfo leftBalanceInfo = nodeIsBalance(node.left);
        NodeBalanceInfo rightBalanceInfo = nodeIsBalance(node.right);
        int height = Math.max(leftBalanceInfo.height, rightBalanceInfo.height) + 1;
        boolean isBalance = false;
        if (leftBalanceInfo.isBalance && rightBalanceInfo.isBalance && Math.abs(leftBalanceInfo.height - rightBalanceInfo.height) <= 1) {
            isBalance = true;
        }
        return new NodeBalanceInfo(height, isBalance);
    }

    public static class NodeBalanceInfo {
        int height;
        boolean isBalance;

        public NodeBalanceInfo(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    @Before
    public void init() {
        node = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node.left = node2;
        node.left.left = node4;

        System.out.println(JsonUtil.toString(node));
    }
}
