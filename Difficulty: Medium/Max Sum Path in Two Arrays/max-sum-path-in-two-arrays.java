class Solution {
    public int maxPathSum(int[] a, int[] b) {
        int maxSum=0;
        int sumA=0,sumB=0;
        int n1=a.length,n2=b.length;
        int i=0,j=0;
        while(i<n1&&j<n2){
            if(a[i]<b[j])sumA+=a[i++];
            else if(b[j]<a[i])sumB+=b[j++];
            else {
                maxSum+=Math.max(sumA,sumB)+a[i];
                i++;
                j++;
                sumA=0;sumB=0;
            }
        }
        while(i<n1)sumA+=a[i++];
        while(j<n2)sumB+=b[j++];
        maxSum+=Math.max(sumA,sumB);
        return maxSum;
    }
}