package Trees;

import Trees.util.TreeNode;
import Trees.util.TreeSample;

public class BinaryTreeVerticalSum {
    
    public static void main(String[] args) {

        verticalSum(TreeSample.getBinaryTree());

    }

    private static void verticalSum(TreeNode binaryTree) {

        int sum = verticalSumHelper(binaryTree, 0);

    }

    private static int verticalSumHelper(TreeNode binaryTree, int i) {


        verticalSum(binaryTree);

        return 0;
    }

}
