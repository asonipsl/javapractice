package knapsack;

import java.util.Arrays;

public class Knapsack01 {

    static int[][] mmzArr;
    public static void main(String[] args) {
        int wt[] = {1,3,4,5,2,6};
        int val[] = {1,4,5,7,3,2};
        int w = 9;
        int n = 6;
        mmzArr= new int[n+1][w+1];
        for (int i =0; i< n+1;i++) {
            Arrays.fill(mmzArr[i],-1);
        }
        for (int i = 0; i< n+1; i++) {
            mmzArr[i][0] = 0;
        }
        for (int i = 0; i< w+1; i++) {
            mmzArr[0][i] = 0;
        }
        long startTime =  System.nanoTime();
        System.out.println("Memoization: Max Profit = " + recursive(wt,val,w,n));
        System.out.println("Memoization: Time = " + (System.nanoTime() - startTime));
        startTime = System.nanoTime();
        System.out.println("Memoization: Max Profit = " + knapsackMmz(wt,val,w,n));
        System.out.println("Memoization: Time = " + (System.nanoTime() - startTime));
        for (int i =0; i< n+1;i++) {
            Arrays.fill(mmzArr[i],-1);
        }
        for (int i = 0; i< n+1; i++) {
            mmzArr[i][0] = 0;
        }
        for (int i = 0; i< w+1; i++) {
            mmzArr[0][i] = 0;
        }
        startTime = System.nanoTime();
        System.out.println("Memoization: Max Profit = " + knapsackTopDown(wt,val,w,n));
        System.out.println("Memoization: Time = " + (System.nanoTime() - startTime));
    }

    private static int knapsackTopDown(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0){
            return 0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if (wt[i-1] > j) {
                    mmzArr[i][j]  = mmzArr[i-1][j];
                } else {
                    mmzArr[i][j] = Math.max(val[i-1] + mmzArr[i-1][j-wt[i-1]], mmzArr[i-1][j]);
                }
            }
        }
        return mmzArr[n][w];
    }

    private static int knapsackMmz(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0){
            return 0;
        }
        if (mmzArr[n][w] != -1) {
            return mmzArr[n][w];
        }
        if (wt[n-1] > w) {
            return mmzArr[n][w] = knapsackMmz(wt,val,w,n-1);
        } else {
            return mmzArr[n][w] = (Math.max(val[n-1] + knapsackMmz(wt, val, w-wt[n-1],n-1),knapsackMmz(wt, val, w,n-1)));
        }
    }

    private static int recursive(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0){
            return 0;
        }
        if (wt[n-1] > w) {
            return knapsackMmz(wt,val,w,n-1);
        } else {
            return Math.max(val[n-1] + knapsackMmz(wt, val, w-wt[n-1],n-1),knapsackMmz(wt, val, w,n-1));
        }
    }
}
