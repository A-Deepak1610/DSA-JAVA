class Solution {
    public int findCoverage(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            boolean isOne=false;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1)isOne=true;
                else if(isOne)count++;
                
            }
            isOne=false;
            for(int j=n-1;j>=0;j--){
                if(mat[i][j]==1)isOne=true;
                else if(isOne)count++;
            }
        }
        for(int j=0;j<n;j++){
            boolean isOne=false;
            for(int i=0;i<m;i++){
                if(mat[i][j]==1)isOne=true;
                else if(isOne)count++;
                
            }
            isOne=false;
            for(int i=m-1;i>=0;i--){
                if(mat[i][j]==1)isOne=true;
                else if(isOne)count++;
            }
        }
        return count;
    }
}