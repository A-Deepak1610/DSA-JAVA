public class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2; 
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            for (int j = layer; j < n - layer; j++) {
                elements.add(grid[layer][j]);
            }
            for (int i=  layer + 1; i<m-layer;i++){
                elements.add(grid[i][n - 1 - layer]);
            }
            if (m - 1 - layer > layer) {
                for (int j = n - 2 - layer; j >= layer; j--) {
                    elements.add(grid[m - 1 - layer][j]);
                }
            }
            if (n - 1 - layer > layer) {
                for (int i = m - 2 - layer; i > layer; i--) {
                    elements.add(grid[i][layer]);
                }
            }
            int len = elements.size();
            int rot = k % len;
            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(elements.subList(rot, len));
            rotated.addAll(elements.subList(0, rot));
            int index = 0;
            for (int j = layer; j < n - layer; j++) {
                grid[layer][j] = rotated.get(index++);
            }
            for (int i = layer + 1; i < m - layer; i++) {
                grid[i][n - 1 - layer] = rotated.get(index++);
            }
            if (m - 1 - layer > layer) {
                for (int j = n - 2 - layer; j >= layer; j--) {
                    grid[m - 1 - layer][j] = rotated.get(index++);
                }
            }
            if (n - 1 - layer > layer) {
                for (int i = m - 2 - layer; i > layer; i--) {
                    grid[i][layer] = rotated.get(index++);
                }
            }
        }
        return grid;
    }
}