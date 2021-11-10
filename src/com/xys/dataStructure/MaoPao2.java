package com.xys.dataStructure;

/**
 * 冒泡排序优化
 */
public class MaoPao2 {
    private int[] arr;

    public MaoPao2(int[] arr) {
        this.arr = arr;
    }


    /**
     * 排序
     * 和原来的冒泡排序的区别在于，新冒泡如果数组中的顺序已经符合要求了，就可以退出排序了
     * 老冒泡排序，即使数组中的顺序已经排好了，还会继续排
     * @return {}
     */
    public int[] sort() {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                int temp = arr[j];
                if (temp > arr[j+1]) {
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 如果有进行交换，说明数组还没有排好
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }
}
