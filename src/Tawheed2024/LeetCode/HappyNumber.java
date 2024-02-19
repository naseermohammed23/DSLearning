package Tawheed2024.LeetCode;

import java.util.HashSet;

public class HappyNumber {
    

    public static void main(String[] args) {
        int n = 3;
        
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        if (n == 1) return true;

        HashSet<Integer> set = new HashSet<>();

        int sum = n;
        while(sum != 1) {
            if (sum < 10) 
                sum = sum * sum;
            else {
                sum = sumSquare(sum);
            }

            if(!set.add(sum)) {
                return false;
            }
            
        }

        return true;
    }

    public static int sumSquare(int n) {

        if (n < 10) return n*n;

        int mod = n % 10;
        int divisor = n/10;
        int sum = (mod * mod) + (divisor < 10 ? divisor * divisor : sumSquare(divisor)); 
        return sum;
    }
}
