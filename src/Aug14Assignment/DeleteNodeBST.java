package Aug14Assignment;

/**
 * Class work - 
 */
public class DeleteNodeBST {


    public static class Node {

        Node left;
        Node right;

        /** 
         * helper method to print the values in the tree in In-Order Traverse (LCR) - ascending order. 
         */
        void print() {

            if (this.left != null)
                this.left.print();

            System.out.print(this.value + " ");
            
            if (this.right != null)
                this.right.print();
        }
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }


    /** valid BST 
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
                   \     \
                    11    15
    **/
    static Node getBST() {
        Node root = new Node(20);
        Node node1 = new Node(8);
        Node node2 = new Node(28);
        Node node3 = new Node(4);
        Node node4 = new Node(12);
        Node node5 = new Node(10);
        Node node6 = new Node(14);
        Node node7 = new Node(11);
        Node node8 = new Node(15);

        Node node9 = new Node(24);
        Node node10 = new Node(34);
        node2.left = node9;
        node2.right = node10;
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        node5.right = node7;
        node6.right = node8;

        return root;

    }

    static Node deleteNodeBST(Node node, int value) {

        if (node == null) {
            return null;
        }

        // start searching.. 
        if (value < node.value) {
            node.left = deleteNodeBST(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNodeBST(node.right, value);
        } else {
            // found the value. 
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // has both child 
                int minValue = minNode(node.right);
                node.value = minValue;

                node.right = deleteNodeBST(node.right, minValue);

            }

        }

        return node;

    }

    static int minNode(Node node) {
        if (node.left == null) return node.value;
        return minNode(node.left);
    }

    public static void main(String[] args) {
        int nodeToBeDeleted = 20;

        Node treeNode = getBST();
        System.out.println("Print Tree before deleting node with value " + nodeToBeDeleted);
        treeNode.print();

        System.out.println("\n\nPrint Tree after deleting node with value " + nodeToBeDeleted);
        Node updatedTreeNode = deleteNodeBST(treeNode, nodeToBeDeleted);
        updatedTreeNode.print();
    }
    
}
