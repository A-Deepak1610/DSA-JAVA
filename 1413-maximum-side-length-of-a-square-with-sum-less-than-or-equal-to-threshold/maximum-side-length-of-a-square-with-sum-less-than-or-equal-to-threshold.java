class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length,n=mat[0].length;
        int[][] arr=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i+1][j+1]=mat[i][j];
                arr[i+1][j+1]+=arr[i][j+1];
                arr[i+1][j+1]+=arr[i+1][j];
                arr[i+1][j+1]-=arr[i][j];
            }
        }
        int l=0,r=Math.min(m,n);
        int len=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isValid(arr,mid,m,n,threshold)){
                len=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return len;
    }
    private boolean isValid(int[][] arr,int mid,int m,int n,int k){
        for(int i=mid;i<=m;i++){
            for(int j=mid;j<=n;j++){
                int sum=arr[i][j]-arr[i-mid][j]-arr[i][j-mid]+arr[i-mid][j-mid];
                if(sum<=k)return true;
            }
        }
        return false;
    } 
}