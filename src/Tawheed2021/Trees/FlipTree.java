package Trees;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Flip a Tree -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQ0MDUx/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class FlipTree {
    
    public static class Node {

        Node left;
        Node right;
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }

    /**
                      1
                    /   \  
                  2      3
                 / \    / \
                4   5  6   7
    **/
    static TreeNode getBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        return root;

    }

    public static void main(String[] args) {
        TreeNode root = getBinaryTree();
        System.out.println("Pre Order traversal before Flip : ");
        printPreOrderTravers(root);
        System.out.println();
        TreeUtil.drawTree(root);
        System.out.println("\n Pre Order traversal After Flip : ");
        flipTree(root);
        printPreOrderTravers(root);
        System.out.println();
        TreeUtil.drawTree(root);
    }


    /**
     * A method to flip the given tree. 
     * @param node
     */
    static void flipTree(TreeNode node) {

        if (node == null) return ;

        if (node.left != null || node.right != null) {
            TreeNode temp = node.left; 
            node.left = node.right;
            node.right = temp;
        }

        flipTree(node.left);

        flipTree(node.right);

    }

    /**
     * Print Tree values in Pre-order
     * @param node
     */
    static void printPreOrderTravers(TreeNode node) {

        if (node == null) {
            return ;
        }

        // process current node
        System.out.print(node.val + ",");

        // traverse left.. 
        printPreOrderTravers(node.left);

        // traverse right 
        printPreOrderTravers(node.right);
    }
}

