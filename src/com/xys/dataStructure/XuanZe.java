package com.xys.dataStructure;

/**
 * 选择排序
 * 基本思路：
 *      第一次遍历，从索引0开始，把最小的找出来，arr[0]和arr[无序数组中最小的那个索引] 交换位置
 *      第二次遍历，从索引1开始，把最小的找出来，arr[1]和arr[无序数组中最小的那个索引] 交换位置
 *      直到遍历完。。。。。。。。。
 */
public class XuanZe {

    private int[] arr;

    public XuanZe(int[] arr) {
        this.arr = arr;
    }

    public int[] sort() {
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i];
            for (int j = i+1; j < arr.length-1; j++) {
                if (temp > arr[j]) {
                    int temp2 = arr[j];
                    arr[j] = temp;
                    temp = temp2;
                }
            }
            arr[i] = temp;
        }
        return arr;
    }
}
