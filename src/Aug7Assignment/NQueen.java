package Aug7Assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NQueen {
    
    public static void main(String[] args) {
        List<String> result = NQueenProcess(4, new ArrayList<>(), 1, 0, 1);

        System.out.println("Queens - " + result.toString());
    }



    static List<String> NQueenProcess(int N, List<String> result, int queen, int row, int col) {


        if (result.size() == N) {
            System.out.println("All Queens are placed : " + result.toString());
            return result;
        }

        System.out.println("Placing Queen : " + queen);

        if ( queen == 1) {

            // this is very initial step to add the first queen to the result list at 0,0
            result.add(row+","+col);
            System.out.println(result.toString());
            return NQueenProcess(N, result, queen+1, row+1, col);
        } else {
           // iterate throught the result and get the row,col for last queen in the list. 
           // 1. get the list of LineOfAttack for the all Queen in the result list.
           // 2. verify if the current Queen coordinates exist in the Line of Attack list of last Queens. 
           // 3. if exist then increment the current queen coordinates and check again. 
           // 4. repeat step 1 to 3 untill all the queens in the result list is done. 
           
           // get lineOfAttack list of all the queens in the result list. 
           List<String> lineOfAttackList = new ArrayList<>();
           for (int i=result.size()-1;i>=0;i--) {
                lineOfAttackList.addAll(getLineOfAttackList(N, result.get(i)));
           }

           // check the current queen coordinates should not be in lineOfAttack list of the existing queens.
           boolean isInLineOfAttack = true;
           for (int j=0;j<N;j++) {
                isInLineOfAttack = verifyisQueenInLineOfAttackList(lineOfAttackList, row, j);
                if (!isInLineOfAttack) {
                    result.add(row+","+j);
                    System.out.println(result.toString());
                    break;
                }
           }

           if (!isInLineOfAttack) {
               return row + 1 < N ? NQueenProcess(N, result, queen+1, row+1, col) : result;
           } else {
            return NQueenProcess(N, result, queen, row, col);
           }


        }
        

    }



    private static boolean verifyisQueenInLineOfAttackList(List<String> lineOfAttackList, int i, int j) {
        return lineOfAttackList.contains(i+","+j);
    }

    private static HashSet<String> getLineOfAttackList(int N, String str) {
        HashSet<String> temp = new HashSet<>();
        String[] str1 = str.split(",");
        int row = Integer.parseInt(str1[0]);
        int col = Integer.parseInt(str1[1]);

        // Add all row 
        for (int i=0; i<N; i++){
            temp.add(row+","+i);
        }

        // Add all col 
        for (int i=0; i<N; i++){
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
            if (r == N-1 || c == N-1) {
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
            if (r == 0 || c == N-1) {
                temp.add(r+","+c);
                break;
            } else if (r >= 0 && c <= N) {
                temp.add(r-- + "," + c++);
            }
        }

        // Add all diagnols // down -Left 
        r = row;
        c = col;
        while (true) {
            if (r == N-1 || c == 0) {
                temp.add(r+","+c);
                break;
            } else if (r <= N-1 && c >=0) {
                temp.add(r++ + "," + c--);
            } 
        }

        return temp;
    }


}
