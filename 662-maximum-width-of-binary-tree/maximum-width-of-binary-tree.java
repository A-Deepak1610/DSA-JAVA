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
    int idx;
    TreeNode node;
    Pair(TreeNode node,int idx){
        this.idx=idx;
        this.node=node;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair>queue=new LinkedList<>();
        int maxWidth=0;
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            int n=queue.size();
            int minIdx=queue.peek().idx;
            int first=0,last=0;
            for(int i=0;i<n;i++){
                Pair p=queue.poll();
                int idx=p.idx-minIdx;
                if(i==0)first=idx;
                if(i==n-1)last=idx;
                if(p.node.left!=null){
                    queue.add(new Pair(p.node.left,2*idx+1));
                }
                if(p.node.right!=null){
                    queue.add(new Pair(p.node.right,2*idx+2));
                }
            }
            maxWidth=Math.max(maxWidth,last-first+1);
        }
        return maxWidth;
    }
}