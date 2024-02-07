package Trees;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

public class BalancedBinaryTree {
    

    public static void main(String[] args) {
        System.out.println(isBalancedBinaryTree(TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7})));
    }


    public static boolean isBalancedBinaryTree(TreeNode root) {

        if (root == null) return true;

        int left = TreeUtil.height(root.left);
        int right = TreeUtil.height(root.right);

        if (Math.abs(left - right) <= 1 && 
            isBalancedBinaryTree(root.left) && 
            isBalancedBinaryTree(root.right)) {
                return true;
        }

        return false;
        
    }
}
