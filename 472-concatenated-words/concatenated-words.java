class Solution {
    Set<String> set;
    Boolean[] dp;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String>res=new ArrayList<>();
        set=new HashSet<>(Arrays.asList(words));
        for(String s:words){
            set.remove(s);
            dp=new Boolean[s.length()];
            if(solve(s,0))res.add(s);
            set.add(s);
        }
        return res;
    }
    private boolean solve(String s,int st){
        if(st==s.length())return true;
        if(dp[st]!=null)return dp[st];
        for(int i=st;i<s.length();i++){
            String prefix=s.substring(st,i+1);
            if(set.contains(prefix)&&solve(s,i+1))return dp[i]=true;
        }
        return dp[st]=false;
    }
}