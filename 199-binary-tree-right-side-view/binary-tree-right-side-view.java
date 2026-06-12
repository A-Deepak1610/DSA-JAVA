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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>rightView=new ArrayList<>();
        if(root==null)return rightView;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            int num=0;
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
                num=node.val;
            }
            rightView.add(num);
        }
        return rightView;
    }
}