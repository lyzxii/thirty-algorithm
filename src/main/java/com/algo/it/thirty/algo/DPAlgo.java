package com.algo.it.thirty.algo;

import edu.princeton.cs.algs4.In;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月27日
 * @since: 1.0.0
 */
public class DPAlgo {
    public static void main(String[] args) {
        int fn = fn(45);
        System.out.println(fn);

        int fx = fx(45);
        System.out.println(fx);

        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    /**
     * 斐波那契数据，n=0,f(n)=0,n=1,f(n)=1,f(n)=f(n-1) +f(n-2)
     */
    public static int fn(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fn(n - 1) + fn(n - 2);
    }

    /**
     * 斐波那契数据+动态规划实现，n=0,f(n)=0,n=1,f(n)=1,f(n)=f(n-1) +f(n-2)
     */
    public static int fx(int n) {
        int i = 0;
        int j = 1;
        int res = 0;
        if (n == 1) res = 1;
        while (n > 1) {
            res = i + j;
            i = j;
            j = res;
            n--;
        }
        return res;
    }

    /**
     * 股票最大收益，比如[7,1,5,3,6,4],最大利润为5，1买6卖;比如[7,5,4,3,1],最大利润为0
     */
    public static int maxProfit(int[] arr) {
        int cost = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            cost = Integer.min(cost, arr[i]);
            profit = Integer.max(profit, arr[i] - cost);
        }
        return profit;

    }

    /**
     * 最大子数组，比如[-2,1,-3,4,-1,2,1,-5,4],最大利润为5，1买6卖;比如[7,5,4,3,1],最大利润为0
     */
    public int maxSubArray(int[] arr) {
        int res = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Integer.max(max + arr[i], arr[i]);
            res = Integer.max(res, max);
        }
        return res;
    }
}
