class Solution {
    String[][] dp;
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1=str1.length(),n2=str2.length();
        dp=new String[n1][n2];
        String lcs=lcs(str1,str2,0,0);
        StringBuilder sb=new StringBuilder();
        int i=0,j=0;
        for(char ch:lcs.toCharArray()){
            while(i<n1&&str1.charAt(i)!=ch)sb.append(str1.charAt(i++));
            while(j<n2&&str2.charAt(j)!=ch)sb.append(str2.charAt(j++));
            sb.append(ch);
            i++;
            j++;
        }
        while(i<n1)sb.append(str1.charAt(i++));
        while(j<n2)sb.append(str2.charAt(j++));
        return sb.toString();
    }
    private String lcs(String s1,String s2,int i,int j){
        if(i==s1.length()||j==s2.length())return "";
        if(dp[i][j]!=null)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=s1.charAt(i)+lcs(s1,s2,i+1,j+1);
        else{
            String str1=lcs(s1,s2,i+1,j);
            String str2=lcs(s1,s2,i,j+1);
            if(str1.length()>str2.length())return dp[i][j]=str1;
            else return dp[i][j]=str2;
        }
    }
}