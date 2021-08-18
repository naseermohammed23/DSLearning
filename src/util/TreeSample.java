package util;

public class TreeSample {

    /** Binary Tree.  
                      1
                    /   \  
                  2       3
                /   \    /  \
               4    5   6    7
                         \
                          8
    **/
    public static Node getBinaryTree() {
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
    public static Node getBST() {
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
    
}
