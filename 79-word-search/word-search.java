class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,0))return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word ,int i, int j, int idx){
        if(idx==word.length())return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length)return false;
        if (board[i][j] != word.charAt(idx))return false;
        char ch=board[i][j];
        board[i][j]='#';
        for(int k=0;k<4;k++){
            if(dfs(board,word,i+dr[k],j+dc[k],idx+1)){
                return true;
            }
        }
        board[i][j]=ch;
        return false;
    }
}