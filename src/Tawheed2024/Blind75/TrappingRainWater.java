package Tawheed2024.Blind75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//https://leetcode.com/problems/trapping-rain-water/submissions/1189264748
//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
 
    // Brute force solution.. 
    public int trap_brute(int[] height) {
        int result = 0;
        
        for (int i=1; i<height.length;i++) {
            int left_max = 0;
            int right_max = 0;
            for(int j=i;j>=0;j--) {
                left_max = Math.max(left_max, height[j]);
            }

            for(int j=i;j<height.length;j++) {
                right_max = Math.max(right_max, height[j]);
            }

            result+= Math.min(left_max, right_max) - height[i];

        }

        return result;

    }

    /**
     * Using Monotonic Stacks - Increasing/Decreasing.. 
     * bottom to top 
     * 
     * Example - Increasing Monotonics Stacks - we should have the end resultant stack in increasing order. 
     * num[] = [8,2,9,6,10,12,5]  -> 
     * push the above numbers in stack =>  [8] -> [2] -> [2,9] -> [2,6] -> [2,6,10] -> [2,6,10,12] -> [2,5]
     * 
     */
    public static int trap(int[] height) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque();
        int top, width, bounded_height;
       
        for(int i=0;i<height.length;i++) {

            // increasing monotonic stack 
            /*while(!stack.isEmpty() && stack.peek() > height[i]) {
                stack.pop();
            }*/

            

            // Decreasing monotonic stack 
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                top = height[stack.pop()];
                if (stack.isEmpty())
                    break;
                
                width = i - stack.peek() - 1;
                bounded_height = Math.min(height[i], height[stack.peek()]) - top;
                result += bounded_height * width;
            }
            stack.push(i);
        }


        return result;
    }

    public static void main(String[] args) {
        int[] height = new int[]{8,2,6,10,12,5};
        System.out.println(trap(height));
    }
}
