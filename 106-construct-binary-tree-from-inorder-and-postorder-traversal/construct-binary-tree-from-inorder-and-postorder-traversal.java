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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)map.put(inorder[i],i);
        TreeNode root=buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
    private TreeNode buildTree(int[] postOrder,int postStart,int postEnd,int[] inOrder,int inStart,int inEnd,Map<Integer,Integer> map){
       if(postStart>postEnd||inStart>inEnd)return null;
       TreeNode root=new TreeNode(postOrder[postEnd]);
       int inRoot=map.get(root.val);
       int numsLeft=inRoot-inStart;
       root.left=buildTree(postOrder,postStart,postStart+numsLeft-1,inOrder,inStart,inRoot-1,map);
       root.right=buildTree(postOrder,postStart+numsLeft,postEnd-1,inOrder,inRoot+1,inEnd,map);
       return root;
    }
}
