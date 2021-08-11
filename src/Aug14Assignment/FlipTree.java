package Aug14Assignment;

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
    static Node getBinaryTree() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        return root;

    }

    public static void main(String[] args) {
        Node root = getBinaryTree();
        System.out.println("Pre Order traversal before Flip : ");
        printPreOrderTravers(root);
        System.out.println("\n Pre Order traversal After Flip : ");
        flipTree(root);
        printPreOrderTravers(root);
    }


    /**
     * A method to flip the given tree. 
     * @param node
     */
    static void flipTree(Node node) {

        if (node == null) return ;

        if (node.left != null || node.right != null) {
            Node temp = node.left; 
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
    static void printPreOrderTravers(Node node) {

        if (node == null) {
            return ;
        }

        // process current node
        System.out.print(node.value + ",");

        // traverse left.. 
        printPreOrderTravers(node.left);

        // traverse right 
        printPreOrderTravers(node.right);
    }
}

