package ClassworkAssignment;

import java.util.HashMap;
import java.util.Map;

/**
 * Tawheed TIPS Summer 2021
 * July, 31, 2021 - Assignment
 * 
 * Wild-Card -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI2ODcwNzcw/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class PhoneNumber {
    
    static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
    }
    
    public static void main(String[] args) {
        int[] num = {2,3,5};
        printCharForNumber(num, "", 0);

        int[] num1 = {};
        printCharForNumber(num1, "", 0);

        int[] num2 = {1,0,1};
        printCharForNumber(num2, "", 0);
    }

    /**
     * Helper function to get string for a given number.
     * @param num
     * @return
     */
    static String getStringForNumber(int num) {
        return map.get(num);
    }


    /**
     * Print Letter combination of given phone number.. 
     * refer to the phone pad with numbers and letters combination. 
     * 
     * @param num
     * @param result
     * @param idx
     */
    static void printCharForNumber(int[] num, String result, int idx) {

        if (idx == num.length) {
            System.out.println(result);
            return;
        }

        String chars = getStringForNumber(num[idx]);
        for(int c=0;c<chars.length();c++) {
            result += chars.charAt(c);
            printCharForNumber(num, result, idx+1);
            result = result.substring(0, idx);
        }

        return;
    }

}
