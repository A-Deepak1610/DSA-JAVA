class Solution {
    public int maxDistance(int[] position, int m) {
        int min=Arrays.stream(position).min().orElse(0);
        int max=Arrays.stream(position).max().orElse(0);
        Arrays.sort(position);
        int l=1,r=max-min;
        int force=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(countBall(position,mid)>=m){
                force=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return force;
    }
    private int countBall(int[] arr,int k){
        int count=1,d=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=d+k){
                count++;
                d=arr[i];
            }
        }
        return count;
    }
}