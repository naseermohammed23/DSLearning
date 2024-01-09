package LeetCode;


// problem from leatcode -- max water container.. 
public class Solution {

    public static void main(String[] args) {
       // Solution solution = new Solution();
       // int[] heightArray =
              //  {4,3,2,1,4};
               
       // {1,8,6,2,5,4,8,3,7};
       // System.out.println(solution.maxArea(heightArray));

      
    }

    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int stPtr = 0;
        int endPtr = 0;
        int maxArea = 0;

        if (height.length == 0)
            return maxArea;

        if (height.length == 2)
            return 1 * height[start] < height[end] ? height[start] : height[end];

        while (start < end) {

            stPtr = stPtr < height[start] ? height[start] : stPtr;
            endPtr = endPtr < height[end] ? height[end] : endPtr;

            maxArea = (end - start) * (stPtr < endPtr ? stPtr : endPtr) > maxArea
                    ? (end - start) * (stPtr < endPtr ? stPtr : endPtr)
                    : maxArea;

            System.out.println(start+" "+end+" "+maxArea);

            if (height[start] < height[end]) {
                start++;
                //end = height.length - 1;
                stPtr = 0;
                endPtr = 0;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    
}

    