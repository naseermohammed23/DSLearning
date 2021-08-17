package Aug14Assignment;

import util.Node;
import util.TreeUtil;

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

    /**
     * we are using the following formula for finding the distance between given nodes.
     * Dist(root, node1) + Dist(root, node2) - 2 * Dist(root, LCA)
     * LCA - least common ancestor. 
     */
    static void findDistanceBetweenNodes() {
        int node1 = 4, node2 = 8;

        int lcaOfNodes = TreeUtil.findLeastCommonAncestor(getBinaryTree(), node1, node2);
        int distanceBetweenNodes = TreeUtil.distance(getBinaryTree(), node1) + TreeUtil.distance(getBinaryTree(), node2) - 2 * TreeUtil.distance(getBinaryTree(), lcaOfNodes);

        System.out.println("Distance between Nodes  ("+node1+","+node2+") is " + distanceBetweenNodes);
    }


    public static void main(String[] args) {

        findDistanceBetweenNodes();
    }
    
}
