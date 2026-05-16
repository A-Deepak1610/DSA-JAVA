class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);
        int x=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>x+1)return x+1;
            x=x+arr[i];
        }
        return x+1;
    }
}