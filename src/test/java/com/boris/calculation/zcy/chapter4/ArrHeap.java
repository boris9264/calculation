package com.boris.calculation.zcy.chapter4;

import java.util.Arrays;

/**
 * Description: 用数组构建二叉树  大根堆 每一个根节点的数都比子节点大
 *
 * @author boris
 * @date Created on 2021/5/19
 */
public class ArrHeap {
    int[] heapArr;

    private int limit;

    private int index = 0;

    public ArrHeap(int limit) {
        heapArr = new int[limit];
        this.limit = limit;
    }

    public int[] add(int number) {
        if (limit == index) {
            return heapArr;
        }
        heapArr[index] = number;
        this.insertHeap();
        index++;
        return heapArr;
    }

    private void insertHeap() {
        int curIndex = index;

        while (heapArr[curIndex] > heapArr[(curIndex-1) / 2]) {
            swapArr(curIndex, (curIndex-1) / 2);
            curIndex = (curIndex-1) / 2;
        }
    }

    private void swapArr(int index1, int index2) {
        int swap = heapArr[index1];
        heapArr[index1] = heapArr[index2];
        heapArr[index2] = swap;
    }

    //返回最大值 并且把最大值删除
    public int pop() {
        int result = heapArr[0];
        swapArr(0, index-1);
        heapArr[index-1] = 0;
        index--;
        rebuildHeapArr();
        return result;
    }

    private void rebuildHeapArr() {
        int curIndex = 0;
        //左子节点下标
        int left = 0*2+1;

        while (left < index) {
            //取出左右子节点最大值下标
            int max = left + 1 <= index && heapArr[left] < heapArr[left + 1] ? left + 1 : left;
            if (heapArr[max] <= heapArr[curIndex]) {
                return;
            }
            swapArr(curIndex, max);
            curIndex = max;
            left = curIndex*2+1;
        }
    }


    public static void main(String[] args) {
        ArrHeap heap = new ArrHeap(20);
        for (int i = 0; i < 20; i++) {
            int number = (int) (Math.random()*(20-1)+1);
            System.out.println(number + "   " + Arrays.toString(heap.add(number)));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(heap.pop() + "   " + Arrays.toString(heap.heapArr));
        }
    }
}
