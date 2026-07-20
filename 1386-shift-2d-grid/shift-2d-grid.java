class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total; 
       int[][] arr=new int[m][n];
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            int nrow=i,ncol=j+k;
            if(ncol>=n){
                nrow=nrow+(ncol/n);
                if(nrow>=m){
                    nrow=nrow%m;
                }
                ncol%=n;
            }
            arr[nrow][ncol]=grid[i][j];
        }
       }
       return (List)Arrays.asList(arr);
    }
}
