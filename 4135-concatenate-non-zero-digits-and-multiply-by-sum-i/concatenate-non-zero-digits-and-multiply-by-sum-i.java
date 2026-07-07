class Solution {
    public long sumAndMultiply(int n) {
        long val=0,sum=0;
        while(n>0){
            int r=n%10;
            if(r!=0){
                sum+=r;
                val=val*10+r;
            }
            n/=10;
        }
        long res=0;
        while(val>0){
            res=res*10+val%10;
            val/=10;
        }
        return res*sum;
    }
}