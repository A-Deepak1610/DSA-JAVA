class Solution {
    public int maxTask(int[] h, int[] l) {
      int[][] dp=new int[l.length][2];
      for(int[] d:dp)Arrays.fill(d,-1);
      return maxTask(h,l,0,false,dp);
    }
    private int maxTask(int[] h,int[] l,int i,boolean preTask,int[][] dp){
        if(i>=l.length)return 0;
        if(dp[i][preTask?0:1]!=-1)return dp[i][preTask?0:1];
        int noTask=maxTask(h,l,i+1,false,dp);
        int lowTask=l[i]+maxTask(h,l,i+1,true,dp);
        int highTask=0;
        if(!preTask){
            highTask=h[i]+maxTask(h,l,i+1,true,dp);
        }
        return dp[i][preTask?0:1]=Math.max(noTask,Math.max(lowTask,highTask));
    }
}