/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    int maxDiff(Node root) {
        Map<Node,Integer>map=new HashMap<>();
        dfs(root,map);
        int maxDif=Integer.MIN_VALUE;
        for(Node node:map.keySet()){
            maxDif=Math.max(maxDif,node.data-map.get(node));
        }
        return maxDif;
    }
    private int dfs(Node root,Map<Node,Integer> map){
        if(root.left==null&&root.right==null)return root.data;
        int leftMin=Integer.MAX_VALUE;
        int rightMin=Integer.MAX_VALUE;
        if(root.left!=null){
            leftMin=dfs(root.left,map);
        }
        if(root.right!=null){
            rightMin=dfs(root.right,map);
        }
        int min=Math.min(rightMin,leftMin);
        map.put(root,min);
        return Math.min(root.data,min);
    }
}