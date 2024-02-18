package Tawheed2024.Blind75;

import java.util.HashSet;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        String str = "";
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for (int i=0;i<s.length();i++) {
            
            if (set.add(s.charAt(i))) {
                str += s.charAt(i);
            } else {
                len = str.length() > len ? str.length() : len;
                str = ""+s.charAt(i);
                set.clear();
            }
        }

        return len;
    }
    
}
