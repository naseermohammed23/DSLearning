package DynamicProgramming;

public class FibMemoization {

    public static void main(String[] args) {

        System.out.println(" Fibonacci : input : "+ 2 +" Output :" + fibonacci(2));

        System.out.println(" Fibonacci : input : "+ 9 +" Output :" + fibonacci(9));
    }

    public static int fibonacci(int num) {

        int[] memo = new int[num + 1];

        return fibonacci(num, memo);
    }

    // using DP Memoization technique. 
    private static int fibonacci(int num, int[] memo) {
        
        if (num <= 1) { 
            return num;
        }

        if (memo[num] == 0) {
            memo[num] = fibonacci(num - 1) + fibonacci(num - 2);
        }

        return memo[num];
    }

    
}
