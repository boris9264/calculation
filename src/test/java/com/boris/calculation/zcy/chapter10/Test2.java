package com.boris.calculation.zcy.chapter10;

import org.junit.Test;

import java.util.Stack;

/**
 * Description:
 * 给定一个栈，逆序这个栈
 * 不能使用额外的数据结构
 *
 * 先实现一个方法 从栈的最底部弹出一个元素
 *
 * @author boris
 * @date Created on 2021/6/10
 */
public class Test2 {
    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        revertStack(stack);
    }

    public void revertStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        Integer tail = popTail(stack);
        revertStack(stack);
        stack.push(tail);
    }

    public Integer popTail(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            Integer curValue = popTail(stack);
            stack.push(result);
            return curValue;
        }

    }

}
