class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l=1,r=m*n,num=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(countSmaler(m,n,mid)>=k){
                num=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return  num;
    }
    private int countSmaler(int m,int n,int k){
        int count=0;
        int row=m,col=1;
        while(row>0&&col<=n){
            if(row*col<=k){
                count+=row;
                col++;
            }
            else row--;
        }
        return count;
    }
}