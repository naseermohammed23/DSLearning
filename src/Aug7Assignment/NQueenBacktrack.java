package Aug7Assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * N-Queen Backtrack solution -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI2ODcwNzMy/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class NQueenBacktrack {
    
    public static void main(String[] args) {

        // As per the assignment requirement to print the output of board size 1 through 10. 

        NQueenBacktrack queen = new NQueenBacktrack();

        for (int i=1;i<=10;i++) {
            queen.solveQueens(new ArrayList<String>(), i);
        }        
    }



    /**
     * 
     * @param board
     */
    void solveQueens(List<String> board, int size) {
        System.out.println("Solution for Board - "+ size + " x " + size);
        queensHelper(size, board, 0);
    }

    /**
     * This recursive function is to Choose/Explore/UnChoose the  coordinates of the queens on the board. 
     * @param size - Size of the board. 
     * @param board - Board of given size. 
     * @param col - columns to traverse on the board. 
     * @return true if found the solution. 
     * 
     * Note:- if need to return all the solution of the given board of size, then dont return boolean just return void. 
     * make the code changes in the subseequent methods also. 
     */
    boolean queensHelper(int size, List<String> board, int col) {

        if ( col >= size) {
            drawBoard(size, board);
            return true;
        } else {

            for (int row = 0; row < size; row++) {
                if (isSafe(size, board, row, col)) {

                    //Choose
                    board.add(row+","+col);

                    //explore 
                    boolean finished = queensHelper(size, board, col+1);
                    if (finished) {
                        return true;
                    }

                    //un-choose
                    board.remove(row+","+col);

                }
            }
        }

        return false;
    }


    /**
     * Helper function to determine if the given row, col is under the line of attack of the queens on the board. 
     * @param size - size of the board.. 
     * @param board 
     * @param row
     * @param col
     * @return
     */
    private boolean isSafe(int size, List<String> board, int row, int col) {
        boolean isLineOfAttack = false;
        
        for (int i=board.size()-1;i>=0;i--) {
            isLineOfAttack = getLineOfAttackList(size, board.get(i), row+","+col);
            if (isLineOfAttack) {
                break;
            }
        }

        return !isLineOfAttack;
    }

    /**
     * Helper function to determine all the possible line of attack coordinates of the queen on the board. 
     * @param size
     * @param str
     * @return
     */
    private boolean getLineOfAttackList(int size, String str, String key) {
        
        boolean isLineOfAttack = false;

        String[] str1 = str.split(",");
        int row = Integer.parseInt(str1[0]);
        int col = Integer.parseInt(str1[1]);

        

        // Add all row 
        for (int i=0; i<size && !isLineOfAttack; i++){
            isLineOfAttack = isKeyMatching((row+","+i),key);
        }

        // Add all col 
        for (int i=0; i<size && !isLineOfAttack; i++){
            isLineOfAttack = isKeyMatching((i+","+col),key);
        }

        
        // Add all diagnols // Up -Left 
        int r = row, c = col;
        while (!isLineOfAttack) {
            if (r == 0 && c == 0) {
                isLineOfAttack = isKeyMatching((r+","+c),key);
                break;
            } else if (r == 0 && c >= 0) {
                isLineOfAttack = isKeyMatching((r + "," + c--),key);
                break;
            } else if (r >= 0 && c == 0) {
                isLineOfAttack = isKeyMatching((r-- + "," + c),key);
                break;
            } else {
                isLineOfAttack = isKeyMatching((r-- + "," + c--),key);
            }
        }

        // Add all diagnols // down - right
        r = row;
        c = col;
        while (!isLineOfAttack) {
            if (r == size-1 || c == size-1) {
                isLineOfAttack = isKeyMatching((r+","+c),key);
                break;
            } else {
                isLineOfAttack = isKeyMatching((r++ + "," + c++),key);
            }
        }

        r = row;
        c = col;
        // Add all diagnols // Up - right 
        while (!isLineOfAttack) {
            if (r == 0 || c == size-1) {
                isLineOfAttack = isKeyMatching((r+","+c),key);
                break;
            } else if (r >= 0 && c <= size) {
                isLineOfAttack = isKeyMatching((r-- + "," + c++),key);
            }
        }

        // Add all diagnols // down -Left 
        r = row;
        c = col;
        while (!isLineOfAttack) {
            if (r == size-1 || c == 0) {
                isLineOfAttack = isKeyMatching((r+","+c),key);
                break;
            } else if (r <= size-1 && c >=0) {
                isLineOfAttack = isKeyMatching((r++ + "," + c--),key);
            } 
        }

        return isLineOfAttack;
    }

    /**
     * 
     * @param str
     * @param key
     * @return
     */
    boolean isKeyMatching(String str, String key) {
        return str.equals(key);
    }


    /**
     * Helper function to draw the board of the found solution. 
     * @param size - size of the board. 
     * @param result - list of coordinates of the queens on the board. 
     */
    private void drawBoard(int size, List<String> result) {
        System.out.println("=======================================");
        for (int i=0;i<size;i++) {
            for (int j=0;j<size;j++) {
                System.out.print(result.contains(i+","+j) ? "  Q  " : "  -  ");
            }
            System.out.println();
        }
        System.out.println("=======================================");
    }
}
