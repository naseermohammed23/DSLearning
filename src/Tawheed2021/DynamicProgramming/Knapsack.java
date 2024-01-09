package DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
    

    public static void main(String[] args) {
        //int val[] = {60, 100, 120};
        //int wt[] = {20, 10, 30};
        //int weight = 30;

        int val[] = {50, 10, 20};
        int wt[] = {2, 5, 3};
        int weight = 5;

        System.out.println("Knapsack :  " + knapsack_helper(val, wt, weight));
        System.out.println("Knapsack DP :  " + knapsackDP(val, wt, weight));
    }

    private static int knapsack_helper(int[] val, int[] wt, int weight) {
        return knapsack(val, wt, wt.length, weight);
    }


    // solving with recursion.. 
    private static int knapsack(int[] val, int[] wt, int i, int weight) {
        
        if (i == 0) { //finished processing the array
            return 0;
        }

        if (weight == 0) { // max weight reached.. 
            return 0;
        }


        // return the max of 2 cases select / dont select
        if (wt[i-1] > weight) {
            return knapsack(val, wt, i-1, weight);
        } else  {
            return Math.max((val[i-1] + knapsack(val, wt, i-1, weight-wt[i-1])), knapsack(val, wt, i-1, weight));
        }

        // T = O(2^n)

    }

    // solving using DP ..
    private static int knapsackDP(int[] val, int[] wt, int weight) { 
        
        int[][] dp = new int[wt.length+1][weight+1];

        for(int i=0;i<dp.length;i++) {
            dp[i][0] = 0; //base condition
        }

        for(int w=0;w<dp[0].length;w++) {
            dp[0][w] = 0; //base condition
        }

        for(int i=1;i<dp.length;i++) {
            for(int w=1;w<dp[0].length;w++) {
                if (wt[i-1] > w) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = Math.max(val[i-1] + dp[i-1][w-wt[i-1]], dp[i-1][w]);
                   
                }
            }
        }

        for(int[] ary : dp) {
            System.out.println(Arrays.toString(ary));
        }

        return dp[wt.length][weight];

    }


}
