class State{
    String s;
    int idx;
    State(String s,int idx){
        this.s=s;
        this.idx=idx;
    }
}
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int ans=0;
        Queue<State>[] bucket=new LinkedList[26];
        for(int i=0;i<26;i++) bucket[i]=new LinkedList<>();
        for(String str:words) bucket[str.charAt(0)-'a'].add(new State(str,0));
        for(char ch:s.toCharArray()){
            Queue<State> q=bucket[ch-'a'];
            int size=q.size();
            while(size-->0){
                State curr=q.poll();
                curr.idx++;
                if(curr.idx==curr.s.length())ans++;
                else{
                    char next=curr.s.charAt(curr.idx);
                    bucket[next-'a'].add(curr);
                }
            }
        }
        return ans;
    }
}