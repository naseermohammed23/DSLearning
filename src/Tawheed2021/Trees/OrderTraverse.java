package Trees;

import java.util.LinkedList;
import java.util.Queue;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 07, 2021 - Assignment
 * 
 * Tree Traversal -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MTYzNDU4/details
 * 
 * @author Naseer Mohammed Abdul 
 */
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(22);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(14);
        
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
        Queue<TreeNode> result = printLevelOrderSeparateLineWith2Queue(root);
        printNode(result);
        System.out.println();

        System.out.println("6. Print Level Order separate Line - BFS Single Queue using count");
        TreeUtil.printLevelOrderSeparateLineWithCount(root);
        System.out.println();        
    }



    /**
     * 1. Print Tree values in In-order
     * @param node
     */
    static void printInOrderTravers(TreeNode node) {

        if (node == null) {
            return ;
        }

        // traverse left.. 
        printInOrderTravers(node.left);

        // process current node
        System.out.print(node.val + ",");

        // traverse right 
        printInOrderTravers(node.right);
    }

    /**
     * 2. Print Tree values in Pre-order
     * @param node
     */
    static void printPreOrderTravers(TreeNode node) {

        if (node == null) {
            return ;
        }

        // process current node
        System.out.print(node.val + ",");

        // traverse left.. 
        printPreOrderTravers(node.left);

        // traverse right 
        printPreOrderTravers(node.right);
    }


    /**
     * 3. Print Tree values in Post-order
     * @param node
     */
    static void printPostOrderTravers(TreeNode node) {

        if (node == null) {
            return ;
        }

        // traverse left.. 
        printPostOrderTravers(node.left);

        // traverse right 
        printPostOrderTravers(node.right);

        // process current node
        System.out.print(node.val + ",");
    }

    /**
     * 4. Print Level order on same line (use BFS, single queue method)
     * @param root
     */
    static void printLevelOrderSameLine(TreeNode root) {
        if (root == null) {
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (true) {

            if (queue.size() == 0) {
                break;
            }

            while (queue.size() > 0) {

                TreeNode  node = queue.peek();
                System.out.print(node.val + " ");
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
    static Queue<TreeNode> printLevelOrderSeparateLineWith2Queue(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> outputQueue = new LinkedList<>();
        queue.add(root);

        
        while (true) {

            int count = queue.size();

            if (count == 0) {
                break;
            }

            while (count > 0) {

                TreeNode  node = queue.peek();
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
    static void printNode(Queue<TreeNode> result) {
        while (result.size() > 0) {
            TreeNode node = result.peek();
            result.remove();
            if (node == null) {
                System.out.println();
            } else {
                System.out.print(node.val+" ");
            }
        }
    }


    

}
