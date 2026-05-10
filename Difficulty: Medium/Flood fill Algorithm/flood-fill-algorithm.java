class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length,n=image[0].length;
        int startColor=image[sr][sc];
        if(startColor==newColor)
            return image;
        dfs(image,sr,sc,startColor,newColor);
        return image;
    }
    private void dfs(int[][] image,int i,int j,int startColor,int newColor){
        image[i][j]=newColor;
        if(i>0&&image[i-1][j]==startColor){//left
            dfs(image,i-1,j,startColor,newColor);
        }
        if(i<image.length-1&&image[i+1][j]==startColor){//right
            dfs(image,i+1,j,startColor,newColor);
        }
        if(j>0&&image[i][j-1]==startColor){//top
            dfs(image,i,j-1,startColor,newColor);
        }
        if(j<image[0].length-1&&image[i][j+1]==startColor){//bottom
            dfs(image,i,j+1,startColor,newColor);
        }
    }
}