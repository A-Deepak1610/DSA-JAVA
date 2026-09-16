class Solution {
    int[] cuts;
    int[][] dp;
    public int minCost(int n, int[] cut) {
        Arrays.sort(cut);
        int m=cut.length;
        cuts=new int[m+2];
        cuts[0]=0;
        cuts[m+1]=n;
        dp=new int[m+2][m+2];
        for(int i=0;i<m;i++){
            cuts[i+1]=cut[i];
        }
        for(int[] d:dp)Arrays.fill(d,-1);
        return solve(0,m+1);
    }
    private int solve(int i,int j){
        if(j-i==1)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int minCost=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost=cuts[j]-cuts[i]+solve(i,k)+solve(k,j);
            minCost=Math.min(minCost,cost);
        }
        return dp[i][j]=minCost;
    }
}