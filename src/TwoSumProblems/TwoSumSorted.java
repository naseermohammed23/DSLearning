package TwoSumProblems;

/**
 * Tawheed TIPS Summer 2021
 * July, 17, 2021 - Assignment
 * 
 * Two Sum Sorted -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/MzcyODQwNjQxMzEx/details
 * 
 * @author Naseer Mohammed Abdul 
 */

public class TwoSumSorted {

    public static void main(String args[]) {

        int[] sortedArray = { 3, 5, 6, 7 };
        

        System.out.println("***Evaluating Brute force Solution*****");
        twoSumSorted(sortedArray, 11);
        twoSumSorted(sortedArray, 13);
        twoSumSorted(sortedArray, 8);
        twoSumSorted(sortedArray, 9);
        twoSumSorted(new int[]{  }, 11);
        twoSumSorted(new int[]{ 7 }, 7);



        System.out.println("***Evaluating Optimized Solution*****");

        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimized(new int[]{ 3, 5, 6, 7 }, 11));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimized(new int[]{ 3, 5, 6, 7 }, 13));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimized(new int[]{ 3, 5, 6, 7 }, 8));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimized(new int[]{ 3, 5, 6, 7 }, 9));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimized(new int[]{  }, 11));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimized(new int[]{ 7 }, 7));

        System.out.println("***Evaluating Optimized Solution With Indices*****");
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimizedWithIndices(new int[]{ 3, 5, 6, 7 }, 11));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimizedWithIndices(new int[]{ 3, 5, 6, 7 }, 13));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimizedWithIndices(new int[]{ 3, 5, 6, 7 }, 8));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimizedWithIndices(new int[]{ 3, 5, 6, 7 }, 9));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimizedWithIndices(new int[]{  }, 11));
        System.out.println("Pair of Integers exists in the Array - " + twoSumSortedOptimizedWithIndices(new int[]{ 7 }, 7));
    }

    /**
     * Given a Sorted Array, write a Brute force solution. Find pair of ints whose sum is equal to target
     * Time Complexity - O(n^2)
     * Space Complexity - 
     * 
     * @param sortedArray
     * @param target
     */
    public static void twoSumSorted(int[] sortedArray, int target) {

        boolean found = false;

        for(int item=0; item < sortedArray.length -1; item++) {
            for (int jItem=item+1; jItem <= sortedArray.length -1; jItem++) {
                found = sortedArray[item] + sortedArray[jItem] == target;
                if (found) {
                    System.out.println("Pair of Integers Indices - " + item +","+ jItem);
                    break;
                }
            }
            if (found) break;
        }
    }

    /**
     * Given a Sorted Array, write a Optimized solution. Find pair of ints whose sum is equal to target
     * Time Complexity - O(nlogn)
     * Space Complexity - O(n)
     * 
     * @param sortedArray
     * @param target
     */
    public static boolean twoSumSortedOptimized(int[] sortedArray, int target) {

        boolean found = false;
        
        if (sortedArray.length == 0) return false;
        
        int startIdx = 0;
        int endIdx = sortedArray.length -1;

        while (!found) {
            if (startIdx == endIdx) {
                found = target == 0;
                break;
            }

            if (sortedArray[startIdx] + sortedArray[endIdx] == target) {
                found = true;
                break;
            }

           if (sortedArray[startIdx] + sortedArray[endIdx] < target) {
                startIdx ++;
           } else {
                endIdx--;
           }
        }

        return found;
    }

    /**
     * Given a Sorted Array, write a Optimized solution. Find pair of ints whose sum is equal to target & return its indices.
     * Time Complexity - O(nlogn)
     * Space Complexity - O(n)
     * 
     * @param sortedArray
     * @param target
     */
    public static String twoSumSortedOptimizedWithIndices(int[] sortedArray, int target) {

        boolean found = false;
        
        if (sortedArray.length == 0) return "";
        
        int startIdx = 0;
        int endIdx = sortedArray.length -1;

        while (!found) {
            if (startIdx == endIdx) {
                found = target == 0;
                break;
            }

            if (sortedArray[startIdx] + sortedArray[endIdx] == target) {
                found = true;
                break;
            }

           if (sortedArray[startIdx] + sortedArray[endIdx] < target) {
                startIdx ++;
           } else {
                endIdx--;
           }
        }

        return found ? startIdx + "," + endIdx : "";
    }



    //recursive methods below.. 
    

    /**
     * Given a Sorted Array, write Optimized solution with Recursion. Find pair of ints whose sum is equal to target
     * 
     * @param sortedArray
     * @param target
     */
    public static void twoSumSortedOptimizedWithRecursion(int[] sortedArray, int target) {

        System.out.println("Pair of Integers exists in the Array - "
                + isTwoSumExists(0, sortedArray, target, sortedArray.length - 1));

        System.out.println(
                "Pair of Integers Indices - " + getTwoSumIndices(0, sortedArray, target, sortedArray.length - 1));
    }

    /**
     * Given a Sorted Array, find pair of ints whose sum is equal to target ->
     * return true otherwise false.
     * 
     * @param startIdx
     * @param sortedArray
     * @param target
     * @param endIdx
     * @return true if pair of integers exits who sum is target otherwise false. 
     */
    private static boolean isTwoSumExists(int startIdx, int[] sortedArray, int target, int endIdx) {

        if (startIdx == endIdx)
            return target == 0;

        if (sortedArray[startIdx] + sortedArray[endIdx] == target)
            return true;

        return sortedArray[startIdx] + sortedArray[endIdx] < target
                ? isTwoSumExists(startIdx + 1, sortedArray, target, endIdx)
                : isTwoSumExists(startIdx, sortedArray, target, endIdx - 1);
    }

    /**
     * Given a Sorted Array, find pair of ints whose sum is equal to target & return
     * its indices.
     * 
     * @param startIdx
     * @param sortedArray
     * @param target
     * @param endIdx
     * @return
     */
    private static String getTwoSumIndices(int startIdx, int[] sortedArray, int target, int endIdx) {

        if (startIdx == endIdx)
            return "";

        if (sortedArray[startIdx] + sortedArray[endIdx] == target) {

            return startIdx + "," + endIdx;
        }

        return sortedArray[startIdx] + sortedArray[endIdx] < target
                ? getTwoSumIndices(startIdx + 1, sortedArray, target, endIdx)
                : getTwoSumIndices(startIdx, sortedArray, target, endIdx - 1);
    }

}