package trees;

import trees.util.Node;
import trees.util.TreeSample;

public class BinaryTreeVerticalSum {
    
    public static void main(String[] args) {

        verticalSum(TreeSample.getBinaryTree());

    }

    private static void verticalSum(Node binaryTree) {

        int sum = verticalSumHelper(binaryTree, 0);

    }

    private static int verticalSumHelper(Node binaryTree, int i) {


        verticalSum(binaryTree);

        return 0;
    }

}
