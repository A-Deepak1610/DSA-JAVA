class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp=new Boolean[s.length()][s.length()+1];
        return dfs(s,0,0);
    }
    private boolean dfs(String s,int open,int index){
        if(open<0)return false;
        if(index==s.length())return open==0;
        if(dp[index][open]!=null)return dp[index][open];
        char ch=s.charAt(index);
        boolean valid;
        if(ch=='('){
            valid=dfs(s,open+1,index+1);
        }
        else if(ch==')'){
            valid=dfs(s,open-1,index+1);
        }
        else{
            valid=dfs(s,open+1,index+1)||dfs(s,open-1,index+1)||dfs(s,open,index+1);
        }
        return dp[index][open]=valid;
    }
}