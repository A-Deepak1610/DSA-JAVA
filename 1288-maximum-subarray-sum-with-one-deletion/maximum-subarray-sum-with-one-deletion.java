class Solution {
    public int maximumSum(int[] arr) {
        int noDelete=arr[0],oneDelete=-1000000;
        int maxSum=arr[0];
        for(int i=1;i<arr.length;i++){
            int currOneDelete=Math.max(noDelete,oneDelete+arr[i]);
            int currNoDelete=Math.max(arr[i],arr[i]+noDelete);
            oneDelete=currOneDelete;
            noDelete=currNoDelete;
            maxSum=Math.max(maxSum,Math.max(noDelete,oneDelete));
        }
        return maxSum;
    }
}