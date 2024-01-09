package trees;

import java.util.ArrayList;
import java.util.List;


/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * Merge two BSTs -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQzODI3/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class MergeBST {

    public static class Node {

        Node left;
        Node right;
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }

    /**
                    2
                   /  \  
                  1    3
    **/
    static Node getBST1() {
        Node root = new Node(2);
        Node node1 = new Node(1);
        Node node2 = new Node(3);

        root.left = node1;
        root.right = node2;

        return root;

    }

    /**
                    5
                   /  \  
                  4    6
                        \
                         7
    **/
    static Node getBST2() {
        Node root = new Node(5);
        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(7);

        root.left = node1;
        root.right = node2;
        node2.right = node3;

        return root;

    }
    

    
    public static void main(String[] args) {
        Node treeNode1 = getBST1();
        Node treeNode2 = getBST2();

        //Step1: get the list of nodes from TreeNode1 (BST) in in-order 
       List<Node> list = inOrderTravers(treeNode1, new ArrayList<>());
       
       //Step2 : loop over each node in the above list and merge the node in the TreeNode2 (BST)
       list.forEach(node -> {
            mergeBST(treeNode2, node.value);
       });

       //Step3 : get the resultant list of the TreeNode2 after merging TreeNode1 
       List<Node> result = inOrderTravers(treeNode2, new ArrayList<>());
       
       // Step : print the TreeNode2 to verify its a Balanced BST. 
       result.forEach(node -> System.out.print(node.value + " "));
       
    }

    /**
     * A Resursive method to merge node to the BST. 
     * @param treeNode
     * @param nodeValue
     */
    static void mergeBST(Node treeNode, int nodeValue) {

        if (nodeValue == treeNode.value) return;

        if (nodeValue < treeNode.value) {
            if (treeNode.left == null) {
                treeNode.left = new Node(nodeValue);
                return;
            } else {
                mergeBST(treeNode.left, nodeValue);
            }
        }

        if (nodeValue > treeNode.value) {
            if (treeNode.right == null) {
                treeNode.right = new Node(nodeValue);
                return;
            } else {
                mergeBST(treeNode.right, nodeValue);
            }
        }

        return;

    }

    /**
     * return list of Tree nodes in In-order traverse
     * @param node
     */
    static List<Node> inOrderTravers(Node node, List<Node> list) {

        if (node == null) {
            return list;
        }

        // traverse left.. 
        inOrderTravers(node.left, list);

        // process current node
        //System.out.print(node.value + ",");
        list.add(node);

        // traverse right 
        inOrderTravers(node.right, list);

        return list;

    }
}
