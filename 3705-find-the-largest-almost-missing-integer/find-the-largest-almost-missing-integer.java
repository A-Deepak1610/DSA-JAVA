class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums)map.put(num,map.getOrDefault(num,0)+1);
        if(k==1){
            int max=-1;
            for(Integer key:map.keySet()){
                if(map.get(key)==1)max=Math.max(max,key);
            }
            return max;
        }
        else if(k==nums.length){
            return Arrays.stream(nums).max().getAsInt();
        } 
        else{
            int f1=map.get(nums[0]);
            int f2=map.get(nums[nums.length-1]);
            if(f1==1&&f2==1)return Math.max(nums[0],nums[nums.length-1]);
            else if(f1==1)return nums[0];
            else if(f2==1)return nums[nums.length-1];
            else return -1;
        }
    }
}