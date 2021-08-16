package Aug14Assignment;

import java.beans.Visibility;
import java.time.chrono.MinguoDate;

public class DeleteNodeFromBST {


    public static class Node {

        Node left;
        Node right;
        Node parent;

        /** 
         * helper method to print the values in the tree in Pre-Order Traverse (CLR)
         */
        void print() {

            System.out.print(this.value + " ");

            if (this.left != null)
                this.left.print();

            if (this.right != null)
                this.right.print();
        }
    
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


    /**
     * Here victim node is the node to be deleted. 
     * @param node
     * @param nodeValue
     * @return
     */
    static Node deleteNode(Node node, int nodeValue) {

        deleteVictimNode(node, null, nodeValue);

        return node;
    }



    /**
     * 
     * @param node 
     * @param parentNode - parent node of the given node. for root parent is null.. 
     * @param nodeValue
     * @return
     */
    private static void deleteVictimNode(Node node, Node parentNode, int nodeValue) {

        if (node == null) return ;

        node.parent = parentNode;

        // 1. find the node with nodeValue in the given tree. 
        if (node.value == nodeValue) { 
            
            // 2. if victim node is a leaf node, then delete and return
            if (node.left == null && node.right == null) {
                
                // issue with code.. please debug...
                /* if (node.value == nodeValue && node.parent.left.left == null && node.parent.left.right == null)
                     node.parent.left = null;
                else if (node.value == nodeValue && node.parent.right.left == null && node.parent.right.right == null)
                     node.parent.right = null; */

                if (node.parent.value < node.value) {
                    node.parent.right = null;
                } else {
                    node.parent.left = null;
                }
                
                return;
            }

            // 3. if victim node has left child and NO right child, then make the left child as successor.. 
            if (node.right == null && node.left != null) {
                // this will replace the victimNode with its left node. 
                node.left.parent = node.parent;
                node = node.left;
                return;
            }

            //node.parent = parentNode;

            // 4. if victim node has right child or both child, then 
                // 4.1 find minimum value node from the right subtree and make it successor 
            if (node.right != null) {   
                node.right.parent = node;      
                
                findMinNode(node, node.right); 
                
                return;
            }                
        }

        if (nodeValue < node.value) {
            deleteVictimNode(node.left, node, nodeValue);
        }

        if (nodeValue > node.value) {
            deleteVictimNode(node.right, node, nodeValue);
        }

    }


    /**
     * this helper method is to find the minNode (Successor Node) from the right subtree of the victim node and replace it.
     * @param node
     * @param minNode
     */
    private static void findMinNode(Node victimNode, Node minNode) {

        if (minNode == null || minNode.left == null) {
            // found the minimum value node - minNode.. 
            // need to make it successor node and replace with victim node. 
            
        
            
            if (minNode.parent != null && minNode.parent.value < minNode.value) {
               // minNode.parent.right = minNode.right;
               minNode.parent.right = minNode.right;
            } 
            
            if (minNode.parent != null && minNode.parent.value > minNode.value) {
              minNode.parent.left = minNode.right;    
            }

            victimNode.value = minNode.value;
            //minNode.parent.left = minNode.right;
            
            return ;
        }

        if (minNode.left != null) {
            minNode.left.parent = minNode;
        }

        findMinNode(victimNode, minNode.left);
    }


    public static void main(String[] args) {

        int nodeToBeDeleted = 20;

        Node treeNode = getBST();
        System.out.println("Print Tree before deleting node with value " + nodeToBeDeleted);
        treeNode.print();

        System.out.println("\n\nPrint Tree after deleting node with value " + nodeToBeDeleted);
        Node updatedTreeNode = deleteNode(treeNode, nodeToBeDeleted);
        updatedTreeNode.print();
    }

    
    // Note - all the basic conditions are working with the given tree. 
    
    
}
