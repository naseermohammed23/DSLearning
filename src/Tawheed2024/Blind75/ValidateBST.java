package Tawheed2024.Blind75;



public class ValidateBST {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root, root.left.val, root.right.val);
    }

    boolean isBST(TreeNode node, Integer leftValue, Integer rightValue) {

        if (node == null) return true;

       // The current node's value must be between low and high.
       if ((leftValue != null && node.val <= leftValue) || (rightValue != null && node.val >= rightValue)) return false;

        if (!isBST(node.left, leftValue, node.val)) return false;

        if (!isBST(node.right, node.val, rightValue)) return false;

        return true;

    }

    
}
