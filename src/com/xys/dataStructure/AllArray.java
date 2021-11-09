package com.xys.dataStructure;

import java.util.*;


/**
 * 穷举（递归方式），求出数组中有几种排序组合
 */
public class AllArray {
    // 总全排列
    private List<List<Integer>> rt = new ArrayList<>();
    // 临时变量存放元素
    private List<Integer> list = new ArrayList<>();
    // 初始数组索引代表
    private int[] arr;

    public AllArray(int[] arr) {
        this.arr = arr;
    }

    public List<List<Integer>> permute() {
        backtrack(arr);
        return rt;
    }

    private void backtrack(int[] nums) {
        if(list.size() == nums.length) {
            rt.add(new ArrayList<>(list));//               【1】已经存够数字个数的列表，所以把这个list存起来即可
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);                                  //【4】添加有效num
            backtrack(nums);                                //【5】开始查找下一个值
            list.remove(list.size() - 1);             //【6】移除当前这个末尾的num
        }
    }
}
