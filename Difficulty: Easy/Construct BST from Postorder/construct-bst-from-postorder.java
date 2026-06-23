/* Structure of tree node
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
    int idx=0;
    Node constructTree(int[] post) {
        idx=post.length-1;
        return build(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private Node build(int[] post,int low,int high){
        if(idx<0)return null;
        int val=post[idx];
        if(val<low||val>high)return null;
        idx--;
        Node node=new Node(val);
        node.right=build(post,val,high);
        node.left=build(post,low,val);
        return node;
    }
}
