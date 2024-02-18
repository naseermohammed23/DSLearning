package Tawheed2024.Blind75;

public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{8,-19,5,-4,20}));
    }

    public static int maxSubArray(int[] nums) {
        
        //if (nums.length == 0) return 0;

        //if (nums.length == 1) return nums[0];

       int largestSum = Integer.MIN_VALUE;

        int currSum = 0;
        for (int i=0;i<nums.length;i++) {
            currSum += nums[i];

            if (currSum > largestSum) {
                largestSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        
        return largestSum;
    }
    
}
