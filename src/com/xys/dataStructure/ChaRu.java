package com.xys.dataStructure;

/**
 *  插入排序
 *      基本思想：
 *          一开始把第一个元素当成一个数组，循环，看i前面的元素是否比元素i大，如果大互换位置
 */
public class ChaRu {
    private int[] arr;

    public ChaRu(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[j] > temp) {
                    int temp2 = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp2;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}
