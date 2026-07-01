class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            if(!isMaxHeap(arr,n,i))return false;
        }
        return true;
    }
    private boolean isMaxHeap(int[] arr,int n,int i){
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[left]>arr[i])return false;
        if(right<n&&arr[right]>arr[i])return false;
        return true;
    }
}