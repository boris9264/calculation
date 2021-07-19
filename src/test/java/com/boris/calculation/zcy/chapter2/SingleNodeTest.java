package com.boris.calculation.zcy.chapter2;

import com.boris.calculation.util.JsonUtil;
import com.boris.calculation.zcy.bean.SingleNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

/**
 * Description: 单向链表
 *
 * @author boris
 * @date Created on 2021/5/13
 */
public class SingleNodeTest {
    SingleNode singleNode;
    @Before
    public void init() {
        singleNode = new SingleNode(1, new SingleNode(2, new SingleNode(3, new SingleNode(4))));
    }

    @Test
    public void test() {
//        System.out.println(JsonUtil.toString(this.revert(singleNode)));
        System.out.println(JsonUtil.toString(this.delete(singleNode, 2)));

    }

    //单向链表反转
    public SingleNode revert(SingleNode param) {
        SingleNode result = null;
        SingleNode current = null;
        while (!Objects.isNull(param)) {
            current = result;
            result = new SingleNode(param.getValue());
            result.setNext(current);
            param = param.getNext();
        }
        return result;
    }

    public SingleNode delete(SingleNode param, int value) {
        while (!Objects.isNull(param)) {
            if (param.getValue() == value) {
                param = param.getNext();
            } else {
                break;
            }
        }

        SingleNode curNode = param;
        SingleNode prevNode = param;

        while (!Objects.isNull(curNode)) {
            if (curNode.getValue() == value) {
                prevNode.setNext(curNode.getNext());
                curNode = prevNode;
            } else {
                prevNode = curNode;
            }
            curNode = curNode.getNext();
        }
        return param;
    }
}
