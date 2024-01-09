package DynamicProgramming;


// this uses DP - Iterative Approach. 
// Iterative has 2 ways, 1. Mechanical and 2. functional 

// this problem is uses DP Iterative Mechanical Approach.. 
public class FibIterativeMechanical {
    
    public static void main(String[] args) {
        System.out.println(" Fibonacci : input : "+ 2 +" Output :" + fibonacci(2));

        System.out.println(" Fibonacci : input : "+ 9 +" Output :" + fibonacci(9));
    }

    public static int fibonacci(int num) {

        int[] dp = new int[num + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=num; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[dp.length-1];
        
    }
}
