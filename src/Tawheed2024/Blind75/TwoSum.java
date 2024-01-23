package Tawheed2024.Blind75;

import java.util.Arrays;
import java.util.PriorityQueue;

class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        
        //int[] results = twoSumRecursive1(nums, -8,0,1);

        //int[] results = twoSumWithSorted(new int[]{3,2,4}, 6);

        //System.out.println(results == null ? "No Match found" : "[ " + results[0] + " " + results[1] + " ]");

        //String recursiveResult = twoSumRecursive(nums, 4, 0, 1);

        //System.out.println(recursiveResult);

        //large inputs are failing.. 
        int[] largeNums = new int[10000];
        for (int i=0;i<10000;i++) {
            largeNums[i] = i+1;
        }
        System.out.println(largeNums.length);
        int[] recursiveResult1 = twoSumRecursive1(largeNums, 19999, 0, 1);


        System.out.println(recursiveResult1.length == 2 ? "No Match found" : "[ " + recursiveResult1[0] + " " + recursiveResult1[1] + " ]");
        

    }

    public static int[] twoSum(int[] nums, int target) {
    
        //Brute Force
        for(int i=0;i<nums.length; i++) {
            for(int j=i+1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }


    //recursive 
    public static String twoSumRecursive(int[] nums, int target, int i, int j) {

        if (i< nums.length && j< nums.length && nums[i] + nums[j] == target) {
            return i +","+j;
        }

        if (j >= nums.length) {
            i++;
            j = i;
        }

        if (i >= nums.length) {
            return "Not Found";
        }

        return twoSumRecursive(nums, target, i, ++j);

    }

     public static int[] twoSumRecursive1(int[] nums, int target, int i, int j) {

        if (i == 9997) {
            System.out.println(i + " "+ j);
        }

        if (i< nums.length && j< nums.length && nums[i] + nums[j] == target) {
            return new int[]{i,j};
        }

        if (j >= nums.length -1) {
            i++;
            j = i;
        }

        if (i >= nums.length) {
            return new int[]{};
        }

        return twoSumRecursive1(nums, target, i, ++j);

    }

    //{-1,-2,-3,-4,-5};
    public static int[] twoSumWithSorted(int[] nums, int target) {

        //sort the values in freqMap.. 
        Arrays.sort(nums);
        
        int i = 0; int j = nums.length -1;
        int sum = nums[i] + nums[j]; 

        while (sum != target) { 

                if (sum < target)
                    i++; 
                else 
                    j--;

            sum = nums[i] + nums[j];

        }

        return new int[]{i, j};
    }

}