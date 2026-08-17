class Solution {
    int mod=(int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] dp=new int[locations.length][fuel+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(locations,start,finish,fuel,dp);
    }
    private int solve(int[] locations,int start,int finish,int fuel,int[][] dp){
        if(fuel<0)return 0;
        int count=(start==finish)?1:0;
        if(dp[start][fuel]!=-1)return dp[start][fuel];
        for(int i=0;i<locations.length;i++){
            if(i!=start){
                count=(count+solve(locations,i,finish,fuel-Math.abs(locations[start]-locations[i]),dp))%mod;
            }
        }
        return dp[start][fuel]=count;
    }
}