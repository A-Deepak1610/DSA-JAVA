class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum=0,prefixEven=1,prefixOdd=0;
        int oddSubArrSum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++){
            sum=(sum+arr[i])%mod;
            if(sum%2!=0){
                oddSubArrSum+=prefixEven;
                prefixOdd++;
            }
            else {
                oddSubArrSum+=prefixOdd;
                prefixEven++;
            }
            oddSubArrSum%=mod;
        }
        return oddSubArrSum;
    }
}