package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class OrderTraverse {

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

        System.out.println("1. In Order Traverse - LCR");
        printInOrderTravers(root);
        System.out.println();

        System.out.println("2. Pre Order Traverse - CLR");
        printPreOrderTravers(root);
        System.out.println();

        System.out.println("3. Post Order Traverse - LRC");
        printPostOrderTravers(root);
        System.out.println();

        System.out.println("4. Print Level Order SameLine - BFS Single Queue");
        printLevelOrderSameLine(root);
        System.out.println();

        System.out.println("5. Print Level Order separate Line - BFS 2 Queue");
        Queue<Node> result = printLevelOrderSeparateLineWith2Queue(root);
        printNode(result);
        System.out.println();

        System.out.println("6. Print Level Order separate Line - BFS Single Queue using count");
        printLevelOrderSeparateLineWithCount(root);
        System.out.println();        
    }



    /**
     * 1. Print Tree values in In-order
     * @param node
     */
    static void printInOrderTravers(Node node) {

        if (node == null) {
            return ;
        }

        // traverse left.. 
        printInOrderTravers(node.left);

        // process current node
        System.out.print(node.value + ",");

        // traverse right 
        printInOrderTravers(node.right);
    }

    /**
     * 2. Print Tree values in Pre-order
     * @param node
     */
    static void printPreOrderTravers(Node node) {

        if (node == null) {
            return ;
        }

        // process current node
        System.out.print(node.value + ",");

        // traverse left.. 
        printPreOrderTravers(node.left);

        // traverse right 
        printPreOrderTravers(node.right);
    }


    /**
     * 3. Print Tree values in Post-order
     * @param node
     */
    static void printPostOrderTravers(Node node) {

        if (node == null) {
            return ;
        }

        // traverse left.. 
        printPostOrderTravers(node.left);

        // traverse right 
        printPostOrderTravers(node.right);

        // process current node
        System.out.print(node.value + ",");
    }

    /**
     * 4. Print Level order on same line (use BFS, single queue method)
     * @param root
     */
    static void printLevelOrderSameLine(Node root) {
        if (root == null) {
            return ;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (true) {

            if (queue.size() == 0) {
                break;
            }

            while (queue.size() > 0) {

                Node  node = queue.peek();
                System.out.print(node.value + " ");
                queue.remove();

                if (node.left != null) 
                    queue.add(node.left);
                
                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }
    
    /**
     * 5. Print Level order on separate line; each level on separate line (use BFS, two queues method)
     * @param root
     */
    static Queue<Node> printLevelOrderSeparateLineWith2Queue(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> outputQueue = new LinkedList<>();
        queue.add(root);

        
        while (true) {

            int count = queue.size();

            if (count == 0) {
                break;
            }

            while (count > 0) {

                Node  node = queue.peek();
                outputQueue.add(node);
                queue.remove();

                if (node.left != null) 
                    queue.add(node.left);
                
                if (node.right != null)
                    queue.add(node.right);

                count--;
            }

            outputQueue.add(null);
        }
        return outputQueue;
    }

    /**
     * helper method to print the queue.. 
     * @param result
     */
    static void printNode(Queue<Node> result) {
        while (result.size() > 0) {
            Node node = result.peek();
            result.remove();
            if (node == null) {
                System.out.println();
            } else {
                System.out.print(node.value+" ");
            }
        }
    }


    /**
     * 6. Print Level order on separate line; each level on separate line (use BFS, single queue using count)
     * @param root
     */
    static void printLevelOrderSeparateLineWithCount(Node root) {
        if (root == null) {
            return ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        
        while (true) {

            int count = queue.size();

            if (count == 0) {
                break;
            }

            while (count > 0) {

                Node  node = queue.peek();
                System.out.print(node.value + " ");
                queue.remove();

                if (node.left != null) 
                    queue.add(node.left);
                
                if (node.right != null)
                    queue.add(node.right);

                count--;
            }

            System.out.println();
        }
    }

}
