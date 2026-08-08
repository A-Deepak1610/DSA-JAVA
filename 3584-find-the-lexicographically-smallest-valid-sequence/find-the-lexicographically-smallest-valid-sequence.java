class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] last=new int[m];
        int j=m-1;
        for(int i=n-1;i>=0;i--){
            if(j>=0&&word1.charAt(i)==word2.charAt(j)){
                last[j--]=i;
            }
        }
        j=0;
        int[] ans=new int[m];
        boolean changed=false;
        for(int i=0;i<n&&j<m;i++){
            if(word1.charAt(i)==word2.charAt(j)){
                ans[j++]=i;
            }
            else if(!changed && (j==m-1||i+1<=last[j+1])){
                ans[j++]=i;
                changed=true;
            }
        }
        if(j!=m)return new int[0];
        return ans;
    }
}