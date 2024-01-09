package sorting;

import java.util.Arrays;

public class MergeSort {
    
    
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,8,4,5,7};
        System.out.println(" before sort : " + Arrays.toString(nums));
    
        mergeSort(nums);
    
        System.out.println(" after sort : " + Arrays.toString(nums));
            
    }

    private static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length);
    }

    private static void mergeSort(int[] nums, int start, int end) {


        if (start < end) {

            int mid = (start + end) / 2;
            mergeSort(nums, 0, mid);
            mergeSort(nums, mid+1, end);

            merge(nums, start, mid, end);

        
        }


    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] leftArray = new int[mid-1-start];
        int[] rightArray = new int[end-mid];

        // copy the sorted to temp array and then merge the results in original array. 
        for (int i=0;i<leftArray.length; i++) {
            leftArray[i] = nums[mid+1+i];
        }

        for (int i=0;i<rightArray.length; i++) {
            rightArray[i] = nums[mid+1+i];
        }

        int leftIdx = 0;
        int rightIdx = 0;

        while (leftIdx < leftArray.length && rightIdx < rightArray.length) {
            if (leftArray[leftIdx] <= rightArray[rightIdx]) {
                nums[start] = leftArray[leftIdx];
                start++;
                leftIdx++;
            } else {
                nums[start] = rightArray[rightIdx];
                start++;
                rightIdx++;
            }
        }

        //Copy from left Array.. 
        while (leftIdx < leftArray.length) {
            nums[start] = leftArray[leftIdx];
            start++;
            leftIdx++;            
        }


        //Copy from right Array.. 
        while (rightIdx < rightArray.length) {
            nums[start] = rightArray[rightIdx];
            start++;
            rightIdx++;            
        }

    }

    




}
