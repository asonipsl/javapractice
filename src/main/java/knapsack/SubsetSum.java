package knapsack;

public class SubsetSum {
    static boolean t[][];
    public static void main(String[] args) {
        int arr[] = {2,3,7,8,10};
        int sum = 22;
        t = new boolean[arr.length+1][sum+1];
        for(int s=1;s<sum+1;s++) {
            t[0][s] = false;
        }
        for (int n=0;n<arr.length +1;n++) {
            t[n][0] = true;
        }

        long startTime = System.nanoTime();
        System.out.println("Subset Sum Exists: " + subsetSum(arr,sum,arr.length));
        long endTime = System.nanoTime();
        System.out.println("Total Time: " + (endTime - startTime));
    }

    private static boolean subsetSum(int[] arr, int sum, int length) {
        for (int i = 1; i < length+1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i-1][j - arr[i - 1]] || t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[length][sum];
    }
}
