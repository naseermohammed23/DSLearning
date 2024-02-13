package Trees.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TreeUtil class to have some basic utility functions to solve Tree problems. 
 */
public class TreeUtil {

    
    /**
     * Public method to find the distance between root and the given node value. 
     * @param node
     * @param node1
     * @return
     */
    public static int distance(TreeNode node, TreeNode node1) { 
        return distanceHelper(node, node1, 0);
    }

    /**
     * Private Helper method to find the distance between root and the given node value in a Binary tree.
     * @param node
     * @param node1
     * @param distance
     * @return
     */
    private static int distanceHelper(TreeNode node, TreeNode node1, int distance) {

        if (node == null) return 0;

        if (node.val == node1.val) return distance;

        return Math.max(distanceHelper(node.left, node1, distance+1), distanceHelper(node.right, node1, distance+1));
    }

    /**
     * Public method to find minimum node from the given BST.
     * @param node
     * @return
     */
    public static TreeNode minNodeBST(TreeNode node) {
        if (node == null) return null;

        if (node.left == null) return node;

        return minNodeBST(node.left);
    }

    /**
     * Public method to find minimum node value from the given BST.
     * @param node
     * @return
     */
    public static int minNodeValueBST(TreeNode node) {
        TreeNode minNode = minNodeBST(node);
        return minNode != null ? minNode.val : 0;
    }


    public static List<Integer> findPathNode(TreeNode root, TreeNode node) {
        List<Integer> pathList = new ArrayList<>();
        
        if (findPathNode(root, node, pathList)) {
            return pathList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * A Recursive method to print all paths in the tree 
     * @param root
     * @param result
     */
    private static boolean findPathNode(TreeNode root, TreeNode node, List<Integer> pathList) {
    
        if (root == null) return false;

        System.out.print(root.val+" ");
        pathList.add(root.val);

        if (root.val == node.getVal()) return true;

        if (findPathNode(root.left, node, pathList) || findPathNode(root.right, node, pathList)) {
            return true;
        }

        // removing the last added node. 
        pathList.remove(pathList.size() - 1);

        return false;
    }



    /**
     * to find the least common ancestor between 2 given nodes in a binary tree. 
     * @param root
     * @param node
     * @param node2
     * @return
     */
    public static TreeNode findLeastCommonAncestor(TreeNode root, TreeNode node, TreeNode node2) {

        List<Integer> node1Path = TreeUtil.findPathNode(root, node);
        System.out.println();

        List<Integer> node2Path = TreeUtil.findPathNode(root, node2);
        System.out.println();

        int lca = -1;

        for (int i=0,j=0; ;i++,j++) {
            if (node1Path.size() < i || node2Path.size() < j || node1Path.get(i) != node2Path.get(j)) {
                lca = node1Path.get(i);
                break;
            }
        }

        return new TreeNode(lca);
    }

    /**
     * Print Level order on separate line; each level on separate line (use BFS, single queue using count)
     * @param root
     */
    public static void printLevelOrderSeparateLineWithCount(TreeNode root) {
        if (root == null) {
            return ;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        
        while (true) {

            int count = queue.size();

            if (count == 0) {
                break;
            }

            while (count > 0) {

                TreeNode  node = queue.peek();
                System.out.print(node.val + " ");
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

    /**
     * get Tree values in In-order
     * @param node
     */
    public static List<Integer> getInOrderTraversList(TreeNode node, List<Integer> result) {

        if (node == null) {
            return null;
        }

        // traverse left.. 
        getInOrderTraversList(node.left, result);

        // process current node
        System.out.print(node.val + ",");
        result.add(node.val);

        // traverse right 
        getInOrderTraversList(node.right, result);

        return result;
    }

    /**
     * get Tree values in Pre-order
     * @param node
     */
    public static List<Integer> getPreOrderTraversList(TreeNode node, List<Integer> result) {

        if (node == null) {
            return null;
        }

        // process current node
        System.out.print(node.val + ",");
        result.add(node.val);

        // traverse left.. 
        getPreOrderTraversList(node.left, result);

        // traverse right 
        getPreOrderTraversList(node.right, result);

        return result;
    }

    // to build a tree from the integer array 
    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < array.length) {
            TreeNode current = queue.poll();

            if (index < array.length && array[index] != null) {
                current.left = new TreeNode(array[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < array.length && array[index] != null) {
                current.right = new TreeNode(array[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    // to build a tree from the string array 
    public static TreeNode buildTree(String[] array) {
        if (array == null || array.length == 0 || array[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < array.length) {
            TreeNode current = queue.poll();

            if (index < array.length && !array[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(array[index]));
                queue.offer(current.left);
            }
            index++;

            if (index < array.length && !array[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(array[index]));
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    // to draw the tree on console horizontally
    public static void drawTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        printTree(root, 0);
    }

    // to draw the tree on console horizontally
    private static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        printTree(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(node.val);

        printTree(node.left, level + 1);
    }


    // to verify if the give tree is Binary Search Tree
    public static boolean isBST(TreeNode node, Integer leftValue, Integer rightValue) {

        if (node == null) return true;

       // The current node's val must be between low and high.
       if ((leftValue != null && node.val <= leftValue) || (rightValue != null && node.val >= rightValue)) return false;

        if (!isBST(node.left, leftValue, node.val)) return false;

        if (!isBST(node.right, node.val, rightValue)) return false;

        return true;

    }


    // to find size of a tree
    public static int size(TreeNode node) {

        if (node == null) return 0;

        return 1 + size(node.left) + size(node.right);
    }

    // max depth of the Binary Tree
    public static int height(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }
}
