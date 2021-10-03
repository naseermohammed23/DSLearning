package DynamicProgramming;


// using DP Iterative with Variables. 
public class FibIterativeWithVariables {
    
    public static void main(String[] args) {
        System.out.println(" Fibonacci : input : "+ 2 +" Output :" + fibonacci(2));

        System.out.println(" Fibonacci : input : "+ 9 +" Output :" + fibonacci(9));
    }

    public static int fibonacci(int num) {

        int curr = 0;
        int prev1 = 0;
        int prev2 = 1;

        for (int i=2; i<=num; i++) {
             curr = prev1 + prev2;
             prev1 = prev2;
             prev2 = curr;
        }

        return curr;
        
    }
}
