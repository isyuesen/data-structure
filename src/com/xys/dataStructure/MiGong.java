package com.xys.dataStructure;

import java.util.*;

/**
 * 迷宫找出口
 */
public class MiGong {
    // 迷宫盒子
    // 0 代表空白 1 代表墙 2 代表走过得路 3 代表已经走不通得路
    /*
    * 1 1 1 1 1 1 1 1 1 1
    * 1 0 0 0 0 0 0 0 0 1
    * 1 1 1 0 1 1 1 1 1 1
    * 1 0 0 0 0 0 0 0 0 1
    * 1 0 1 0 1 1 1 1 0 1
    * 1 0 0 0 0 0 0 1 0 1
    * 1 0 0 0 0 0 0 0 0 1
    * 1 1 1 1 1 1 1 1 1 1
    * */
    private int[][] miGongBox = new int[8][10];

    // 出口X对应数组的索引
    private int exportXIndex;

    // 出口Y对应数组的索引
    private int exportYIndex;

    // 存放每走的顺序的次数，根据最短长度来找到最短路径
    private TreeSet<Integer> path = new TreeSet<>();

    // 临时存放次数
    private int tempPathCount = 0;

    // 所有排列的方向
    private List<List<Integer>> permute;

    // 临时方向
    private List<Integer> tempDirection;

    public MiGong(int exportXIndex, int exportYIndex) {
        this.exportXIndex = exportXIndex;
        this.exportYIndex = exportYIndex;
        initMiGongBox();
        int[] pathDirection = { 1,2,3,4 };
        this.permute = new AllArray(pathDirection).permute();
    }

    /**
     * 打印迷宫
     */
    public void printMiGongBox() {
        System.out.println("=================================");
        for (int[] gongBox : miGongBox) {
            for (int box : gongBox) {
                System.out.print(box + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
    }

    /**
     * 初始化迷宫结构
     * 四条边都加上墙
     */
    private void initMiGongBox() {

        for (int i = 0; i < miGongBox.length; i++) {
            for (int j = 0; j < miGongBox[i].length; j++) {
                if (
                        i == 0 || i == miGongBox.length -1 ||
                                j == 0 || j == miGongBox[i].length-1
                ) {
                    miGongBox[i][j] = 1;
                } else {
                    miGongBox[i][j] = 0;
                }
            }
        }

        miGongBox[2][1] = 1;
        miGongBox[2][2] = 1;
        miGongBox[2][4] = 1;
        miGongBox[2][5] = 1;
        miGongBox[2][6] = 1;
        miGongBox[2][7] = 1;
        miGongBox[2][8] = 1;
        miGongBox[4][2] = 1;
        miGongBox[4][4] = 1;
        miGongBox[4][5] = 1;
        miGongBox[6][7] = 1;
        miGongBox[7][7] = 1;

    }

    public Integer startRun() {
        printMiGongBox();
        for (int i = 0; i < permute.size(); i++) {
            initMiGongBox();
            this.tempDirection = permute.get(i);
            boolean run = run(1, 1);
            if (run) {
                path.add(tempPathCount);
                if (tempPathCount == 11) {
                    printMiGongBox();
                }
            } else {
                path.add(null);
            }
            tempPathCount = 0;
        }
        return path.iterator().hasNext() ?  path.iterator().next() : null;
    }


    /**
     * 自动找路中
     * @param i miGongBox二维数组中的第一层
     * @param j miGongBox二维数组中的第二层
     * @return boolean
     */
    private boolean run(int i, int j) {
        // 如果传入i和j与出口XY相等，将会是递归的最后一栈
        if (miGongBox[exportXIndex][exportYIndex] == 2) {
            return true;
        } else {
            if(miGongBox[i][j] != 0) {
                return false;
            } else {
                miGongBox[i][j] = 2;
                tempPathCount++;
                // 上下左右
                if (switchDirection(tempDirection.get(0),i,j)) {
                    return true;
                } else if (switchDirection(tempDirection.get(1),i,j)) {
                    return true;
                } else if (switchDirection(tempDirection.get(2),i,j)) {
                    return true;
                } else if (switchDirection(tempDirection.get(3),i,j)) {
                    return true;
                } else {
                    miGongBox[i][j] = 3;
                    tempPathCount--;
                    return false;
                }
            }
        }
    }

    private boolean switchDirection(Integer number, int i, int j) {
        switch (number) {
            case 1:
                return run(i-1, j);
            case 2:
                return run(i+1, j);
            case 3:
                return run(i, j-1);
            case 4:
                return run(i, j+1);
        }
        return false;
    }
}
