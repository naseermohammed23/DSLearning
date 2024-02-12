package Tawheed2024.Blind75;

import java.util.HashMap;

public class ContainsDuplicate {
    
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,21}));
    }
    
    public static boolean containsDuplicate(int[] nums) {
        
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]) + 1;
                if (count < value) {
                    count = value;
                }
                map.put(nums[i], value);
            } else {
                map.put(nums[i], 1);
            }
        }

        return count > 1 ? true : false;
    }
}
