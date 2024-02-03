package Tawheed2024.Blind75;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

public class TreeDrawer {
    
    public static void main(String[] args) {
        //Integer[] array = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Integer[] array = {3, null, 1, null, 2, null, 8, null, 7, null};
        TreeNode root = TreeUtil.buildTree(array);

        // Draw the tree in the console
        TreeUtil.drawTree(root);
    }
}

