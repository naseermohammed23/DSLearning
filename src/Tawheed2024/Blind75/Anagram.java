package Tawheed2024.Blind75;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

public class Anagram {
   
    public static void main(String[] args) {
        
        String source = "anagram";
        String target = "nagaram";

        System.out.println(isValidAnagram(source, target) ? "Valid Anagram" : "Invalid Anagram");

        System.out.println(isAnagramFreqCount(source, target) ? "Valid Anagram" : "Invalid Anagram");

    }

    // can be done in multiple ways, we are using bucket sorting. 
    public static boolean isValidAnagram(String source, String target) {

        // check if lenghts are not same then return false
        // 

        if (source.length() != target.length())
            return false; 

        char[] s = source.toCharArray();    
        char[] t = target.toCharArray();

        bucketSort(s);
        bucketSort(t); 

        for (int i=0;i<s.length;i++) {
            if (s[i] != t[i])
                return false;
        }

        return true;

    }

    static void bucketSort(char[] ary) {
        int[] alphaBuckets = new int[26];
        for(int i=0;i<ary.length; i++) {
            char ch = ary[i];
            alphaBuckets[ch - 'a']++;
        }

        int k=0;
        for(int i=0;i<alphaBuckets.length;i++) {
            int val = alphaBuckets[i];
            for(int j=0;j<val; j++) {
                ary[k++] = (char) (i + 'a');
            }
        }

    }


    /*
     * Optimize 2 using Freq count/map
     * for each char seen in S increment freq map at char position
     * for each char seen in S increment freq map at char position
     * 
     * if freq in freqCount is not zero return false
     * 
     * last return true. 
     */
     public static boolean isAnagramFreqCount(String s, String t){
        if (s.length() != t.length())
            return false; 

        
            int[] freqCount = new int[26]; //lower case english chars 
            for (int i=0; i<s.length(); i++) {
                char chs = s.charAt(i);
                char cht = t.charAt(i);
                freqCount[chs - 'a']++; // eg chs is 'b' the chs minus 'a' => 98 minus 97 => 1
                freqCount[cht - 'a']++; // eg chs is 'z' the chs minus 'a' => 122 minus 97 => 25            

            }

            for (int freq : freqCount) {
                if (freq != 0)
                    return false;
            }

            return true;
     }
    
}
