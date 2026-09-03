class Solution {
    int[][] dp;
    public int findLength(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        dp=new int[n1][n2];
        for(int[] d:dp)Arrays.fill(d,-1);
        int maxLen=0;
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                int len=solve(nums1,nums2,i,j);
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
    private int solve(int[] nums1,int[] nums2,int i,int j){
        if(i==nums1.length||j==nums2.length)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int len;
        if(nums1[i]==nums2[j])len=1+solve(nums1,nums2,i+1,j+1);
        else len=0;
        return dp[i][j]=len;
    }
}