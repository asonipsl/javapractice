package knapsack;

public class CountSubsetSum {
    private static int t[][];
    public static void main(String[] args) {
        int arr[] = {2,3,5,6,8,10};
        int sum  = 10;
        t = new int[arr.length+1][sum+1];
        for(int j =0;j<sum+1;j++) {
            t[0][j] = 0;
        }
        for(int i =0;i< arr.length+1;i++) {
            t[i][0] = 1;
        }
        System.out.println("Count of subset with sum " + sum + " = " + countsubsetSum(arr,sum));
    }

    private static int countsubsetSum(int[] arr, int sum) {
        for(int i =1;i< arr.length+1;i++) {
            for (int j =1; j<sum+1;j++) {
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] + t[i-1][j -arr[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}
