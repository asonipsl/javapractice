package knapsack;

import java.util.Vector;

public class MinSubsetSumDiff {

    private static boolean t[][];

    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        System.out.println("Minimum Subset Sum Diff = " + minSubsetSumDiff(arr));
    }

    private static int minSubsetSumDiff(int[] arr) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i =0;i<arr.length;i++) {
            sum = sum + arr[i];
        }
        if(sum%2 == 0) {
            return 0;
        } else {
            t = new boolean[arr.length+1][sum+1];
            for(int j = 0;j<sum+1;j++) {
                t[0][j] = false;
            }
            for(int i = 0;i< arr.length+1;i++) {
                t[i][0] = true;
            }
            subsetSumDiff(arr,sum);
            Vector<Integer> minVec = new Vector<Integer>();
            for (int i =1;i<sum+1/2;i++) {

                if (t[arr.length][i]) {
                    System.out.print("v["+i+"], ");
                    minVec.add(i);
                }
            }
            System.out.println("Range = " + sum);
            for (int chkRng =0;chkRng < minVec.size()/2;chkRng++){
                System.out.println("Min = " + min + ", vec = " + minVec.get(chkRng) + ", Range-2*val = " + (sum - 2*minVec.get(chkRng)));
                min = Math.min(min, sum-2*minVec.get(chkRng));
            }
            return min;
        }
    }

    private static void subsetSumDiff(int[] arr, int sum) {
        for(int i = 1;i< arr.length+1;i++) {
            for (int j = 0; j < sum+1; j++) {
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] || t[i-1][j - arr[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }
}
