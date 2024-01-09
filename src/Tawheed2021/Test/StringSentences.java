package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Class Test question - please take a look, this code is not working for all the scenario's. 
public class StringSentences {
    

    public static void main(String[] args) {
        

        String inputStr = "catsanddog";
        Map<String, String> wordDict = new HashMap<>();
        
        wordDict.put("cat", "cat");
        wordDict.put("cats", "cats");
        wordDict.put("and", "and");
        wordDict.put("sand", "sand");
        wordDict.put("dog", "dog");
        

        List<String> sentences = makeSentences(inputStr, wordDict);

        System.out.println(sentences.toString());
    }

    private static List<String> makeSentences(String inputStr, Map<String, String> wordDict) {
        int start = 0;
        int end = 0; 
        String outputStr = "";
        List<String> outputStrArray = new ArrayList<>();
        
        while (wordDict.size() > 0) {
            outputStr +=  sentencesHelper(inputStr, wordDict, start, end, "");
            outputStrArray.add(outputStr);
            System.out.println(outputStr);
            outputStr = "";
        }


        return outputStrArray;
    }

    private static String sentencesHelper(String inputStr, Map<String, String> wordDict, int start, int end, String temp) {

        while (end <= inputStr.length()) {
            temp = inputStr.substring(start, end);
            if (wordDict.containsKey(temp)) {
                start = end;
                wordDict.remove(temp);
                break;
            }

            end++;
        }
        if (end > inputStr.length()) {
            return temp;
        }
        
        return temp + " " + sentencesHelper(inputStr, wordDict, start, end, temp);


    }
}
