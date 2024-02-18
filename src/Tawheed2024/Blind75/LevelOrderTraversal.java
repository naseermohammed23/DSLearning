package Tawheed2024.Blind75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Trees.util.TreeNode;
import Trees.util.TreeUtil;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>>  result = levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        //list.add(Arrays.asList(root.val));
        queue.add(root);
        int idx = 0;

        while (queue.size() > 0) {

            int n = (int)Math.pow(2, idx);
            List<Integer> l1 = new ArrayList<>();
            boolean isNodeAdded = false;
            for (int i=0;i<n;i++) {
                    
                TreeNode node = queue.peek();

                if (node == null) {
                    queue.remove();
                    break;
                }

                if (node != null) 
                    l1.add(node.val);

                if (node != null && node.left != null) {
                    queue.add(node.left);
                    isNodeAdded = true;
                }

                if (node != null && node.right != null) {
                    queue.add(node.right);
                    isNodeAdded = true;
                }
            
                queue.remove();
            }
            if (isNodeAdded && !queue.isEmpty())
                queue.add(null);
            
            if (!l1.isEmpty()) 
                list.add(l1);

            idx++;
        }
        
        return list;
    }

    //this is the best solution from leetcode... 
    // I modified the code to test how best it is.. 
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        //list.add(Arrays.asList(root.val));
        queue.add(root);
        
;
        while (queue.size() > 0) {
            int n = queue.size();
            List<Integer> l1 = new ArrayList<>();
            for(int i=0;i<n;i++) {
                TreeNode node = queue.remove();

                l1.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(l1);
            
        }
        
        return list;
    }*/
    
}