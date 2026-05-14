class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length,max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(nums[i]!=max&&map.get(nums[i])>1)return false;
            if(nums[i]==max&&map.get(nums[i])>2)return false;
        }
        return map.get(max)==2&&map.size()==max;
    }
}