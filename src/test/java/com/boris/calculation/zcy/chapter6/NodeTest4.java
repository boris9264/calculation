package com.boris.calculation.zcy.chapter6;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节点，也可能指向null。
 * 给定一个由Node节点类型组成的无环单链表的头节点head，完成链表的复制
 * 【要求】
 * 时间复杂度O(N)，额外空间复杂度O(1)
 *
 * @author boris
 * @date Created on 2021/5/25
 */
public class NodeTest4 {
    public static class Node {
        int value;
        Node next;
        Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head;

    @Test
    public void test() {
        Node copy = copy(head);
        System.out.println(1321);
    }

    public Node copy(Node head) {
        Node curNode = head;
        Map<Node, Node> nodeMap = new HashMap<>();

        while (curNode != null) {
            nodeMap.put(curNode, new Node(curNode.value));
            curNode = curNode.next;
        }

        curNode = head;
        while (curNode != null) {
            nodeMap.get(curNode).next = nodeMap.get(curNode.next);
            nodeMap.get(curNode).rand = nodeMap.get(curNode.rand);
            curNode = curNode.next;
        }
        return nodeMap.get(head);
    }

    @Before
    public void init() {
        head = new Node(1);
        head.rand = head;

        head.next = new Node(2);
        head.next.rand = null;

        head.next.next = new Node(3);
        head.next.next.rand = head.next;

        head.next.next.next = new Node(4);
        head.next.next.next.rand = head;

        head.next.next.next.next = new Node(5);
        head.next.next.next.next.rand = head.next.next.next;
    }
}
