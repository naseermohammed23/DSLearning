package trees;

import trees.util.Node;
import trees.util.TreeSample;

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
    static int singleValueSubTree(Node node) {

        if (node.left == null && node.right == null) {
             return 1;
        }

        
        if (node.left == null && node.right != null && node.value == node.right.value) {
            return 1 + singleValueSubTree(node.right);
        } else if (node.left != null && node.right == null && node.value == node.left.value) {
            return 1 + singleValueSubTree(node.left);
        } else if (node.value == node.left.value && node.value == node.right.value) {
            return 1 + singleValueSubTree(node.left) + singleValueSubTree(node.right);
        } else {       
            return singleValueSubTree(node.left) + singleValueSubTree(node.right);
        }
    }


    public static void main(String[] args) {

        Node root = TreeSample.getSingleValueTreeExample();

        System.out.println("Single Value Subtree : " + singleValueSubTree(root));
        
    }
}
