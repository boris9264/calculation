package com.boris.calculation.zcy.chapter2;

import com.boris.calculation.util.JsonUtil;

/**
 * Description: 用数组实现队列
 *
 * @author boris
 * @date Created on 2021/5/14
 */
public class MyQueue {
    private int queueSize;
    private int queueLimit;
    private int[] queueArr;
    private int addIndex;
    private int getIndex;

    public MyQueue(int queueLimit) {
        this.queueLimit = queueLimit;
        queueArr = new int[queueLimit];
        this.queueSize = 0;
        this.addIndex = 0;
        this.getIndex = 0;
    }

    public boolean addToQueue(int value) {
        if (queueSize == queueLimit) {
            return false;
        }
        queueSize++;
        queueArr[addIndex] = value;
        addIndex = this.nextQueueIndex(addIndex);
        return true;
    }

    public int getFromQueue() {
        if (queueSize == 0) {
            throw new RuntimeException("队列为空");
        }
        queueSize--;

        int result = queueArr[getIndex];
        getIndex = this.nextQueueIndex(getIndex);
        return result;
    }

    private int nextQueueIndex(int queueIndex) {
        return queueIndex < queueLimit-1?queueIndex+1:0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.addToQueue(1);
        myQueue.addToQueue(2);
        myQueue.addToQueue(3);
        myQueue.addToQueue(4);
        myQueue.addToQueue(5);

        System.out.println(myQueue.getFromQueue());
        myQueue.addToQueue(6);
        System.out.println(myQueue.getFromQueue());
        System.out.println(JsonUtil.toString(myQueue.queueArr));
    }
}
