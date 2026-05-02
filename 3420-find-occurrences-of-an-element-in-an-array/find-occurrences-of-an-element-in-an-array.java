class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int freq=1;
        int n=queries.length;
        int l=nums.length;
        int[] result=new int[n];
        int j=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x) map.put(freq++,i);
        }
        int i=0;
        while(j<n){
            if(map.containsKey(queries[j])){
                result[j]=map.get(queries[j]);
            }
            else result[j]=-1;
            j++;
        }
        return result;
    }
}