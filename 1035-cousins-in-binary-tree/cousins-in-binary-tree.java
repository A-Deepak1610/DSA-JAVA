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
    int depth;
    TreeNode node;
    Pair(int depth,TreeNode node){
        this.depth=depth;
        this.node=node;
    }
 }
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int level=1;
        Pair pair1=null,pair2=null;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                    if(node.left.val==x||node.left.val==y){
                        if(pair1==null)pair1=new Pair(level,node);
                        else pair2=new Pair(level,node);
                    }
                }
                if(node.right!=null){
                    queue.add(node.right);
                    if(node.right.val==x||node.right.val==y){
                        if(pair1==null)pair1=new Pair(level,node);
                        else pair2=new Pair(level,node);
                    }
                }
            }
            level++;
        }
        if(pair1==null||pair2==null)return false;
        if(pair1.depth==pair2.depth&&pair1.node!=pair2.node)return true;
        return false;
    }
}