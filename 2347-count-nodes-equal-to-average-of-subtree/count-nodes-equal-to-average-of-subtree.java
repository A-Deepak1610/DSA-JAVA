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
 class Pair{
    int sum,n;
    Pair(int sum,int n){
        this.sum=sum;
        this.n=n;
    }
 }
class Solution {
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        average(root);
        return count;
    }
    private Pair average(TreeNode root){
        int sum=0,n=1;
        if(root.left!=null){
            Pair p=average(root.left);
            sum+=p.sum;
            n+=p.n;
        }
        if(root.right!=null){
            Pair p=average(root.right);
            sum+=p.sum;
            n+=p.n;
        }
        if((sum+root.val)/(n)==root.val)count++;
        return new Pair(sum+root.val,n);
    }
}