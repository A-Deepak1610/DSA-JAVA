/*
class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    public boolean isHeap(Node root) {
        if(!isCompleteTree(root))return false;
        if(!dfs(root))return false;
        return true;
    }
    private boolean isCompleteTree(Node root){
        Queue<Node>queue=new LinkedList<>();
        queue.add(root);
        boolean isFoundNull=false;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node node=queue.poll();
                if(node==null)isFoundNull=true;
                else {
                    if(isFoundNull)return false;
                    queue.add(node.left); 
                    queue.add(node.right);
                }
                
            }
        }
        return true;
    }
    private boolean dfs(Node root){
        if(root==null)return true;
        if(root.left!=null&&root.left.data>root.data)return false;
        if(root.right!=null&&root.right.data>root.data)return false;
        return dfs(root.left)&&dfs(root.right);
    }
}