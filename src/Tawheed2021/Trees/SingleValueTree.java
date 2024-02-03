package Trees;

import Trees.util.TreeNode;
import Trees.util.TreeSample;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Single Value Tree -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQ0MDgx/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class SingleValueTree {
    


    /**
     * returns the count of single value subtree in the given tree. 
     * @param node
     * @return
     */
    static int singleValueSubTree(TreeNode node) {

        if (node.left == null && node.right == null) {
             return 1;
        }

        
        if (node.left == null && node.right != null && node.val == node.right.val) {
            return 1 + singleValueSubTree(node.right);
        } else if (node.left != null && node.right == null && node.val == node.left.val) {
            return 1 + singleValueSubTree(node.left);
        } else if (node.val == node.left.val && node.val == node.right.val) {
            return 1 + singleValueSubTree(node.left) + singleValueSubTree(node.right);
        } else {       
            return singleValueSubTree(node.left) + singleValueSubTree(node.right);
        }
    }


    public static void main(String[] args) {

        TreeNode root = TreeSample.getSingleValueTreeExample();

        System.out.println("Single Value Subtree : " + singleValueSubTree(root));
        
    }
}
