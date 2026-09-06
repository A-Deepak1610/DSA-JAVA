class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] dp=new int[26];
        int continous=0,answer=0;
        for(int i=0;i<s.length();i++){
            if(i>0&&(s.charAt(i)-s.charAt(i-1)==1||s.charAt(i)-s.charAt(i-1)==-25)){
                continous++;
            }
            else{
                continous=1;
            }
            int idx=s.charAt(i)-'a';
            if(continous>dp[idx]){
                answer+=continous-dp[idx];
                dp[idx]=continous;
            }
        }
        return answer;
    }
}