class Solution {
    public ArrayList<Integer> optimalArray(int[] arr) {
        ArrayList<Integer>res=new ArrayList<>();
        int n=arr.length;
        int[] prefixSum=new int[n];
        prefixSum[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        for(int i=0;i<n;i++){
            int mid=i/2;
            int median=arr[mid];
            int leftPart=median*(mid+1)-prefixSum[mid];
            int rightPart=prefixSum[i]-prefixSum[mid]-median*(i-mid);
            res.add(leftPart+rightPart);
        }
        return res;
    }
}
