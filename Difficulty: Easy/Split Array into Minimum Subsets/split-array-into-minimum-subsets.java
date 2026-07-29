class Solution {
    int minSubsets(int arr[]) {
        Arrays.sort(arr);
        int count=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]+1!=arr[i])count++;
        }
        return count+1;
    }
}