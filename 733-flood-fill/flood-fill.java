class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = color;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return image;
    }
}