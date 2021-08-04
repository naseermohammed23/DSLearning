package Aug7Assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Tawheed TIPS Summer 2021
 * July, 31, 2021 - Assignment
 * 
 * N-Queen Backtrack solution -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI2ODcwNzMy/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class NQueenBacktrack {
    
    public static void main(String[] args) {
        NQueenBacktrack queen = new NQueenBacktrack();
        queen.solveQueens(new ArrayList<String>());
    }



    /**
     * 
     * @param board
     */
    void solveQueens(List<String> board) {
        int size = 4;
        queensHelper(size, board, 0);

    }

    /**
     * This recursive function is to Choose/Explore/UnChoose the  coordinates of the queens on the board. 
     * @param size - Size of the board. 
     * @param board - Board of given size. 
     * @param col - columns to traverse on the board. 
     * @return true if found the solution. 
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
    private static boolean isSafe(int size, List<String> board, int row, int col) {
        List<String> lineOfAttackList = new ArrayList<>();
           for (int i=board.size()-1;i>=0;i--) {
                lineOfAttackList.addAll(getLineOfAttackList(size, board.get(i)));
           }
        return !lineOfAttackList.contains(row+","+col);
    }

    /**
     * Helper function to determine all the possible line of attack coordinates of the queen on the board. 
     * @param size
     * @param str
     * @return
     */
    private static HashSet<String> getLineOfAttackList(int size, String str) {
        HashSet<String> temp = new HashSet<>();
        String[] str1 = str.split(",");
        int row = Integer.parseInt(str1[0]);
        int col = Integer.parseInt(str1[1]);

        // Add all row 
        for (int i=0; i<size; i++){
            temp.add(row+","+i);
        }

        // Add all col 
        for (int i=0; i<size; i++){
            temp.add(i+","+col);
        }

        
        // Add all diagnols // Up -Left 
        int r = row, c = col;
        while (true) {
            if (r == 0 && c == 0) {
                temp.add(r+","+c);
                break;
            } else if (r == 0 && c >= 0) {
                temp.add(r + "," + c--);
                break;
            } else if (r >= 0 && c == 0) {
                temp.add(r-- + "," + c);
                break;
            } else {
                temp.add(r-- + "," + c--);
            }
        }

        // Add all diagnols // down - right
        r = row;
        c = col;
        while (true) {
            if (r == size-1 || c == size-1) {
                temp.add(r+","+c);
                break;
            } else if (r == 0 && c >0) {
                temp.add(r++ + "," + c++);
            } else if (r > 0 && c == 0) {
                temp.add(r++ + "," + c++);
            } else {
                temp.add(r++ + "," + c++);
            }
        }

        r = row;
        c = col;
        // Add all diagnols // Up - right 
        while (true) {
            if (r == 0 || c == size-1) {
                temp.add(r+","+c);
                break;
            } else if (r >= 0 && c <= size) {
                temp.add(r-- + "," + c++);
            }
        }

        // Add all diagnols // down -Left 
        r = row;
        c = col;
        while (true) {
            if (r == size-1 || c == 0) {
                temp.add(r+","+c);
                break;
            } else if (r <= size-1 && c >=0) {
                temp.add(r++ + "," + c--);
            } 
        }

        return temp;
    }


    /**
     * Helper function to draw the board of the found solution. 
     * @param size - size of the board. 
     * @param result - list of coordinates of the queens on the board. 
     */
    private static void drawBoard(int size, List<String> result) {
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
