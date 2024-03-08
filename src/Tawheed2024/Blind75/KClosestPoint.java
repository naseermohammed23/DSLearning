package Tawheed2024.Blind75;

import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/submissions/1197233138
public class KClosestPoint {
    
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int distance(Point p) {
            //int xDiff = p1.x - p2.x;
            //int yDiff = p1.y - p2.y;
            //return xDiff * xDiff + yDiff * yDiff; //fi problem asks for closes to the given point c

            return p.x * p.x + p.y * p.y;
        }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(distance(p2), distance(p1));
        });

        for (int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            maxHeap.offer(new Point(x, y));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }       

        int[][] result = new int[k][2];
        int i=0;
        for(Point p: maxHeap) {
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }

        return result;

    }
}
