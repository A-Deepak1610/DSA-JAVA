class Solution {
    public int gcdOfOddEvenSums(int n) {
        // int oddSum=n*n;
        // int evenSum=n+n*n;
        return n;
    }
    private int gcd(int a,int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}