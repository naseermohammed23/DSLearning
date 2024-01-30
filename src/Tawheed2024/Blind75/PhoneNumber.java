package Tawheed2024.Blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    static Map<Character, String> map = new HashMap<>();
    static {
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "");
    }

    public static void main(String[] args) {
        PhoneNumber p = new PhoneNumber();

        String digits = "";//"23";
        
        List<String> result = p.letterCombinations(digits);
        for(String r : result) {
            System.out.println(r);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        StringBuilder resultStr = new StringBuilder();

        return letterCombinations(digits, resultStr, 0, new ArrayList<>());
        
    }

    private List<String> letterCombinations(String digits, StringBuilder resultStr, int idx, List<String> result) {
        

        if (idx >= digits.length()) {
            //System.out.println(resultStr.toString());
            if (!resultStr.toString().isEmpty())
                result.add(resultStr.toString());
            return result;
        }

        String chars = map.get(digits.charAt(idx));
        for(int i=0;i<chars.length();i++) {
            resultStr.append(chars.charAt(i));
            letterCombinations(digits, resultStr, idx+1, result);
            //backtracking 
            resultStr.deleteCharAt(idx);
        }

        return result;
    }

}
