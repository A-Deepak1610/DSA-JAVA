class Solution {
    public long pairAndSum(int[] arr) {
        long ans=0;
        for(int i=0;i<32;i++){
            long k=0;
            for(int n:arr){
                if(((n>>i)&1)==1)k++;
            }
            ans+=(long)(1<<i)*(k*(k-1)/2);
        }
        return ans;
    }
}