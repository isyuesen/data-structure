package com.xys.dataStructure;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[8000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        long begin = new Date().getTime();
        new ChaRu(arr);

        long result = new Date().getTime()-begin;
//        System.out.println(Arrays.toString(sort));
        System.out.println(result);
    }
}
