class Solution {
    Map<String,Integer>map=new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return backTrack(nums,0,0,target);
    }
    private int backTrack(int[] nums,int index,int sum,int target){
        if(index==nums.length){
            if(sum==target) return 1;
            return 0;
        }
        String key=index+","+sum;
        if(map.containsKey(key))return map.get(key);
        int add=backTrack(nums,index+1,sum+nums[index],target);
        int sub=backTrack(nums,index+1,sum-nums[index],target);
        map.put(key,add+sub);
        return add+sub;
    }
}