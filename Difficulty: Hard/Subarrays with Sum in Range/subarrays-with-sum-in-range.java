class Solution {
    public int countSubarray(int[] arr, int l, int r) {
        int rcnt=countSubarray(arr,r);
        int lcnt=countSubarray(arr,l-1);
        return rcnt-lcnt;
    }
    private int countSubarray(int[] arr,int k){
        int l=0,count=0,sum=0;
        for(int r=0;r<arr.length;r++){
            sum+=arr[r];
            while(sum>k)sum-=arr[l++];
            count+=(r-l);
        }
        return count;
    }
}