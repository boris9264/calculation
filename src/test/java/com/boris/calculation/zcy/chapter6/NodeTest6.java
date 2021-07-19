package com.boris.calculation.zcy.chapter6;

import org.junit.Before;
import org.junit.Test;

/**
 * Description:
 * 能不能不给单向链表的头节点，只给想要删除的节点，就能做到在链表上把这个节点删掉
 * 无法删除最末尾的节点 只能通过给要删除的变量重新复制next指向下下个
 * 不给头节点无法完美删除
 *
 * @author boris
 * @date Created on 2021/5/26
 */
public class NodeTest6 {
    Node head;

    @Before
    public void init() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);
    }

    @Test
    public void test() {
        deleteNode(head.next);
        System.out.println(123);
    }

    public void deleteNode(Node node) {
        if (node!=null && node.next!=null) {
            node.value = node.next.value;
            if (node.next.next!=null) {
                node.next = node.next.next;
            } else {
                node.next = null;
            }
        }

    }
}
