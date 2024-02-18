package Tawheed2024.Blind75;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
            //{{1,2},{3,5},{6,7},{8,10},{12,16}}; {4,8}
            //{1,3},{6,9} ;;; {2,5}
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[]{4,8};

        int[][] results = insert(intervals, newInterval);
        System.out.println(results.length);
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> mergedElements = new ArrayList<>();
        
        for (int[] elem : intervals) {

            //Before the newInterval 
            if (elem[1] < newInterval[0]) {
                mergedElements.add(elem);
            }
            //After the newInterval
            else if (elem[0] > newInterval[1]) {
                mergedElements.add(newInterval);
                newInterval = elem;
            }
            //overlapping intervals
            else {
                newInterval[0] = Math.min(elem[0], newInterval[0]);
                newInterval[1] = Math.max(elem[1], newInterval[1]);
            }            
        }
        mergedElements.add(newInterval);
        
        return mergedElements.toArray(new int[mergedElements.size()][2]);
        
    }
}
