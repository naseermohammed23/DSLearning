package Trees;

import Trees.util.Node;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Least Common Ancestor (LCA) 
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQ0Mjg1/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class LeastCommonAcncestor {

    /** Binary Tree.  
                      1
                    /   \  
                  2       3
                /   \    /  \
               4    5   6    7
                         \
                          8
    **/
    static Node getBinaryTree() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        node5.right = node7;
        
        return root;

    }

    
    public static void main(String[] args) {
        System.out.println("Least Common Ancestor is :" + TreeUtil.findLeastCommonAncestor(getBinaryTree(), 6, 7));

    }
    
}
