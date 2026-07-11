class Solution {
	int maxPathLen =-1 ;
	public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
		int n = mat.length, m = mat[0].length;
		boolean[][] visited = new boolean[n][m];
		backTrack(mat, xs, ys, xd, yd, n, m, 0, visited);
		return maxPathLen;
	}
	private void backTrack(int[][] mat, int xs, int ys, int xd, int yd, int n, int m, int currLen, boolean[][] visited) {
		if (mat[xs][ys] == 0 || visited[xs][ys])return;
		if (xs == xd && ys == yd) {
			maxPathLen = Math.max(maxPathLen, currLen);
			return;
		}
		visited[xs][ys]=true;
		if (xs>0){
		    backTrack(mat, xs - 1, ys, xd, yd, n, m, currLen + 1, visited);
		}
		if (xs<n - 1){
		    backTrack(mat, xs + 1, ys, xd, yd, n, m, currLen + 1, visited);
		}
		if (ys>0){
		    backTrack(mat, xs, ys - 1, xd, yd, n, m, currLen + 1, visited);
		}
		if (ys<m - 1){
		    backTrack(mat, xs, ys + 1, xd, yd, n, m, currLen + 1, visited);
		}
		visited[xs][ys]=false;
	}
}
