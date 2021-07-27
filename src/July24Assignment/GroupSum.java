package July24Assignment;

/**
 * Tawheed TIPS Summer 2021
 * July, 26, 2021 - Assignment
 * 
 * PowerSet -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/MzczNDMwNTExMjYy/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class GroupSum {
    
    public static void main(String[] args) {
        
        int[] nums = {4, 7, 2};
        System.out.println(groupSum(0, nums, 9));
    }


    /**
     * find groupSum equal to target from the given set. 
     * @param start
     * @param nums
     * @param target
     * @return
     */
    public static boolean groupSum(int start, int[] nums, int target) {

        if (start >= nums.length) return (target == 0);

        if(groupSum(start+1, nums, target-nums[start])) return true;

        if(groupSum(start+1, nums, target)) return true;

        return false; 
    }
}
