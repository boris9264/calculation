package com.boris.calculation.zcy.chapter8;

import com.boris.calculation.util.JsonUtil;
import com.boris.calculation.zcy.chapter7.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * 给定一棵二叉树的头节点head，和另外两个节点a和b。
 * 返回a和b的最低公共祖先
 *
 * @author boris
 * @date Created on 2021/6/1
 */
public class NodeTest3 {
    @Test
    public void test() {
        Node sameParentNode = getSameParentNode(node, node.left.left, node.left.right);
        System.out.println(JsonUtil.toString(sameParentNode));
    }

    /**
     * 遍历二叉树节点，组成node,parentNode Map
     * 二叉树1寻找所有父节点放入set集合
     * 二叉树2寻找所有父节点并判断set集合是否存在，如果存在返回该存在节点
     *
     * @param head
     * @param node1
     * @param node2
     * @return
     */
    public Node getSameParentNode(Node head, Node node1, Node node2) {
        if (head == null || node1 == null || node2 == null) {
            return null;
        }

        Map<Node, Node> nodeParentMap = new HashMap<>();
        nodeParentMap.put(head, null);
        this.initNodeParentMap(head, nodeParentMap);

        Set<Node> nodeParentSet = new HashSet<>();
        nodeParentSet.add(node1);

        Node parentNode = nodeParentMap.get(node1);
        while (parentNode != null) {
            nodeParentSet.add(parentNode);
            parentNode = nodeParentMap.get(parentNode);
        }

        parentNode = node2;
        while (parentNode != null) {
            if (nodeParentSet.contains(parentNode)) {
                return parentNode;
            }
            parentNode = nodeParentMap.get(parentNode);
        }

        return null;
    }

    public void initNodeParentMap(Node head, Map<Node, Node> nodeParentMap) {
        if (head.left != null) {
            nodeParentMap.put(head.left, head);
            initNodeParentMap(head.left, nodeParentMap);
        }

        if (head.right != null) {
            nodeParentMap.put(head.right, head);
            initNodeParentMap(head.right, nodeParentMap);
        }
    }

    Node node;

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
