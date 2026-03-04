class Solution {
    public int numSpecial(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        String[] row=new String[m];     
        String[] col=new String[n];
        for(int i=0;i<m;i++) row[i] = "";
        for(int j=0;j<n;j++) col[j] = "";
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    row[i]=row[i]+(i+","+j);
                    col[j]=col[j]+(i+","+j);
                    
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    if((i+","+j).equals(row[i])&&(i+","+j).equals(col[j]))count++;
                }
            }
        }
        return count;
    }
}