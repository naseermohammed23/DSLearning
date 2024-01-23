package Tawheed2024.Blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
* LeetCode
* 347. Top K Frequent Elements
Medium
Topics
Companies
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */
public class TopKFrequent {

    public static void main(String[] args) {
        //int[] nums = new int[]{1,1,1,2,2,3};
        //int[] nums = new int[]{3,0,1,0};
        //int[] nums = new int[]{5,3,1,1,1,3,73,1};
        int[] nums = new int[]{4,1,-1,2,-1,2,3};

        int k = 2;

        int[] result = topKFrequent(nums, k);
        for (int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
        
    }
    
    public static int[] topKFrequent(int[] nums, int k) {

        //List<Integer> results = new ArrayList<>();

        if (nums.length == 0 || nums.length == 1 || k == 0)
            return nums;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            freqMap.put(nums[i], freqMap.get(nums[i]) == null ? 1 :  freqMap.get(nums[i]) + 1);
        }

        //sort the values in freqMap.. 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> freqMap.get(n1) - freqMap.get(n2));


        // for (int key : freqMap.keySet()){
        //     //System.out.println(key+" "+freqMap.get(key));
        //     results.add(key);
        // }

        for (int key : freqMap.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int r =0 ; r<k; r++) {
            //res[r] = results.get(r);
            res[r] = minHeap.poll();
        }        

        return res.length == 0 ? nums : res;
    }
}
