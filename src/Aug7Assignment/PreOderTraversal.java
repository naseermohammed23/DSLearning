package Aug7Assignment;

import java.util.Stack;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * PreOrder Traversal without recursion -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQzODky/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class PreOderTraversal {

    /**
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
    **/
    public static class Node {

        Node left;
        Node right;
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }

    public static void main(String[] args) {
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

        System.out.println("Pre Order Traverse without recursion - CLR");
        printPreOrderTravers(root);
        System.out.println();
    }

    /**
     * 2. Print Tree values in Pre-order without recursion.. 
     * @param node
     */
    static void printPreOrderTravers(Node node) {

        if (node == null) {
            System.out.println("Emtpy Tree.. ");
        }

        Stack<Node> preOrderStack = new Stack<>();
        preOrderStack.push(node);

        while (!preOrderStack.empty()) {
            Node childNode = preOrderStack.pop();
            if (childNode != null) {
                // process current node
                System.out.print(childNode.value + ",");

                preOrderStack.push(childNode.right);
                preOrderStack.push(childNode.left);
            }
        }
    }   
}
