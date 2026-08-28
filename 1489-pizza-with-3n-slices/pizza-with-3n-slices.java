class Solution {
    int[][] dp;
    public int maxSizeSlices(int[] slices) {
        int k=slices.length/3;
        dp=new int[slices.length][k+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        int case1=solve(slices,0,k,slices.length-1); 
        dp=new int[slices.length][k+1];
        for(int[] d:dp)Arrays.fill(d,-1);
        int case2=solve(slices,1,k,slices.length); 
        return Math.max(case1,case2);
    }
    private int solve(int[] slices,int i,int k,int end){
        if(k==0||i>=end)return 0;
        if(dp[i][k]!=-1)return dp[i][k];
        int take=slices[i]+solve(slices,i+2,k-1,end);
        int notTake=solve(slices,i+1,k,end);
        return dp[i][k]=Math.max(take,notTake);
    }
}