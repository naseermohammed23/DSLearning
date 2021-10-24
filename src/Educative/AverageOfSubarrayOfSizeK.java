package Educative;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    
    public static double[] findAverages(int K, int[] input, int idx, int windowSum, double[] result) {


        if (idx + (K-1) > input.length-1) return result;

        if (idx > 0) { 
            windowSum += input[idx + (K-1)];
        } else {
            // this execute only first time when idx = 0 to calc the sum of the window of size K.
            for (int j=0;j<K;j++) {
                windowSum += input[j];
            }
        }

        result[idx] = (double)windowSum / K;
        windowSum -= input[idx];

        return findAverages(K, input, idx+1, windowSum, result);

    }
  
    public static void main(String[] args) {
      //double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
      double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 }, 0, 0, new double[5]);
      System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
  }