package ClassworkAssignment;


/**
 * Tawheed TIPS Summer 2021
 * July, 31, 2021 - Assignment
 * 
 * Max Sum in Matrix..
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/MzczNDMwNTExMjcy/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class MaxSumInMatrix {

    public static void main(String[] args) {
        //System.out.println(palindrom("civic"));    

        int[][] nums = {{2,1,3,1}, {3, 5, 4, 3},{4,5,2,1}};
        System.out.println(maxSumInMatrix(nums, 0, 0));

        int[][] nums1 = {{2,3,1,7}, {4, 1, 1, 1},{2,1,1,1}};
        System.out.println(maxSumInMatrix(nums1, 0, 0));


    }

    /*
         {
             {2, 1, 3, 1}, 
             {3, 5, 4, 3},
             {4, 5, 2, 1}
        };

        Traverse through the Matrix and find the maxSum in the matrix.. 

        Perfect solution developed in class.. 
    */
    static int maxSumInMatrix(int[][] matrix, int row, int col) {


        if(row == matrix.length-1 && col == matrix[0].length-1) { //base condition 1 -- last cell
            return matrix[row][col];
        }
  
        if(row == matrix.length-1) { //base condition 2 -- end of row
          return matrix[row][col] + maxSumInMatrix(matrix, row, col+1);
        }
  
        if(col == matrix[0].length-1) { //base condition 3 -- end of column
          return matrix[row][col] + maxSumInMatrix(matrix, row+1, col);
        }
  
        int rightSum = matrix[row][col] + maxSumInMatrix(matrix, row, col+1);
        int downSum = matrix[row][col] + maxSumInMatrix(matrix, row+1, col);
  
        return Math.max(rightSum, downSum);
  
    }

    /* good Try but this solution is not perfect for all the scenarios... */
    /* static int maxSumInMatrix1(int[][] matrix, int row, int col) {

        System.out.println(row+" "+col);

        if (row+1 > matrix.length-1) {
            return col+1 > matrix[0].length-1 ? matrix[row][col] : matrix[row][col] + maxSumInMatrix1(matrix, row, col+1);
        }        
        
        if (matrix[row][col+1] > matrix[row+1][col]) {
            return matrix[row][col] + maxSumInMatrix1(matrix, row, col+1);
        } else {
            return matrix[row][col] + maxSumInMatrix1(matrix, row+1, col);
        }
        
    }
 */

    
    
}
