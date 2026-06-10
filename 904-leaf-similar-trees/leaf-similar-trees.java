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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer>leafNodes1=new ArrayList<>();
        ArrayList<Integer>leafNodes2=new ArrayList<>();
        dfs(leafNodes1,root1);
        dfs(leafNodes2,root2);
        return leafNodes1.equals(leafNodes2);
    }
    private void dfs(List<Integer> list,TreeNode root){
        if(root==null)return ;
        if(root.left==null&&root.right==null){
            list.add(root.val);
            return;
        }
        dfs(list,root.left);
        dfs(list,root.right);
    }
}