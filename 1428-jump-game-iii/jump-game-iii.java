class Solution {
    Boolean[] dp;
    boolean[] visited;
    public boolean canReach(int[] arr, int start) {
        dp=new Boolean[arr.length];
        visited=new boolean[arr.length];
        return solve(arr,start);
    }
    private boolean solve(int[] arr,int idx){
        if(arr[idx]==0){
            return dp[idx]=true;
        }
        if(dp[idx]!=null)return dp[idx];
        int n1=arr[idx]+idx;
        int n2=idx-arr[idx];
        if(n1>=0&&n1<arr.length&&!visited[n1]){
            visited[n1]=true;
            if(solve(arr,n1))return dp[idx]=true;
        }
        if(n2>=0&&n2<arr.length&&!visited[n2]){
            visited[n2]=true;
            if(solve(arr,n2))return dp[idx]=true;
        }
        return dp[idx]=false;
    }
}