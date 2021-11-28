package com.xys.dataStructure;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1000);
        }
        System.out.println( Arrays.toString(arr) );
        long begin = new Date().getTime();

        IntStream stream = Arrays.stream(arr);
        Stream<Integer> boxed = stream.boxed();

        Integer[] integers = boxed.toArray(Integer[]::new);

        int[] sort = new XiEr(arr).sort();

        long result = new Date().getTime()-begin;
//        System.out.println(Arrays.toString(arr));
        System.out.println(result);
    }
}
