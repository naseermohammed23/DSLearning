

public class Recursion2 {


    public static void main(String[] args) {

        //int[] nums = {4, 7, 2};
        //System.out.println(groupSum(0, nums, 9));

        //int[] nums6 = {1, 6, 2, 6, 5};
        //System.out.println(groupSum6(0, nums6, 16));

        //int[] nums1 = {1,3,4, 5,6};
        //System.out.println(findTargetSum(nums1, 9));

        //int[] nums1 = {5};
        //System.out.println(findSum(0, nums1, 11, nums1.length-1));

        //int[] nums7 = {2, 5, 10, 4};
        //System.out.println(groupNoAdj(0, nums7, 12));

        int[] nums8 = {1};
        System.out.println(groupSum5(0, nums8, 1));
    }

    public static boolean groupSum5(int start, int[] nums, int target) {
  
        if(target < 0) return false;
        
        if (start >= nums.length) return target == 0;
        
        if((nums[start] % 5) == 0) target = target - nums[start];
        
        if(groupSum5(start+1, nums, target)) return true;
        
        if(groupSum5(start+1, nums, (nums[start]%5) != 0 ? ((nums.length > 1 && nums[start] == 1 && nums[start-1] == 5) ? target : target - nums[start]) : target)) return true;
        
        return false;
        
      }

    public static boolean groupNoAdj(int start, int[] nums, int target) {
        if(target < 0) return false;
        
        if(start >= nums.length) return (target == 0);

        System.out.println(start + "  " + "{2, 5, 10, 4}" + "  " + target);
  
        if (groupNoAdj(start+2, nums, target-nums[start])) return true;

        if (groupNoAdj(start+1, nums, target)) return true;
        
        return false;
    }
    


    //find some of ints whose sum is equal to target. 
    public static boolean findSum(int start, int[] nums, int target, int end) {

        if(start == end) return target == 0;

        if(nums[start] + nums[end] == target) return true;

        return nums[start] + nums[end] < target ? findSum(start+1, nums, target, end) : findSum(start, nums, target, end + 1);

    }

    public static boolean groupSum6(int start, int[] nums, int target) {

        if(target < 0) return false;
        
        if(start == nums.length) return (target == 0);

        if(nums[start] == 6) target = target-nums[start];

        System.out.println(start + "  " + "{1, 6, 2, 6, 5}" + "  " + target);
  
        if (groupSum6(start+1, nums, target)) return true;

        if (groupSum6(start+1, nums, nums[start] != 6 ? target-nums[start] :  target)) return true;
        
        return false;
    }
    


    public static boolean groupSum(int start, int[] nums, int target) {

        System.out.println(start + "  " + "{4, 7, 2}" + "  " + target);

        if (start >= nums.length) return (target == 0);

        if(groupSum(start+1, nums, target-nums[start])) return true;

        System.out.println("----------------next iteration-----------------------");

        if(groupSum(start+1, nums, target)) return true;

        return false; 
    }

}