class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public boolean canCross(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length][stones.length];
        for(int i=0;i<stones.length;i++)map.put(stones[i],i);
        return solve(stones,0,1,dp);
    }
    private boolean solve(int[] stones,int i,int k,Boolean[][] dp){
        if(i==stones.length-1)return true;
        if(dp[i][k]!=null)return dp[i][k];
        for(int nxt=k-1;nxt<=k+1;nxt++){
            if(nxt<=0)continue;
            if(nxt==k+1&&i==0)continue;
            int nextPosition=stones[i]+nxt;
            if(map.containsKey(nextPosition)){
                if(solve(stones,map.get(nextPosition),nxt,dp))return dp[i][k]= true;
            }
        }
        return dp[i][k]=false;
    }
}