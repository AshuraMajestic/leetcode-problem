/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
    private int dfs(TreeNode node,int maxValue){
        int res;
        if(node==null){
            return 0;
        }
        if(node.val>=maxValue){
            res=1;
        }else{
            res=0;
        }
        maxValue=Math.max(node.val,maxValue);
        res+=dfs(node.left,maxValue);
        res+=dfs(node.right,maxValue);
        return res;
    }
}
