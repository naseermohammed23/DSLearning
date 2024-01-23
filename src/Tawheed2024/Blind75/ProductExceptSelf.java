package Tawheed2024.Blind75;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        ProductExceptSelf p = new ProductExceptSelf();
        int[] result = p.productExceptSelf(nums);
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+ " ");
        }

    }
 
    // using Prefix Sum is the optimized solution
    // [2,1,5,3] => [2,3,8,11]
    // we will use the prefix sum example and tweek little bit to get the prefix product. 
    public int[] productExceptSelf(int[] nums) {

        // product prefix except current 
        int[] prefixResult = new int[nums.length];
        int product = 1;
        for (int i =0;i<nums.length;i++) {
            prefixResult[i] = product;
            product*= nums[i];
        }


        // product suffix except current 
        int[] suffixResult = new int[nums.length];
        product = 1;
        for (int i=nums.length-1;i>=0;i--) {
            suffixResult[i] = product;
            product*= nums[i];
        }

        
        //get the product of the prefixResult and suffixResult. 
        int[] result = new int[prefixResult.length];
        for(int i=0;i<prefixResult.length;i++) {
            result[i] = prefixResult[i] * suffixResult[i];
        }

        return result;
    }
}
