class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    private int atMost(int[] nums,int k){
        Map<Integer,Integer>map=new HashMap<>();
        int count=0,l=0;
        for(int r=0;r<nums.length;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                int f=map.get(nums[l]);
                if(f==1)map.remove(nums[l]);
                else map.put(nums[l],f-1);
                l++;
            }
            count+=r-l+1;
        }
        return count;
    }
}