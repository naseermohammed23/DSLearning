package Tawheed2024.Blind75;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * Diameter of a Binary Tree -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI4NzM4OTcw/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class DiameterOfBST {
    
    
    public static void main(String[] args) {
        findDiameterOfBST1();       
       findDiameterOfBST2();   
        findDiameterOfBST3();   
        findDiameterOfBST4();
    }


    /**
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
    **/
    static void findDiameterOfBST1() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(22);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(14);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        int[] diameter = new int[1];
        findDiameterHelper(root, diameter);
        System.out.println("Diameter of BST " + diameter[0]);

    }


    /**
                    1
                   /  \  
                  2    3
                /   \ 
               4    5
    **/
    static void findDiameterOfBST2() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        int[] diameter = new int[1];
        findDiameterHelper(root, diameter);
        System.out.println("Diameter of BST " + diameter[0]);

    }


    /**
                    1
                   /  \  
                  2    3
                /   \ 
               4    5
                   /  \
                 6     7
                /       \
              11         8
              /           \
             12            9 
            /               \
           13                10
          /
         14
         [1,2,3,4,5,null,null,null,null,6,7,11,null,null,8,12,null,null,9,13,null,null,10,14,null]
    **/
    static void findDiameterOfBST3() {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,3,4,5,null,null,6,7,11,null,null,8,12,null,null,9,13,null,null,10,14,null});

        int[] diameter = new int[1];
        findDiameterHelper(root, diameter);
        System.out.println("Diameter of BST " + diameter[0]);

    }

    // [2,1,4,3,null,5]
    static void findDiameterOfBST4() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = null;
        TreeNode node5 = new TreeNode(5);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        int[] diameter = new int[1];
        findDiameterHelper(root, diameter);
        System.out.println("Diameter of BST " + diameter[0]);

    }

    /**
     * Helper method to determine the diameter of the given BST.
     * @param node
     * @param result
     * @return
     */
    static int findDiameterHelper(TreeNode node, int[] result) {

        if (node == null) return 0;

        int left = findDiameterHelper(node.left, result);

        int right = findDiameterHelper(node.right, result);

        result[0] = Math.max(result[0], left + right);

        return 1 + Math.max(left , right);

    }
    
}
