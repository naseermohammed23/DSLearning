package Tawheed2024.Blind75;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9, 0));
    }
    

    public static int search(int[] nums, int target) {

        //for (int i=0;i<nums.length;i++) {
           // if (nums[i] == target) return i;
        //}

        //return -1;
        
        return search(nums, target, 0);
    }

    private static int search(int[] nums, int target, int idx) {
        
        if (nums.length - 1 == idx) return -1;

        return nums[idx] == target ? idx : search(nums, target, idx+1);
    }
}
