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
 class Tuple{
    int row,col;
    TreeNode node;
    Tuple(TreeNode node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>map=new TreeMap<>();
        Queue<Tuple>queue=new LinkedList<>();
        List<List<Integer>>list=new ArrayList<>();
        queue.add(new Tuple(root,0,0));
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Tuple t=queue.poll();
                if(t.node.left!=null)queue.add(new Tuple(t.node.left,t.row+1,t.col-1));
                if(t.node.right!=null)queue.add(new Tuple(t.node.right,t.row+1,t.col+1));
                map.putIfAbsent(t.col,new TreeMap<>());
                if(!map.get(t.col).containsKey(t.row))map.get(t.col).put(t.row,new PriorityQueue<>());
                map.get(t.col).get(t.row).add(t.node.val);
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            List<Integer>subList=new ArrayList<>();
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    subList.add(nodes.poll());
                }
            }
            list.add(subList);
        }
        return list;
    }
}