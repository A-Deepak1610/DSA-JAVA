class Node{
    Node[] link=new Node[26];
    String word;
}
class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    Node root=new Node();
    public List<String> findWords(char[][] board, String[] words) {
        for(String s:words)insert(s);
        List<String> ans=new ArrayList<>();
        for(int  i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,ans);
            }
        }
        return ans;
    }
    private void dfs(char[][] board,int i,int j,Node node,List<String> ans){
        if(i<0||i>=board.length||j<0||j>=board[0].length)return ;
        char ch=board[i][j];
        if(ch=='#')return;
        if(node.link[ch-'a']==null)return;
        if(node.link[ch-'a'].word!=null){
            ans.add(node.link[ch-'a'].word);
            node.link[ch-'a'].word=null;
        }
        node=node.link[ch-'a'];
        board[i][j]='#';
        for(int k=0;k<4;k++){
            dfs(board,i+dr[k],j+dc[k],node,ans);
        }
        board[i][j]=ch;
    }
    private void insert(String s){
        Node node=root;
        for(char ch:s.toCharArray()){
            if(node.link[ch-'a']==null)node.link[ch-'a']=new Node();
            node=node.link[ch-'a'];
        }
        node.word=s;
    }
}