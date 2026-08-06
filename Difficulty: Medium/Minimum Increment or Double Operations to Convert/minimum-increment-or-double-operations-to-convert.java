class Solution {
    public int countMinOperations(int nums[]) {
        int ops=0;
        while(true){
            if(nonZero(nums))break;
            for(int i=0;i<nums.length;i++){
                if(nums[i]%2!=0){
                    ops++;
                    nums[i]--;
                }
            }
            if(!nonZero(nums)){
                for(int i=0;i<nums.length;i++){
                    nums[i]/=2;
                }
                ops++;
            }
        }
        return ops;
    }
    private boolean nonZero(int[] nums){
       boolean allZero=true;
        for(int num:nums){
            if(num!=0){
                allZero=false;
                break;
            }
        }
        return allZero;
    }
}