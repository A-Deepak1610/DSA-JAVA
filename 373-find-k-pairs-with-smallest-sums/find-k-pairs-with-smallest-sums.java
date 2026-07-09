class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int n1:nums1)pq.add(new int[]{n1+nums2[0],0});
        while(k>0&&!pq.isEmpty()){
            int[] pair=pq.poll();
            int sum=pair[0],pos2=pair[1];
            List<Integer>curr=new ArrayList<>();
            curr.add(sum-nums2[pos2]);
            curr.add(nums2[pos2]);
            res.add(curr);
            k--;
            if(pos2+1<nums2.length)pq.add(new int[]{sum-nums2[pos2]+nums2[pos2+1],pos2+1});
        }
        return res;
    }
}