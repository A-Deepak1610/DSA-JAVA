class Solution {
    public int minimumPushes(String word) {
        int count=0,fact=1,tf=0,k=0;
        int[] freq=new int[26];
        for(char ch:word.toCharArray())freq[ch-'a']++;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--){
            if(freq[i]==0)break;
            count+=fact*freq[i];
            k++;
            if(k%8==0)fact++;
        }
        return count;
    }
}