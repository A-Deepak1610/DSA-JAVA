class Solution {
    public int maxSum(int n) {
        return maxValue(n,n);
    }
    private int maxValue(int n,int max){
        if(n==0)return max;
        int n1=n/2,n2=n/3,n3=n/4;
        n1=Math.max(maxValue(n1,n1),n1);
        n2=Math.max(maxValue(n2,n2),n2);
        n3=Math.max(maxValue(n3,n3),n3);
        max=Math.max(n1+n2+n3,max);
        return max;
    }
}
