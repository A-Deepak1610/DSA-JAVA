class Solution {
    public static int countPairs(int arr[], int k) {
        Arrays.sort(arr);
        int l=0;
        int count=0;
        for(int r=0;r<arr.length;r++){
            while(l<r&&arr[r]-arr[l]>=k)l++;
            count+=(r-l);
        }
        return count;
    }
}
