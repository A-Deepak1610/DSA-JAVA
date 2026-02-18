class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l=1,r=maxSum;
        int max=1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int leftLength=index;
            int rightLength=n-index-1;
            long sum=getSum(mid,leftLength);
             sum+=getSum(mid,rightLength);
            sum+=mid;
            if(sum<=maxSum){
                max=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return max;
    }
    private long getSum(int mid,int n){
        long  sum=0;
        if(n<mid){
            sum=(long)n*(mid-1+mid-n)/2;
        }
        else{
            sum=((long)mid-1)*(mid)/2;
            sum+=(n-(mid-1))*1;
        }
        return sum;
    }
}