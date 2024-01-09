package DynamicProgramming;

public class GroupSum {
    

    public static void main(String[] args) {
        int[] nums = {4, 7, 2};
        System.out.println(groupSumDP(nums, 9));

    }


    static boolean groupSumDP(int[] ary, int target) {

        boolean[][] dp = new boolean[ary.length+1][target+1];

        for(int i=0;i<dp.length; i++) {
            dp[i][0] = false;
        }

        for(int t=0;t<dp[0].length; t++) {
            dp[0][t] = false;
        }

        for(int i=0;i<=dp.length;i++) {
            for(int t=0;t<dp[0].length;t++) {
                dp[i][t] = dp[i+1][t-ary[i]] || dp[i+1][t];
            }
        }

        for(int row=0;row<dp.length;row++) {
            for(int col=0;col<dp[0].length; col++) {
                System.out.println(dp[row][col] + " ");
            }
            System.out.println();
        }

        return dp[0][target];
    }
}
