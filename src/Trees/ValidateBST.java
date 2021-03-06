package trees;


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


    /** In-Correct BST 
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
             ---> 7    14
    **/
    static Node getNonBST() {
        Node root = new Node(20);
        Node node1 = new Node(8);
        Node node2 = new Node(22);
        Node node3 = new Node(4);
        Node node4 = new Node(12);
        Node node5 = new Node(7);
        Node node6 = new Node(14);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        return root;

    }

    static boolean isBST(Node node, Integer leftValue, Integer rightValue) {

        if (node == null) return true;

       // The current node's value must be between low and high.
       if ((leftValue != null && node.value <= leftValue) || (rightValue != null && node.value >= rightValue)) return false;

        if (!isBST(node.left, leftValue, node.value)) return false;

        if (!isBST(node.right, node.value, rightValue)) return false;

        return true;

    }

    static boolean isValidBST(Node bst) {
        return isBST(getBST(), null, null);
    }

    static int size(Node node) {

        if (node == null) return 0;

        return 1 + size(node.left) + size(node.right);
    }
    
    
    public static void main(String[] args) {

        // Correct BST Example...
        System.out.println("Is it  BST " + isValidBST(getBST()));

        // In-Correct BST Example.. 
        System.out.println("Is it  BST " + isValidBST(getNonBST()));

        // Size of BST Example...
        System.out.println("Is it  BST " + (size(getBST())));

    }


    
}
