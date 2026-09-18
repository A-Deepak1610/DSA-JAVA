class Solution {
    public int minimumDifference(int[] nums, int k) {
        Set<Integer> prev=new HashSet<>();
        int ans=Integer.MAX_VALUE;
        for(int num:nums){
            Set<Integer> curr=new HashSet<>();
            curr.add(num);
            for(int val:prev)curr.add(val|num);
            for(int val:curr){
                ans=Math.min(ans,Math.abs(k-val));
            }
            prev=curr;
        }
        return ans;
    }
}