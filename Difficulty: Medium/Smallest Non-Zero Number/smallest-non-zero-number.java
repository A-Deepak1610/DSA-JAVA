class Solution {
    public int find(int[] arr) {
        // code here
        int need=0;
        for(int i=arr.length-1;i>=0;i--){
            need=(arr[i]+need+1)/2;
        }
        return need;
    }
}
