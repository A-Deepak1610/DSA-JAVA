class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid=new String[m];
        grid[0]=String.valueOf('.').repeat(n);
        for(int i=1;i<m;i++){
            String curr="";
            for(int j=0;j<n;j++){
                if(j==n-1)curr=curr+".";
                else{
                    curr=curr+"#";
                }
            }
            grid[i]=curr;
        }
        return grid;
    }
}