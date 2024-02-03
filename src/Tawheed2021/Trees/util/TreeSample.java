package Trees.util;

public class TreeSample {

    /** Binary Tree.  
                      1
                    /   \  
                  2       3
                /   \    /  \
               4    5   6    7
                         \
                          8
    **/
    public static TreeNode getBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node5.right = node7;
        
        return root;

    }


    /** valid BST 
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
                   \     \
                    11    15
    **/
    public static TreeNode getBST() {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(28);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(11);
        TreeNode node8 = new TreeNode(15);

        TreeNode node9 = new TreeNode(24);
        TreeNode node10 = new TreeNode(34);
        node2.left = node9;
        node2.right = node10;
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        node5.right = node7;
        node6.right = node8;

        return root;

    }


    /**
     *               5
     *             /   \
     *            1     5
     *           / \     \
     *          4   4     5
     */
    public static TreeNode getSingleValueTreeExample() {
      TreeNode root = new TreeNode(5);
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(5);
      TreeNode node3 = new TreeNode(4);
      TreeNode node4 = new TreeNode(4);
      TreeNode node5 = new TreeNode(5);

      root.left = node1;
      root.right = node2;
      node1.left = node3;
      node1.right = node4;
      node2.right = node5;

      return root;

    }
    
}
