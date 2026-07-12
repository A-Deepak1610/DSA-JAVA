class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] cpy=arr.clone();
        int n=arr.length;
        Arrays.sort(cpy);
        Map<Integer,Integer>map=new HashMap<>();
        int rank=1;
        for(int i=0;i<n;i++){
            map.put(cpy[i],rank);
            if(i<n-1&&cpy[i]<cpy[i+1])rank++;
        }
        for(int i=0;i<n;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}