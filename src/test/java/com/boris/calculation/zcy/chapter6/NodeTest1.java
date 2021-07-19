package com.boris.calculation.zcy.chapter6;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

/**
 * Description: 快慢指针
 *
 * @author boris
 * @date Created on 2021/5/25
 */
public class NodeTest1 {
    Node head;

    @Before
    public void init() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
    }

    @Test
    public void test() {
        System.out.println(JsonUtil.toString(middle1(head)));
        System.out.println(JsonUtil.toString(middle2(head)));
        System.out.println(JsonUtil.toString(middle3(head)));
        System.out.println(JsonUtil.toString(middle4(head)));
    }

    //4.输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
    public Node middle4(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //3.输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    public Node middle3(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return head;
        }

        Node slow = head;
        Node fast = head.next.next;
        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //2.输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public Node middle2(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        Node slow = head.next;
        Node fast = head.next;
        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //1.输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public Node middle1(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return head;
        }

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
