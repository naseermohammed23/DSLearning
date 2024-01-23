package Tawheed2024.Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    public static void main(String[] args) {
            ThreeSum obj = new ThreeSum();
    
            obj.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    //{-1,0,1,2,-1,-4}
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sorted array = {-4,-1,-1,0,1,2}
        
        for(int i=0;i<nums.length-2;i++) {
            while (i > 0 && i< nums.length && nums[i-1] == nums[i]) {
                i++;
            }
            twoSumUsingTwoPointers(i,nums, result);
        }
        
        
        return result;
        
    }


    void twoSumUsingTwoPointers(int i, int[] nums, List<List<Integer>> result) {
        int low = i+1; int high = nums.length-1;

        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum == 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[low]);
                list.add(nums[high]);
                result.add(list);
                low++; // we found one solution so now move forward 
                high--;
                while (low<high && nums[low-1] == nums[low]) { // avoid duplicate result
                    low++;
                }

            } else if (sum < 0) {
                low++;
            } else { // sum > 0
                high--;
            }
        }

    }
}
 // end of outer while loop