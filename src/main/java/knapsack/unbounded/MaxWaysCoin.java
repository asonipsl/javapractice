package knapsack.unbounded;

public class MaxWaysCoin {
    /*
    The ask is to get the number of possible combinations of coins in which you can reach up to a given sum.
    The same coin can be included multiple time.
     */
    private static int t[][];

    public static void main(String[] args) {
        int coins[] = {1,2,3};
        int sum = 5;

        t = new int[coins.length+1][sum+1];
        // Here N -> number of possible elements available for selection not the actual number of elements in array.

        for(int s=0;s<sum+1;s++) {
            t[0][s] = 0;
        }
        for (int i = 0; i < coins.length+1; i++) {
            t[i][0] = 1;
        }
        System.out.println("Max ways = " + subsetsum(coins,sum));
    }

    private static int subsetsum(int[] coins, int sum) {
        for (int i = 1; i < coins.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (coins[i-1] <= j) {
                    t[i][j] = t[i-1][j] + t[i][j - coins[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][sum];
    }

}
