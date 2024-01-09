package July31Assignment;


/**
 * Tawheed TIPS Summer 2021
 * July, 31, 2021 - Assignment
 * 
 * Power Function -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI2ODcwNjc2/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class PowerN {
    
    public static void main(String[] args) {
        
        // Calling Brute Force Solution 
        System.out.println(powerWithBruteForce(2, -5));
        System.out.println(powerWithBruteForce(3, 5));
        System.out.println(powerWithBruteForce(4, 4));

        // Calling Recursive Solution 
        System.out.println(powerN(2, -5));
        System.out.println(powerN(3, 5));
        System.out.println(powerN(4, 4));
    }

    /**
     * Brute Force Solution for calc N to the power P. 
     * @param num
     * @param pow
     * @return
     */
    public static double powerWithBruteForce(double num, int pow) {

        double result = 1;
        int p = pow < 0 ? -pow : pow; 
        
        for (int i=0;i<p;i++) {
            result *= num;
        }

        return pow < 0 ? 1 / result : result;

    }


    /**
     * Optimized recursive solution for calc N to the power P
     * @param num
     * @param pow
     * @return
     */
    public static double powerN(double num, int pow) {

        if (pow == 0) return 1;

        if (pow < 0) {
            return 1/powerN(num, -pow);
        }

        return pow == 1 ? num : powerN(num, pow/2) * powerN(num, pow/2) * powerN(num, pow%2);

    }
}
