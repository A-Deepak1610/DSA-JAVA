class Node{
    Node[] link=new Node[26];
    int count=0;
}
class Solution {
    Node root=new Node();
    public int[] sumPrefixScores(String[] words) {
        int n=words.length;
        for(String word:words)insert(word);
        int[] res=new int[n];
        for(int i=0;i<words.length;i++){
            res[i]=count(words[i]);
        }
        return res;
    }
    private int count(String s){
        int sum=0;
        Node node=root;
        for(char ch:s.toCharArray()){
            sum+=node.link[ch-'a'].count;
            node=node.link[ch-'a'];
        }
        return sum;
    }
    private void insert(String word){
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.link[ch-'a']==null)node.link[ch-'a']=new Node();
            node=node.link[ch-'a'];
            node.count++;
        }
    }
}