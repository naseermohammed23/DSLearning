package trees;


/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Check if two Binary Trees are identical -
 * hhttps://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc5NjM0MjE2/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class IdenticalTrees {
    
    public static class Node {

        Node left;
        Node right;
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }


    /**
    Tree1           20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
    **/
    static Node Tree1() {
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

    /**
     Tree2           20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
     */
    static Node Tree2() {
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

    /**
     * Helper method to return true if given tree1 & tree2 are identical otherwise false.. 
     * @param node1 - Tree1
     * @param node2 - Tree2
     * @return
     */
    static boolean isIdentical(Node node1, Node node2) {

        if (node1 == null && node2 == null) return true;

        if (node1.value != node2.value) return false;

        if (node1.left == null && node2.left != null || node1.left != null && node2.left == null) return false;

        if (node1.right == null && node2.right != null || node1.right != null && node2.right == null) return false;

        

        boolean identical;

        identical = isIdentical(node1.left, node2.left);

        return identical && isIdentical(node1.right, node2.right);

    }

    public static void main(String[] args) {
        
        System.out.println("Given Trees are " + (isIdentical(Tree1(), Tree2()) ? "identical." : "not identical."));
    }

}
