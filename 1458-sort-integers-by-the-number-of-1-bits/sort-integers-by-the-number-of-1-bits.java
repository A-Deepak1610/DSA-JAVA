class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int[][] count=new int[n][2];
        for(int i=0;i<n;i++) {
            count[i]=new int[]{arr[i],Integer.bitCount(arr[i])};
        }
        Arrays.sort(count,(a,b)->a[1]-b[1]);
        for(int i=0;i<n;i++)arr[i]=count[i][0];
        return arr;
    }
}