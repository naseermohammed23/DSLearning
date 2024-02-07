package Trees;

import java.util.ArrayList;
import java.util.List;

import Trees.util.TreeNode;
import Trees.util.TreeSample;
import Trees.util.TreeUtil;

/**
 * Tawheed TIPS Summer 2021
 * Aug, 14, 2021 - Assignment
 * 
 * Rebuild the tree -
 * https://classroom.google.com/c/MzcwMjU4Mzg4ODE0/a/Mzc1Njc3MjQzOTUz/details
 * 
 * @author Naseer Mohammed Abdul 
 */
public class RebuildBinaryTree {   


    /**
     * To Rebuild the Binary Tree from the iven in-order List and pre-order List of a given tree node. 
     * @param inList - in-order list 
     * @param preList - pre-order list
     * @return
     */
    public static TreeNode rebuildBT(List<Integer> inList, List<Integer> preList) {

        return rebuildBTHelper(inList, 0, inList.size()-1, preList, 0, preList.size()-1);
    }

    public static TreeNode rebuildBT(int[] preList, int[] inList) {

        return rebuildBTHelper(preList, 0, preList.length-1, inList, 0, inList.length-1);
    }

    /**
     * Private helper method to rebuild the BT. 
     * @param inList- in-order list 
     * @param inStart - start index of in-order list 
     * @param inEnd - end index of the in-order list 
     * @param preList - pre-order list 
     * @param preStart - start index of pre-order list 
     * @param preEnd - end index of the pre-order list
     * @return
     */
    private static TreeNode rebuildBTHelper(List<Integer> inList, int inStart, int inEnd, List<Integer> preList, int preStart, int preEnd) {
        

        if (inStart > inEnd) return null;

        int rootValue = preList.get(preStart);
        int rootIdx = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if (inList.get(i) == rootValue) {
                rootIdx = i;
                break;
            }
        }        

        int len = rootIdx - inStart;
        
        TreeNode node = new TreeNode(rootValue);
        node.left = rebuildBTHelper(inList, inStart, rootIdx-1, preList, preStart + 1, preStart+len);
        node.right = rebuildBTHelper(inList, rootIdx+1, inEnd, preList, preStart+len+1, preEnd);
        

        return node;
    }

    private static TreeNode rebuildBTHelper(int[] preList, int preStart, int preEnd, int[] inList, int inStart, int inEnd) {
        

        if (inStart > inEnd) return null;

        int rootValue = preList[preStart];
        int rootIdx = 0;
        
        for (int i = inStart; i <= inEnd; i++) {
            if (inList[i] == rootValue) {
                rootIdx = i;
                break;
            }
        }        

        int len = rootIdx - inStart;
        
        TreeNode node = new TreeNode(rootValue);
        node.left = rebuildBTHelper(preList, preStart + 1, preStart+len, inList, inStart, rootIdx-1);
        node.right = rebuildBTHelper(preList, preStart+len+1, preEnd, inList, rootIdx+1, inEnd);
        

        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeSample.getBinaryTree();

        List<Integer> inList = TreeUtil.getInOrderTraversList(treeNode, new ArrayList<>());

        System.out.println();

        List<Integer> preList = TreeUtil.getPreOrderTraversList(treeNode, new ArrayList<>());

        TreeNode node = rebuildBT(inList, preList);

        System.out.println();

        TreeUtil.printLevelOrderSeparateLineWithCount(node);

        TreeNode root = rebuildBT(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        
        System.out.println();

        TreeUtil.printLevelOrderSeparateLineWithCount(root);
    }    
}
