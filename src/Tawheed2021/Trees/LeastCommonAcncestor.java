package Trees;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Least Common Ancestor (LCA) 
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQ0Mjg1/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class LeastCommonAcncestor {

    /** Binary Tree.  
                      3
                    /   \  
                  5       1
                /   \    /  \
               6    2   0    8
                   / \
                  7   4     
    **/
    static Integer bt1[] = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
    static Integer bt2[] = new Integer[]{3,5,null,7,null,9,null,11,null};
    
    public static void main(String[] args) {
        // TreeNode lca = TreeUtil.findLeastCommonAncestor(TreeUtil.buildTree(bt1), new TreeNode(5), new TreeNode(4));
        // System.out.println("Least Common Ancestor is :" + lca.val);

        // TreeNode lca_leftBT = TreeUtil.findLeastCommonAncestor(TreeUtil.buildTree(bt2), new TreeNode(9), new TreeNode(11));
        // System.out.println("Least Common Ancestor for Left BT is :" + lca_leftBT.val);

        LeastCommonAcncestor l = new LeastCommonAcncestor();
        Integer bt3[] = l.getIntegerArrayFor10000(361);

        TreeNode lca_leftBT1 = TreeUtil.findLeastCommonAncestor(TreeUtil.buildTree(bt3), new TreeNode(128), new TreeNode(129));
        System.out.println("Least Common Ancestor for Left BT is :" + lca_leftBT1.val);


    }    

    public Integer[] getIntegerArrayFor10000(int size) {      
      Integer result[] = new Integer[size];

      System.out.println("[");
      for(int i=0,j=0;i<result.length;j++) {
        if (i == 0) {
          result[i] = -1;
          System.out.print(result[i] + ",");
          i++;
          --j;
        } else {
          result[i] = j;
          result[i+1] = null; 
          System.out.print(result[i] + ","+result[i+1]+",");
          i=i+2;
        }          
      }
      System.out.println("]");

      return result;
    }
}
