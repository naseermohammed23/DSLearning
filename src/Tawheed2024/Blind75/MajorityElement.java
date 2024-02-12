package Tawheed2024.Blind75;

import java.util.HashMap;

public class MajorityElement {
    
    public static int majorityElement(int[] nums) {
        
        int majorityElement = -1;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]) + 1;
                if (count < value) {
                    count = value;
                    majorityElement = nums[i];
                }
                map.put(nums[i], value);
            } else {
                map.put(nums[i], 1);
            }
        }

        return count >= (nums.length / 2) ? majorityElement : null;

    }
}
