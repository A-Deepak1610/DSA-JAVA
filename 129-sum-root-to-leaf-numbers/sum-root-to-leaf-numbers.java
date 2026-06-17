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
    public int sumNumbers(TreeNode root) {
        return dfs(root,0,0);
    }
    private int dfs(TreeNode root,int currNum,int totalSum){
        if(root==null)return 0;
        currNum=currNum*10+root.val;
        if(root.left==null&&root.right==null){
            totalSum+=currNum;
        }
        return totalSum+dfs(root.left,currNum,totalSum)+dfs(root.right,currNum,totalSum);
    }
}