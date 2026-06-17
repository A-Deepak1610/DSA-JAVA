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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(root,0,new ArrayList<>(),targetSum,res);
        return res;
    }
    private void dfs(TreeNode root,int currSum,List<Integer> path,int targetSum,List<List<Integer>> res){
        if(root==null)return;
        currSum+=root.val;
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(currSum==targetSum){
                res.add(new ArrayList<>(path));
            }
        }
        dfs(root.left,currSum,path,targetSum,res);
        dfs(root.right,currSum,path,targetSum,res);
        path.remove(path.size()-1);
    }
}