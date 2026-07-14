class Node{
    Node[] link=new Node[2];

}
class Solution {
    Node root=new Node();
    public int findMaximumXOR(int[] nums) {
        for(int num:nums)insert(num);
        int maxXor=0;
        for(int num:nums){
            maxXor=Math.max(maxXor,getMax(num));
        }
        return maxXor;
    }
    private void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.link[bit]==null){
                node.link[bit]=new Node();
            }
            node=node.link[bit];
        }
    }
    private int getMax(int num){
        Node node=root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.link[1-bit]!=null){
                maxNum = maxNum | (1<<i);
                node=node.link[1-bit];
            }
            else node=node.link[bit];
        }
        return maxNum;
    }
}