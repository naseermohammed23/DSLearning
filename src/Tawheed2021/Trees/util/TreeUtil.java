package trees.util;

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
     * @param nodeValue
     * @return
     */
    public static int distance(Node node, int nodeValue) { 
        return distanceHelper(node, nodeValue, 0);
    }

    /**
     * Private Helper method to find the distance between root and the given node value in a Binary tree.
     * @param node
     * @param nodeValue
     * @param distance
     * @return
     */
    private static int distanceHelper(Node node, int nodeValue, int distance) {

        if (node == null) return 0;

        if (node.value == nodeValue) return distance;

        return Math.max(distanceHelper(node.left, nodeValue, distance+1), distanceHelper(node.right, nodeValue, distance+1));
    }

    /**
     * Public method to find minimum node from the given BST.
     * @param node
     * @return
     */
    public static Node minNodeBST(Node node) {
        if (node == null) return null;

        if (node.left == null) return node;

        return minNodeBST(node.left);
    }

    /**
     * Public method to find minimum node value from the given BST.
     * @param node
     * @return
     */
    public static int minNodeValueBST(Node node) {
        Node minNode = minNodeBST(node);
        return minNode != null ? minNode.value : 0;
    }


    public static List<Integer> findPathNode(Node root, int nodeValue) {
        List<Integer> pathList = new ArrayList<>();
        
        if (findPathNode(root, nodeValue, pathList)) {
            return pathList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * A Recursive method to print all paths in the tree 
     * @param node
     * @param result
     */
    private static boolean findPathNode(Node node, int nodeValue, List<Integer> pathList) {
    
        if (node == null) return false;

        pathList.add(node.value);

        if (node.value == nodeValue) return true;

        if (findPathNode(node.left, nodeValue, pathList) || findPathNode(node.right, nodeValue, pathList)) {
            return true;
        }

        // removing the last added node. 
        pathList.remove(pathList.size() - 1);

        return false;
    }



    /**
     * to find the least common ancestor between 2 given nodes in a binary tree. 
     * @param root
     * @param node1Value
     * @param node2Value
     * @return
     */
    public static int findLeastCommonAncestor(Node root, int node1Value, int node2Value) {

        List<Integer> node1Path = TreeUtil.findPathNode(root, node1Value);

        List<Integer> node2Path = TreeUtil.findPathNode(root, node2Value);

        int lca = -1;

        for (int i=0,j=0; ;i++,j++) {
            if (node1Path.get(i) != node2Path.get(j)) {
                lca = node1Path.get(i-1);
                break;
            }
        }

        return lca;
    }

    /**
     * Print Level order on separate line; each level on separate line (use BFS, single queue using count)
     * @param root
     */
    public static void printLevelOrderSeparateLineWithCount(Node root) {
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

    /**
     * get Tree values in In-order
     * @param node
     */
    public static List<Integer> getInOrderTraversList(Node node, List<Integer> result) {

        if (node == null) {
            return null;
        }

        // traverse left.. 
        getInOrderTraversList(node.left, result);

        // process current node
        System.out.print(node.value + ",");
        result.add(node.value);

        // traverse right 
        getInOrderTraversList(node.right, result);

        return result;
    }

    /**
     * get Tree values in Pre-order
     * @param node
     */
    public static List<Integer> getPreOrderTraversList(Node node, List<Integer> result) {

        if (node == null) {
            return null;
        }

        // process current node
        System.out.print(node.value + ",");
        result.add(node.value);

        // traverse left.. 
        getPreOrderTraversList(node.left, result);

        // traverse right 
        getPreOrderTraversList(node.right, result);

        return result;
    }
}
