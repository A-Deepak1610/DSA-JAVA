class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> worddict=new HashSet(wordDict);
        dp=new Boolean[s.length()];
        return solve(s,worddict,0);
    }
    private boolean solve(String s,Set<String> wordDict,int st){
        if(st==s.length())return true;
        if(dp[st]!=null)return dp[st];
        for(int i=st;i<s.length();i++){
            String word=s.substring(st,i+1);
            if(wordDict.contains(word)){
                if(solve(s,wordDict,i+1))return dp[st]=true;
            }
        }
        return dp[st]=false;
    }
}