class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l=1,r=2000000000l;
        long ans=0;
        while(l<=r){
            long mid=l+(r-l)/2;
            long cn=count(mid,a,b,c);
            if(cn>=n){
                ans=mid;
                r=mid-1;
            } 
            else l=mid+1;
        }
        return (int)ans;
    }
    private long count(long mid,long a,long b,long c){
        return mid/a+mid/b+mid/c-mid/lcm(a,b)-mid/lcm(b,c)-mid/lcm(a,c)+mid/lcm(a,lcm(b,c));
    }
    private long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }
     private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}