class Solution {
	ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
		int m = mat.length, n = mat[0].length;
		int[][] prefixSum = new int[m + 1][n + 1];
		for (int i = 0; i<m; i++) {
			for (int j = 0; j<n; j++) {
				prefixSum[i + 1][j + 1] = mat[i][j];
				prefixSum[i + 1][j + 1] += prefixSum[i][j + 1];
				prefixSum[i + 1][j + 1] += prefixSum[i + 1][j];
				prefixSum[i + 1][j + 1] -= prefixSum[i][j];
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int[] q:queries) {
			int len = 1;
			int i = q[0];
			int j = q[1];
			int radius = 0;
			int ans=1;
			while (true) {
				int top = i - radius;
                int bottom = i + radius;
                int left = j - radius;
                int right = j + radius;
                if (top < 0 || bottom >= m || left < 0 || right >= n) {
                    break;
                }
                int ones =
                    prefixSum[bottom + 1][right + 1]
                    - prefixSum[top][right + 1]
                    - prefixSum[bottom + 1][left]
                    + prefixSum[top][left];
                if (ones > k) {
                    break;
                }
                ans = 2 * radius + 1;
                radius++;
			}
			if(radius==0)res.add(-1);
			else res.add(ans);
		}
		return res;
	}
}
