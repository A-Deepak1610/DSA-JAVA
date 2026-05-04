class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){//transpose
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //and then reverse
        for(int i=0;i<n;i++){
            reverse(matrix,i);
        }
    }
    private void reverse(int[][] matrix,int i){
        int s=0;
        int e=matrix.length-1;
        while(s<e){
            int temp=matrix[i][s];
            matrix[i][s]=matrix[i][e];
            matrix[i][e]=temp;
            s++;
            e--;
        }
    }
}