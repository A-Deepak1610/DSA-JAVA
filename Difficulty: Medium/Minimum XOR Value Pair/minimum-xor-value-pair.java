class Node{
    Node[] link=new Node[2];

}
class Solution {
    Node root=new Node();
    public int minXor(int[] nums) {
        insert(nums[0]);
        int minXOR=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            minXOR=Math.min(minXOR,getMin(nums[i]));
            insert(nums[i]);
        }
        return minXOR;
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
    private int getMin(int num){
        Node node=root;
        int minXOR=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.link[bit]!=null){
                node=node.link[bit];
            }
            else {
                minXOR = minXOR | (1<<i);
                node=node.link[1-bit];
            }
        }
        return minXOR;
    }
}