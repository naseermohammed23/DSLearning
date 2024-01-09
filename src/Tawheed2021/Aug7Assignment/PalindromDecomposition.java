package Aug7Assignment;

import java.util.HashSet;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * Palindrom Decomposition solution -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI2ODcwOTA4/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class PalindromDecomposition {
    

    public static void main(String[] args) {

        palindromDecomposition("abracadabra");
        
    }

    /**
     * 
     * @param str
     */
    static void palindromDecomposition(String str) {

        HashSet<String> resultSet = new HashSet<>();
        for (int i=0;i<str.length();i++) {
            String result = "";
            resultSet.add(PalindromDecomposition_Helper(str, result, i+1));
        }

        System.out.println(resultSet.toString());

    }

    /**
     * Recursive call to get the palindrome decomposition.. 
     * @param str
     * @param result
     * @param num
     * @return
     */
    static String PalindromDecomposition_Helper(String str, String result, int num) {

        if (str.isEmpty()) return result;

        if (str.length() == 1) {
            result += "|"+str;
            str = "";
            return result;
        }
  
        if (str.length() >= num && isPalindrome(str.substring(0, num))) {
            result += "|"+str.substring(0, num);            

            str = str.substring(1, str.length());
        } else {
            result += "|"+str.charAt(0);
            str = str.substring(1, str.length());
        }

        

        return PalindromDecomposition_Helper(str, result, num);
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
