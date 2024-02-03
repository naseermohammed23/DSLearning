package Tawheed2024.Blind75;

import java.util.ArrayDeque;
import java.util.Deque;

import Trees.util.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
        
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }

        //process the root node 
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        Deque<String> stack = new ArrayDeque<>();
        for(int i=dataArray.length-1; i>=0; i--) {
            stack.push(dataArray[i]);
        }
        return deserialize(stack);
    }
        
    TreeNode deserialize(Deque<String> stack) {

            if(stack.isEmpty()) {
                return null;
            }

            String valStr = stack.pop();
            if (valStr.equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(valStr));
            root.left = deserialize(stack);
            root.right = deserialize(stack);

            return root;
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));