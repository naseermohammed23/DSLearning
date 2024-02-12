package Tawheed2024.Blind75;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
    
    public static int longestPalindrome(String s) {

        if (s == null) 
            return 0;

        if (s.length() <= 1)
            return s.length();

        int[] alpha = new int[26];

        for (int i=0;i<s.length();i++) {
            alpha[s.charAt(i) - 'a']++;
        }

        int pLength = 0;

        for(int i=0;i<alpha.length;i++) {
            if (alpha[i] != 0 && alpha[i] != 1) {
                pLength = pLength + alpha[i];
            }
        }

        return s.length() - pLength == 0 ? pLength : 1+pLength;

    }
}
