class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[] heights=new int[n];
        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1')heights[j]++;
                else heights[j]=0;
            }
            maxArea=Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<=n;i++){
            int current=i==n?0:heights[i];
            while(!stack.isEmpty()&&heights[stack.peek()]>current){
                int right=i;
                int height=heights[stack.pop()];
                int left=stack.isEmpty()?-1:stack.peek();
                int side=Math.min(height,right-left-1);
                maxArea=Math.max(maxArea,side*side);
            }
            stack.push(i);
        }
        return maxArea;
    }
}