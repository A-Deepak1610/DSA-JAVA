class Pair{
    int score,age;
    Pair(int score,int age){
        this.score=score;
        this.age=age;
    }
}
class Solution {
    int[] dp;
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++) pair[i]=new Pair(scores[i],ages[i]);
        Arrays.sort(pair,(a,b)->{
            if(a.age==b.age)return a.score-b.score;
            return a.age-b.age;
            });
        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,solve(pair,i));
        }
        return ans;
    }
    private int solve(Pair[] pair,int idx){
        if(dp[idx]!=-1)return dp[idx];
        int score=pair[idx].score;
        for(int i=idx+1;i<pair.length;i++){
            if(pair[i].score>=pair[idx].score){
                score=Math.max(score,solve(pair,i)+pair[idx].score);
            }
        }
        return dp[idx]=score;
    }
}