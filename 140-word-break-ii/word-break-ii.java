class Solution {
    Boolean[] dp;
    Set<String> set;
     List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        res=new ArrayList<>();
        dp=new Boolean[s.length()];
        solve(s,set,0);
        backtrack(s,0,new StringBuilder());
        return res;
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
    private void backtrack(String s ,int st,StringBuilder curr){
        if(st==s.length()){
            if(curr.length()>0){
                curr.deleteCharAt(curr.length()-1);
                res.add(curr.toString());
            }
            return;
        }
        for(int i=st;i<s.length();i++){
            String word=s.substring(st,i+1);
            if(set.contains(word)){
                int len=curr.length();
                curr.append(word).append(" ");
                backtrack(s, i + 1, curr);
                curr.setLength(len);
            }
        }
    }
}