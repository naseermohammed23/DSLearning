package Trees;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * Largest BST -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQ0MDY3/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class LargestBST {

    public static class Node {

        Node left;
        Node right;
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }


    /** Correct BST 
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
    **/
    static Node getBST() {
        Node root = new Node(20);
        Node node1 = new Node(8);
        Node node2 = new Node(22);
        Node node3 = new Node(4);
        Node node4 = new Node(12);
        Node node5 = new Node(10);
        Node node6 = new Node(14);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        return root;

    }

    static boolean isBST(Node node, Integer left, Integer right) {

        if (node == null) return true;

       // The current node's value must be between low and high.
       if ((left != null && node.value <= left) || (right != null && node.value >= right)) return false;

        if (!isBST(node.left, left, node.value)) return false;

        if (!isBST(node.right, node.value, right)) return false;

        return true;

    }

    static int size(Node node) {

        if (node == null) return 0;

        return 1 + size(node.left) + size(node.right);
    }


    /** Inefficient solution becuase we are checking repeatedly for the node and its subtree for isBST..  */    
    static int findLargestBST(Node node) {

        if (node == null) return 0;

        if (isBST(node, null, null)) {
            return size(node);
        }

        return Math.max(findLargestBST(node.left), findLargestBST(node.right));
    }

    public static void main(String[] args) {
        Node root = getBST();
        System.out.println("Size of the Largest BST : "+findLargestBST(root));

    }
}
