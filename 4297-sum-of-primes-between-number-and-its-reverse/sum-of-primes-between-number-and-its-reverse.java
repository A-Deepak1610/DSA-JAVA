class Solution {
    public int sumOfPrimesInRange(int n) {
        int sum=0;
        int r=0,temp=n;
        while(temp>0){
            r=r*10+temp%10;
            temp/=10;
        }
        for(int i=Math.min(r,n);i<=Math.max(r,n);i++){
            if(isPrime(i))sum+=i;
        }
        return sum;
    }
    private boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
}