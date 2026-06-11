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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int count=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                arr[i]=node.val;
            }
            count+=minSwaps(arr);
        }
        return count;
    }
    private int minSwaps(int[] arr){
        int n=arr.length;
        int[][] pair=new int[n][2];
        for(int i=0;i<n;i++)pair[i]=new int[]{arr[i],i};
        Arrays.sort(pair,(a,b)->a[0]-b[0]);
        int swap=0;
        for(int i=0;i<n;i++){
            while(pair[i][1]!=i){
                int tempVal=pair[i][0];
                int tempIndex=pair[i][1];
                pair[i][0]=pair[tempIndex][0];
                pair[i][1]=pair[tempIndex][1];
                pair[tempIndex][0]=tempVal;
                pair[tempIndex][1]=tempIndex;
                swap++;
            }
        }
        return swap;
    }
}