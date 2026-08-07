class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return numDecodings(s,0,dp,n);
    }
    private int numDecodings(String s,int st,int[] dp,int n){
        if(st==n)return 1;
        if(dp[st]!=-1)return dp[st];
        char ch=s.charAt(st);
        if(s.charAt(st)=='0')
            return 0;
        int ways=numDecodings(s,st+1,dp,n);
        if(st+1<s.length()){
            int num=((ch-'0')*10)+(s.charAt(st+1)-'0');
            if(num>=10&&num<=26){                    
                ways+=numDecodings(s,st+2,dp,n);          
            }
        }
        dp[st]=ways;
        return dp[st];
    }
}