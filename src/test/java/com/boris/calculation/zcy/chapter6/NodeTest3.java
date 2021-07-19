package com.boris.calculation.zcy.chapter6;

import com.boris.calculation.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * Description: 将单向链表按照某值划分成左边小、中间相等、右边大的形式
 *
 * @author boris
 * @date Created on 2021/5/25
 */
public class NodeTest3 {
    Node head;

    @Before
    public void init() {
        head = new Node(7);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(1);
    }

    @Test
    public void test() {
        Node node = this.groupByNumber(head, 3);
        System.out.println(JsonUtil.toString(node));
    }

    public Node groupByNumber(Node head, int number) {
        Node curNode = head;
        int length = 0;

        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }

        Node[] nodeArray = new Node[length];
        curNode = head;

        for (int i = 0; i < length; i++) {
            nodeArray[i] = curNode;
            curNode = curNode.next;
        }

        this.groupNodeArrayByNumber(nodeArray, number);

        Node result = new Node(0);
        curNode = result;
        for (int i = 0; i < nodeArray.length; i++) {
            Node next = new Node(nodeArray[i].value);
            curNode.next = next;
            curNode = curNode.next;
        }
        return result.next;
    }

    private void groupNodeArrayByNumber(Node[] nodeArr, int number) {
        int rightIndex = nodeArr.length - 1;
        int leftIndex = 0;

        for (int i = 0; i < nodeArr.length; i++) {
            if (i >= rightIndex) {
                break;
            }
            if (nodeArr[i].value > number) {
                int swap = nodeArr[rightIndex].value;
                nodeArr[rightIndex].value = nodeArr[i].value;
                nodeArr[i].value = swap;
                i--;
                rightIndex--;
            } else if (nodeArr[i].value < number) {
                int swap = nodeArr[leftIndex].value;
                nodeArr[leftIndex].value = nodeArr[i].value;
                nodeArr[i].value = swap;
                leftIndex++;
            }
        }
    }

}
