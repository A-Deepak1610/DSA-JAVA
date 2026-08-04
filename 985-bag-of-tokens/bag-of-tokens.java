class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int l=0,r=n-1,score=0,maxScore=0;
        while(l<=r){
            if(tokens[l]<=power){
                power-=tokens[l++];
                score++;
            }
            else if(score==0)break;
            else {
                power+=tokens[r--];
                score--;
            }
            maxScore=Math.max(score,maxScore);
        }
        return maxScore;
    }
}