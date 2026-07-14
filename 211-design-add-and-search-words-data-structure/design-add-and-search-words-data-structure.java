class Node{
    Node[] child=new Node[26];
    boolean isEnd=false;

}
class WordDictionary {
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.child[ch-'a']==null){
                node.child[ch-'a']=new Node();
            }
            node=node.child[ch-'a'];
        }
        node.isEnd=true;
    }
    
    public boolean search(String word) {
       return dfs(word,0,root);
    }
    private boolean dfs(String word,int i,Node root){
        if(i==word.length())return root.isEnd;
        char ch=word.charAt(i);
        if(ch!='.'){
            if(root.child[ch-'a']==null)return false;
            return dfs(word,i+1,root.child[ch-'a']);
        }
        for(Node children:root.child){
            if(children!=null&&dfs(word,i+1,children))return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */