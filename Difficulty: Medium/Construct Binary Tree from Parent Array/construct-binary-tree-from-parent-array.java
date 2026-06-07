
/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    Node createTree(int[] parent) {
        int n=parent.length;
        Node root=null;
        Node[] nodes=new Node[n];
        for(int i=0;i<n;i++)nodes[i]=new Node(i);
        for(int i=0;i<n;i++){
            int par=parent[i];
            if(par==-1)root=nodes[i];
            else{
                if(nodes[par].left==null)nodes[par].left=nodes[i];
                else nodes[par].right=nodes[i];
            }
        }
        return root;
    }
}
