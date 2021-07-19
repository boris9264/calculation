package com.boris.calculation.zcy.chapter6;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

/**
 * Description: 判断一个链表是不是回文结构
 *
 * @author boris
 * @date Created on 2021/5/25
 */
public class NodeTest2 {
    Node head;

    @Before
    public void init() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
//        head.next.next.next.next.next = new Node(6);
    }

    @Test
    public void test() {
        System.out.println(checkPalindrome(head));
    }

    public boolean checkPalindrome(Node head) {
        Stack<Integer> nodeStack = new Stack<>();

        Node curNode = head;
        while (curNode != null) {
            nodeStack.push(curNode.value);
            curNode = curNode.next;
        }

        curNode = head;
        while (!nodeStack.isEmpty()) {
            if (!nodeStack.pop().equals(curNode.value)) {
                return false;
            }
            curNode = curNode.next;
        }
        return true;
    }
}
