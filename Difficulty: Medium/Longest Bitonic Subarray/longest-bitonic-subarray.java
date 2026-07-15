class Solution {
    public int bitonic(int[] arr) {
        int n=arr.length;
        int[] inc=new int[n];
        int[] dsc=new int[n];
        int maxLen=1;
        inc[0]=1;
        dsc[n-1]=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[i-1])inc[i]=inc[i-1]+1;
            else inc[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=arr[i+1])dsc[i]=dsc[i+1]+1;
            else dsc[i]=1;
        }
        for(int i=0;i<n;i++){
            maxLen=Math.max(maxLen,inc[i]+dsc[i]-1);
        }
        return maxLen;
    }
}