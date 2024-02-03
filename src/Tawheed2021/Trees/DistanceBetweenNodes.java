package Trees;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Find distance between two nodes of a Binary Tree -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQ0MjMy/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class DistanceBetweenNodes {

    /** Binary Tree.  
                      1
                    /   \  
                  2       3
                /   \    /  \
               4    5   6    7
                         \
                          8
    **/
    static TreeNode getBinaryTree() {
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

    /**
     * we are using the following formula for finding the distance between given nodes.
     * Dist(root, node1) + Dist(root, node2) - 2 * Dist(root, LCA)
     * LCA - least common ancestor. 
     */
    static void findDistanceBetweenNodes() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);

        TreeNode lcaOfNodes = TreeUtil.findLeastCommonAncestor(getBinaryTree(), node1, node2);
        int distanceBetweenNodes = TreeUtil.distance(getBinaryTree(), node1) + TreeUtil.distance(getBinaryTree(), node2) - 2 * TreeUtil.distance(getBinaryTree(), lcaOfNodes);

        System.out.println("Distance between Nodes  ("+node1.val+","+node2.val+") is " + distanceBetweenNodes);
    }


    public static void main(String[] args) {

        findDistanceBetweenNodes();
    }
    
}
