class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            Integer bitCount=Integer.bitCount(i);
            if(isPrime(bitCount))count++;
        }
        return count;
    }
    private boolean isPrime(int n){
        if(n<2)return false;
        if(n==2)return true;
        for(int i=2;i<n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}