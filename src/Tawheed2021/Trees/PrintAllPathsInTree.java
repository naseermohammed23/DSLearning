package trees;


/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Print all paths in a tree -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQzOTQx/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class PrintAllPathsInTree {
    
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

        printAllPathsInTree(getBinaryTree(), "");
        
    }

    
    /**
     * A Recursive method to print all paths in the tree 
     * @param node
     * @param result
     */
    static void printAllPathsInTree(Node node, String result) {

        if (node.left == null) {
            System.out.println(result+" "+node.value);
            return ;
        } else {
            printAllPathsInTree(node.left, result+" "+node.value);
        }

        printAllPathsInTree(node.right, result+" "+node.value);
    }

}
