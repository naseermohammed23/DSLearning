package TwoSumProblems;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Tawheed TIPS Summer 2021
 * July, 17, 2021 - Assignment
 * 
 * Two Sum UnSorted -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/MzcyODQwNjQxMjk1/details
 * 
 * @author Naseer Mohammed Abdul 
 */

public class TwoSumUnSorted {

    public static void main(String args[]) {

        System.out.println("***Evaluating Brute Force Solution With Indices*****");
        twoSumUnSortedBruteForce(new int[]{ 7, 5, 6, 3 }, 11);
        twoSumUnSortedBruteForce(new int[]{ 7, 5, 6, 3 }, 13);
        twoSumUnSortedBruteForce(new int[]{ 7, 5, 6, 3 }, 8);
        twoSumUnSortedBruteForce(new int[]{ 7, 5, 6, 3 }, 9);
        twoSumUnSortedBruteForce(new int[]{  }, 11);
        twoSumUnSortedBruteForce(new int[]{ 7 }, 7);

        System.out.println("***Evaluating Optimized Solution With Values*****");
        twoSumUnSortedOptimized(new int[]{ 7, 5, 6, 3 }, 11);
        twoSumUnSortedOptimized(new int[]{ 7, 5, 6, 3 }, 13);
        twoSumUnSortedOptimized(new int[]{ 7, 5, 6, 3 }, 8);
        twoSumUnSortedOptimized(new int[]{ 7, 5, 6, 3 }, 9);
        twoSumUnSortedOptimized(new int[]{  }, 11);
        twoSumUnSortedOptimized(new int[]{ 7 }, 7);

        System.out.println("***Evaluating Optimized Solution With Indices*****");
        twoSumUnSortedOptimizedWithIndices(new int[]{ 7, 5, 6, 3 }, 11);
        twoSumUnSortedOptimizedWithIndices(new int[]{ 7, 5, 6, 3 }, 13);
        twoSumUnSortedOptimizedWithIndices(new int[]{ 7, 5, 6, 3 }, 8);
        twoSumUnSortedOptimizedWithIndices(new int[]{ 7, 5, 6, 3 }, 9);
        twoSumUnSortedOptimizedWithIndices(new int[]{  }, 11);
        twoSumUnSortedOptimizedWithIndices(new int[]{ 7 }, 7);



        
    }

    /**
     * Given a UnSorted Array, write a Brute force solution. Find pair of ints whose sum is equal to target
     * Time Complexity - O(n^2)
     * Space Complexity - O(n^2)
     * 
     * @param sortedArray
     * @param target
     */
    public static void twoSumUnSortedBruteForce(int[] unSortedArray, int target) {
        boolean found = false;

        for(int item=0; item < unSortedArray.length -1; item++) {
            for (int jItem=item+1; jItem <= unSortedArray.length -1; jItem++) {
                found = unSortedArray[item] + unSortedArray[jItem] == target;
                if (found) {
                    System.out.println("Pair of Integers Indices - " + item +","+ jItem);
                    break;
                }
            }
            if (found) break;
        }
    }

    /**
     * Given a UnSorted Array, write a Optimized solution. Find pair of ints whose sum is equal to target & print values 
     * Using HashSet
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * 
     * @param sortedArray
     * @param target
     */
    public static void twoSumUnSortedOptimized(int[] unSortedArray, int target) {

        // {7, 5, 6, 3} target = 8
        
        
        if (unSortedArray.length == 0) {
            System.out.println(" value = None");
        }
        
        Set<Integer> temp = new HashSet<>();

        for (int i=0;i<=unSortedArray.length-1;i++) {
            if (temp.contains(target - unSortedArray[i])) {                
                System.out.println(" value = " + unSortedArray[i] + "," + (target-unSortedArray[i]));
            } else {
                temp.add(unSortedArray[i]);
            }            
        }
    }


    /**
     * Given a UnSorted Array, write a Optimized solution. Find pair of ints whose sum is equal to target & print indices 
     * Using HashMap
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * 
     * @param sortedArray
     * @param target
     */
    public static void twoSumUnSortedOptimizedWithIndices(int[] unSortedArray, int target) {

        // {7, 5, 6, 3} target = 8
        
        
        if (unSortedArray.length == 0) {
            System.out.println(" indices = None");
        }
        
        Map<Integer, Integer> temp = new HashMap<>();

        for (int i=0;i<=unSortedArray.length-1;i++) {
            if (temp.containsKey(target - unSortedArray[i])) {                
                System.out.println(" indices = " + temp.get(target-unSortedArray[i]) + "," + i);
            } else {
                temp.put(unSortedArray[i], i);
            }            
        }
    }

}