class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length,l=matrix[0][0],r=matrix[n-1][n-1];
        int element=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(countElement(matrix,mid)<k)l=mid+1;
            else{
                element=mid;
                r=mid-1;
            }
        }
        return element;
    }
    private int countElement(int[][] arr,int k){
        int n=arr.length;
        int row=n-1,col=0,count=0;
        while(row>=0&&col<n){
            if(arr[row][col]<=k){
                count+=row+1;
                col++;
            }
            else row--;
        }
        return count;
    }
}