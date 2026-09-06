class Solution {
    Set<String> set;
    Map<String,Integer> dp;
    public int longestStrChain(String[] words) {
        set=new HashSet<>();
        dp=new HashMap<>();
        for(String s:words)set.add(s);
        int maxLen=0;
        for(String s:words){
            maxLen=Math.max(maxLen,1+solve(s));
        }
        return maxLen;
    }
    private int solve(String s){
        if(dp.containsKey(s))return dp.get(s);
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            String predecessor=s.substring(0,i)+s.substring(i+1,s.length());
            if(set.contains(predecessor)){
                maxLen=Math.max(maxLen,1+solve(predecessor));
            }
        }
        dp.put(s,maxLen);
        return maxLen;
    }
}