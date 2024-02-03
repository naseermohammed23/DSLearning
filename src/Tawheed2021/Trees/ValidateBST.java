package Trees;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Is it a BST -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MTYzNDM1/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class ValidateBST {


    /** Correct BST 
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
    **/
    static TreeNode getBST() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(22);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(32);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(14);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        return root;

    }


    /** In-Correct BST 
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
             ---> 7    14
    **/
    static TreeNode getNonBST() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(22);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(14);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        return root;

    }

    static boolean isValidBST(TreeNode bst) {
        return TreeUtil.isBST(getBST(), null, null);
    }
    
    
    public static void main(String[] args) {

        // Correct BST Example...
        System.out.println("Is it  BST " + isValidBST(getBST()));

        // In-Correct BST Example.. 
        System.out.println("Is it  BST " + isValidBST(getNonBST()));

        // Size of BST Example...
        System.out.println("Is it  BST " + (TreeUtil.size(getBST())));

    }


    
}
