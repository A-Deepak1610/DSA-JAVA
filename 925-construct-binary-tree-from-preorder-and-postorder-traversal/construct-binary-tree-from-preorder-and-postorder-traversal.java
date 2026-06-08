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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<postorder.length;i++)map.put(postorder[i],i);
        TreeNode root=buildTree(preorder,0,preorder.length-1,postorder,0,postorder.length-1,map);
        return root;
    }
    private TreeNode buildTree(int[] preOrder,int preStart,int preEnd,int[] postOrder,int postStart,int postEnd,Map<Integer,Integer> map){
       if(postStart>postEnd||preStart>preEnd)return null;
       TreeNode root=new TreeNode(preOrder[preStart]);
       if(preStart==preEnd)return root;
       int leftRoot=preOrder[preStart+1];
       int index=map.get(leftRoot);
       int numsLeft=index-postStart+1; 
       root.left=buildTree(preOrder,preStart+1,preStart+numsLeft,postOrder,postStart,index,map);
       root.right=buildTree(preOrder,preStart+numsLeft+1,preEnd,postOrder,index+1,postEnd-1,map);
       return root;
    }
}