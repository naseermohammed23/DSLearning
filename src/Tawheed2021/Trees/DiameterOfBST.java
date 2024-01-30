package Trees;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * Diameter of a Binary Tree -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc0NTI4NzM4OTcw/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class DiameterOfBST {
    
    public static class Node {

        Node left;
        Node right;
    
        int value;
        Node(int val) {
            this.value = val;
        }
    
    }

    public static void main(String[] args) {
        findDiameterOfBST1();       
        findDiameterOfBST2();   
        findDiameterOfBST3();   
    }


    /**
                    20
                   /  \  
                  8    22
                /   \ 
               4    12
                   /  \
                 10    14
    **/
    static void findDiameterOfBST1() {
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

        System.out.println("Diameter of BST " + (findDiameterHelper(root, 0)+1));

    }


    /**
                    1
                   /  \  
                  2    3
                /   \ 
               4    5
    **/
    static void findDiameterOfBST2() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println("Diameter of BST " + (findDiameterHelper(root, 0)+1));

    }


    /**
                    1
                   /  \  
                  2    3
                /   \ 
               4    5
                   /  \
                 6     7
                /       \
              11         8
              /           \
             12            9 
            /               \
           13                10
          /
         14
    **/
    static void findDiameterOfBST3() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        Node node9 = new Node(10);
        Node node10 = new Node(11);
        Node node11 = new Node(12);
        Node node12 = new Node(13);
        Node node13 = new Node(14);
        
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node4.left = node5;
        node5.left = node10;
        node10.left = node11;
        node11.left = node12;
        node12.left = node13;

        node4.right = node6;
        node6.right = node7;
        node7.right = node8;
        node8.right = node9;

        System.out.println("Diameter of BST " + (findDiameterHelper(root, 0)+1));

    }


    /**
     * Helper method to determine the diameter of the given BST.
     * @param node
     * @param result
     * @return
     */
    static int findDiameterHelper(Node node, int result) {

        if (node == null) return 0;

        int left = findDiameterHelper(node.left, result);

        int right = findDiameterHelper(node.right, result);

        result = Math.max(result, 1 + left + right);

        return 1 + Math.max(left , right);

    }
    
}
