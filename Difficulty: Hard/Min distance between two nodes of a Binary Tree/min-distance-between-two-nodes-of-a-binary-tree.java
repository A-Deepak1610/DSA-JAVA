/* A binary tree node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int findDist(Node root, int a, int b) {
        Node lca=lca(root,a,b);
        return distance(lca,a)+distance(lca,b);
    }
    private int distance(Node root,int a){
        if(root==null)return -1;
        if(root.data==a)return 0;
        int left=distance(root.left,a);
        if(left!=-1){
            return 1+left;
        }
        int right=distance(root.right,a);
        if(right!=-1){
            return 1+right;
        }
        return -1;
        
    }
    private Node lca(Node root,int a,int b){
        if(root==null||root.data==a||root.data==b){
            return root;
        }
        Node left=lca(root.left,a,b);
        Node right=lca(root.right,a,b);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;    
    }
}