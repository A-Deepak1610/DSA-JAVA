class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int[] prefix=new int[n+1];
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)prefix[i+1]=prefix[i]+nums.get(i);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=l;i<=n;i++){
            int add=prefix[i-l];
            map.put(add,map.getOrDefault(add,0)+1);
            int removeIdx=i-r-1;
            if(removeIdx>=0){
                int count=map.get(prefix[removeIdx]);
                if(count==1)map.remove(prefix[removeIdx]);
                else map.put(prefix[removeIdx],count-1);
            }
            Integer key=map.lowerKey(prefix[i]);
            if(key!=null)minSum=Math.min(minSum,prefix[i]-key);
        }
        return minSum==Integer.MAX_VALUE?-1:minSum;
    }
}