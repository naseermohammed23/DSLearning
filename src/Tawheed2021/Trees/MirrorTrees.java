package Trees;


/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Binary Tree Mirror or not -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc5NjM0MjQy/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class MirrorTrees {
    
    public static class Node {

        Node left;
        Node right;
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }


    /**
    Tree1           1
                   /  \  
                  3    2
                      /  \
                     5     4
    **/
    static Node Tree1() {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(4);
        
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        

        return root;

    }

    /**
     Tree2           1
                   /  \  
                  2    3
                /  \
               4    5
     */
    static Node Tree2() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        //Node node5 = new Node(6);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        //node4.right = node5;
        

        return root;

    }

    static boolean isMirror(Node treeNode1, Node treeNode2) {

        System.out.println("naseer");

        // when both nodes of a trees are null
        if (treeNode1 == null && treeNode2 == null) return true;

        if (treeNode1 != null && treeNode2 == null || treeNode1 == null && treeNode2 != null) return false;

        if (treeNode1.value != treeNode2.value) return false;

        if (treeNode1.left != null && treeNode2.right == null || treeNode1.right != null && treeNode2.left == null) return false;
        
        //if (treeNode1.left != null && treeNode2.right != null && treeNode1.left.value != treeNode2.right.value) return false;

        boolean mirror; 

        mirror = isMirror(treeNode1.left, treeNode2.right);

        mirror = mirror && isMirror(treeNode1.right, treeNode2.left);

        return mirror;
    }

    public static void main(String[] args) {
        
        System.out.println("Given Trees are " + (isMirror(Tree1(), Tree2()) ? "mirror." : "not mirror."));
    }
}
