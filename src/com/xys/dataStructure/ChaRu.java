package com.xys.dataStructure;

import java.util.*;

/**
 *  插入排序
 *      基本思想：
 *          一开始把第一个元素当成一个数组
 */
public class ChaRu {
    private LinkedList<Integer> arr;

    public ChaRu(Integer[] arr) {

        ArrayList<Integer> integers = new ArrayList<>(arr.length);
        Collections.addAll(integers, arr);
        this.arr = new LinkedList<>(integers);
    }
    /*public int[] sort() {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i; j  > 0; j--) {
                if (temp > arr[j]) {
                    arr[j + 1] = temp;
                }
            }

        }
        return arr;
    }*/
}
