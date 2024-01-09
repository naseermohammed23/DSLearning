package July31Assignment;

/**
 * Tawheed TIPS Summer 2021
 * July, 31, 2021 - Assignment
 * 
 * Palindrome -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI2ODcwNjM2/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class Palindrome {
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar")); // --> True
        System.out.println(isPalindrome("abba")); // --> True
        System.out.println(isPalindrome("a")); // --> True
        System.out.println(isPalindrome("hello")); // --> False
        System.out.println(isPalindrome("ax")); // --> False
    }

    /**
     * return true if the given is palindrome.. 
     * @param str
     * @return
     */
    static boolean isPalindrome(String str) {

        if (str.length() <= 1) return true;

        return str.charAt(0) != str.charAt(str.length()-1) ? false : isPalindrome(str.substring(1, str.length()-1));
    }
}
