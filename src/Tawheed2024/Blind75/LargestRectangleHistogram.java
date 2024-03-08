package Tawheed2024.Blind75;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/1193045432
public class LargestRectangleHistogram {

    //[2,1,5,6,2,3]

    public int largestRectangleArea(int[] heights) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i=0;i<heights.length;i++) {

            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() -1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() -1;
            maxArea = Math.max(maxArea, height*width);
        }
        
        return maxArea;
        
    }



    /* this is brute force solution
    public int largestRectangleArea(int[] heights) {
        
        int maxArea = 0;
        int prevArea;
        int nextArea;

        for(int i=0;i<heights.length;i++) {

            int minHeight = Integer.MAX_VALUE;
            for(int j=i;j<heights.length;j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int width = j - i + 1;
                maxArea = Math.max(maxArea, minHeight * width);
            }
        }

        return maxArea;
    } */
    
}
