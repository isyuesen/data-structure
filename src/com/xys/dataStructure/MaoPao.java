package com.xys.dataStructure;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class MaoPao {
    private int[] arr;

    public MaoPao(int[] arr) {
        this.arr = arr;
    }
    public int[] sort() {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                int temp = arr[j];
                if (temp > arr[j+1]) {
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
