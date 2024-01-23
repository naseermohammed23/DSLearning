package Tawheed2024.Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentwords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"}; 
        //String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 2;

        List<String> result = topKFrequent(words, k);
        for (int i=0;i<result.size();i++) {
            System.out.println(result.get(i));
        }
    }
 
    
    public static List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> freqMap = new HashMap<>();

        for (int i=0;i<words.length;i++) {
            freqMap.put(words[i], freqMap.get(words[i]) == null ? 1 :  freqMap.get(words[i]) + 1);
        }

        //sort the values in freqMap.. 
        PriorityQueue<String> minHeap = new PriorityQueue<>((n1, n2) -> freqMap.get(n1) - freqMap.get(n2));

        for (String key : freqMap.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        String[] res = new String[k];
        for (int r=k-1 ; r>-1; r--) {
            res[r] = minHeap.poll();
        }        

        return Arrays.asList(res);
    }

}
