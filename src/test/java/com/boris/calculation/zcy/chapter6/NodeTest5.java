package com.boris.calculation.zcy.chapter6;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 * 给定两个可能有环也可能无环的单向链表，头节点head1和head2.
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点。
 * 如果不相交，返回null
 *
 * @author boris
 * @date Created on 2021/5/26
 */
public class NodeTest5 {
    Node head1;
    Node head2;

    @Test
    public void test() {
        Node intersectNode = getIntersectNode(head1, head2);
        System.out.println(123);

    }

    public Node getIntersectNode(Node head1, Node head2) {
        Node head1AnnularFirstNode = getAnnularFirstNode(head1);
        Node head2AnnularFirstNode = getAnnularFirstNode(head2);

        //两个链表都无环时 判断无环相交节点
        if (head1AnnularFirstNode == null && head2AnnularFirstNode == null) {
            return getNoAnnularIntersectNode(head1, head2);
        }

        if (head1AnnularFirstNode != null && head2AnnularFirstNode != null) {
            return getAnnularIntersectNode(head1, head2, head1AnnularFirstNode, head2AnnularFirstNode);
        }
        return null;
    }

    //两个链表都有环时 环形必相同
    //1.如果没有相同环形 没有相交
    //2.相交于环形上 环形入口不同
    //3.相交于环形外节点 环形入口相同
    private Node getAnnularIntersectNode(Node head1, Node head2, Node head1AnnularFirstNode, Node head2AnnularFirstNode) {
        Node curNode1 = head1AnnularFirstNode;

        //判断是否有相同环形
        boolean annularIntersect = false;
        while (curNode1 != null) {
            if (curNode1 == head2AnnularFirstNode) {
                annularIntersect = true;
                break;
            }
            curNode1 = curNode1.next;
        }

        if (!annularIntersect) {
            return null;
        }

        if (head1AnnularFirstNode == head2AnnularFirstNode) {
            //环形入口相同时 如果相交必相交于环形入口节点之上
            curNode1 = head1;
            Node curNode2 = head2;

            int length1 = 0;
            int length2 = 0;

            while (curNode1 != null && curNode1 != head1AnnularFirstNode) {
                length1++;
                curNode1 = curNode1.next;
            }

            while (curNode2 != null && curNode2 != head2AnnularFirstNode) {
                length2++;
                curNode2 = curNode2.next;
            }

            //长度大的链表放入curNode1  =
            curNode1 = length1 > length2 ? head1 : head2;

            //长度小的链表放入curNode2
            curNode2 = length1 > length2 ? head2 : head1;

            int difference = Math.abs(length1-length2);
            while (difference > 0) {
                difference--;
                curNode1 = curNode1.next;
            }

            while (curNode1 != null && curNode2 != null) {
                if (curNode1 == curNode2) {
                    return curNode1;
                }
                curNode1 = curNode1.next;
                curNode2 = curNode2.next;
            }
        } else {
            return head1AnnularFirstNode;
        }
        return null;
    }

    //两个链表都无环时 找相交节点
    //两个无环链表相交 链表尾部必相交
    private Node getNoAnnularIntersectNode(Node head1, Node head2) {
        Node curNode1 = head1;
        Node curNode2 = head2;

        int length1 = 0;
        int length2 = 0;

        while (curNode1 != null) {
            length1++;
            curNode1 = curNode1.next;
        }

        while (curNode2 != null) {
            length2++;
            curNode2 = curNode2.next;
        }

        //长度大的链表放入curNode1  =
        curNode1 = length1 > length2 ? head1 : head2;

        //长度小的链表放入curNode2
        curNode2 = length1 > length2 ? head2 : head1;

        int difference = Math.abs(length1-length2);
        while (difference > 0) {
            difference--;
            curNode1 = curNode1.next;
        }

        while (curNode1 != null && curNode2 != null) {
            if (curNode1 == curNode2) {
                return curNode1;
            }
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        return null;
    }

    //判断链表是否有环 有环时返回链表入环节点
    private Node getAnnularFirstNode(Node head) {
        Node curNode = head;
        Set<Node> nodeSet = new HashSet<>();

        while (curNode != null) {
            if (nodeSet.contains(curNode)) {
                return curNode;
            }
            nodeSet.add(curNode);
            curNode = curNode.next;
        }
        return null;
    }

    @Before
    public void init() {
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = head1.next.next;

        head2 = new Node(7);
        head2.next = head1.next.next;
    }

}
