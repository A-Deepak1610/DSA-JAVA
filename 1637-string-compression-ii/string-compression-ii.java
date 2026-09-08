class Solution {
    int[][][][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        dp=new int[s.length()][26][s.length()+1][k+1];
        for(int[][][] d1:dp){
            for(int[][] d2:d1){
                for(int[] d3:d2)Arrays.fill(d3,-1);
            }
        }
        return dfs(s,0,'z',0,k);
    }
    private int dfs(String s,int index,char prev,int count,int k){
        if(index==s.length())return 0;
        int delete=Integer.MAX_VALUE;
        if(dp[index][prev-'a'][count][k]!=-1)return dp[index][prev-'a'][count][k];
        if(k>0){
            delete=dfs(s,index+1,prev,count,k-1);
        }
        char ch=s.charAt(index);
        int keep;
        if(ch==prev){
            boolean extra=(count==1||count==9||count==99);
            keep=(extra?1:0)+dfs(s,index+1,prev,count+1,k);
        }
        else{
            keep=1+dfs(s,index+1,ch,1,k);
        }
        return dp[index][prev-'a'][count][k]=Math.min(delete,keep);
    }
}