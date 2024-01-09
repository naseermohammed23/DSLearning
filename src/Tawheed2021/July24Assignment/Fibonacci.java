package July24Assignment;


/**
 * Tawheed TIPS Summer 2021
 * July, 24, 2021 - Assignment
 * 
 * Fibonacci -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/MzczNDMwNTExMjM1/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class Fibonacci {

    public static void main(String[] args) {

        System.out.println(" Fibonacci : input : "+ 2 +" Output :" + fibonacci(2));

        System.out.println(" Fibonacci : input : "+ 9 +" Output :" + fibonacci(9));
    }


    /**
     * Return Fibonacci number for given input. 
     * @param num - Given Input
     * @return output fibonacci number.
     */
    public static int fibonacci(int num) {

        //Time Complexity = O([Number of Branches to the power] of [depth of a tree]) = O(2^n)
        // Space Complexity = O(n)
        // if num is 10 then the T.C = O(2 ^ 10), S.C = O(10)

        return num <= 1 ? num : fibonacci(num -1) + fibonacci(num - 2);
    }
    
}
