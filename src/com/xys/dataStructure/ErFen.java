package com.xys.dataStructure;

/**
 * 二分查找
 * 使用二分查找的前提是数组必须要是有序的
 */
public class ErFen {
    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,9,11,16,90};
        int index = find(1, arr, 0, arr.length);
        System.out.println(index);
    }

    public static int find(int findNumber, int[] arr, int leftIndex, int rightIndex) {
        int tempIndex = leftIndex + (rightIndex - leftIndex) / 2;

        if (findNumber > arr[tempIndex] ) {
            if (leftIndex == arr.length-1) {
                return -1;
            }
            return find(findNumber, arr,tempIndex, rightIndex );
        } else if (arr[tempIndex] == findNumber) {
            return tempIndex;
        } else {
            if (rightIndex == 1) {
                return -1;
            }
            return find(findNumber, arr,leftIndex, tempIndex );
        }
    }

}
