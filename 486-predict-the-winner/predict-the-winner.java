class Solution {
    public boolean predictTheWinner(int[] nums) {
        return backTrack(nums,0,nums.length-1,0,0,true);
    }
    private boolean backTrack(int[] nums,int st,int ed,int score1,int score2,boolean player1){
        if(st>ed){
            return score1>=score2;
        }
        if(player1)
        return backTrack(nums,st+1,ed,score1+nums[st],score2,false)||backTrack(nums,st,ed-1,score1+nums[ed],score2,false);
        else  return backTrack(nums,st+1,ed,score1,score2+nums[st],true)&&backTrack(nums,st,ed-1,score1,score2+nums[ed],true);
    }
}