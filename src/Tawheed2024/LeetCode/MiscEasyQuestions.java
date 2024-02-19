package Tawheed2024.LeetCode;

import java.util.HashMap;

public class MiscEasyQuestions {
 
    public static void main(String[] args) {
        //String s = "iaozzbyqzwbpurzze";
        //int k = 2;
        //System.out.println(getLucky(s, k));    

        System.out.println(countEven(1000));
    }

    //1945. Sum of Digits of String After Convert
    //https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/
    public static int getLucky(String s, int k) {
        char ch = ' ';
        int sum = 0, charVal =0;
        for (int i=0;i<s.length();i++) {
            ch = s.charAt(i);
            charVal = ch - 'a' + 1;
            if (charVal > 9) {
                sum = sum + (charVal % 10) + (charVal / 10);
            } else {
                sum = sum + charVal;
            }
        }

        // for(char c: str.toCharArray()) {
        //     sum+= Integer.parseInt(String.valueOf(c));
        // }

        System.out.println(sum);

        k--;

        for (int i=0;i<k;i++) {
            int temp = sum;
            sum = 0;
            while (temp >= 10) {
                sum = sum + temp % 10;
                temp = temp/10;
            }
            sum = sum + temp;
        }
        
        return sum;
    }

    //2180. Count Integers With Even Digit Sum
    //https://leetcode.com/problems/count-integers-with-even-digit-sum/submissions/1179426394
    public static int countEven(int num) {
        
        int count = 0;
        for (int i=1;i<=num;i++) {
            if (sumDigits(i)%2 == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        return count;
    }

    // to find the sum of digit of a given number 
    // eg: 12 -> 3 ;  45 -> 9 ;  123 -> 6
    public static int sumDigits(int num) {
       return num % 10 + (num/10 > 9 ? sumDigits(num/10) : num/10);
    }


    //https://leetcode.com/problems/palindrome-number/submissions/1179456445
    public static boolean isPalindrome(int x) {
        
        String s = String.valueOf(x);

        int i=0, j=s.length()-1;

        while (i != j && i <= j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;

    }

    //https://leetcode.com/problems/roman-to-integer/submissions/1179517209
    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int i = s.length() - 1;
        int num = 0;
        int sum = 0;
        int pnum = Integer.MAX_VALUE;
        while (i >= 0) {
            num = map.get(s.charAt(i));
            pnum = i != 0 ? map.get(s.charAt(i-1)) : Integer.MAX_VALUE;
            if (pnum < num) {
                num = num - pnum;
                i = i-2;
            } else {
                i--;
            }
            sum = sum + num;
            pnum = Integer.MAX_VALUE;
        }
        return sum;
    }

    


}
