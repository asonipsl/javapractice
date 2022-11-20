package knapsack;

public class EqualSumPartition {
    private static boolean t[][];
    public static void main(String[] args) {
        int arr[] = {1,5,6,2,4,11,5};
        System.out.println("Equal Subset sum exists: " + equalSubsetSum(arr));
    }

    private static boolean equalSubsetSum(int arr[]) {
        int sum = 0;
        for(int s: arr) {
            sum += s;
        }
        if(sum%2 == 0) {
            t = new boolean[arr.length+1][sum+1];
            for(int i=0;i<arr.length+1;i++) {
                t[i][0] = false;
            }
            for(int j=0;j<sum+1;j++) {
                t[0][j] = true;
            }
            return subsetSum(arr,sum/2);
        } else {
            return false;
        }
    }

    private static boolean subsetSum(int arr[], int sum) {
     for (int i = 1; i<arr.length +1; i++) {
         for (int j = 1;j < sum+1; j++) {
             if(arr[i-1] <= j ) {
                 t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
             } else {
                 t[i][j] = t[i-1][j];
             }
         }
     }
     return t[arr.length][sum];
    }
}
