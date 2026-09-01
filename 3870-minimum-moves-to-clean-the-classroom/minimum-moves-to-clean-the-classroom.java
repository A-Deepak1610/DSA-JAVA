class State {
        int row;
        int col;
        int energy;
        int mask;
        int moves;
        State(int row, int col, int energy, int mask, int moves) {
            this.row = row;
            this.col = col;
            this.energy = energy;
            this.mask = mask;
            this.moves = moves;
        }
}
class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startRow = -1;
        int startCol = -1;
        int[][] litterId = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
        }
        int litterCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                }
                if (ch == 'L') {
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
            }
        }
        int allCollected = (1 << litterCount) - 1;
        boolean[][][][] visited =
                new boolean[m][n][1 << litterCount][energy + 1];
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(
                new State(
                        startRow,
                        startCol,
                        energy,
                        0,
                        0
                )
        );
        visited[startRow][startCol][0][energy] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int r = current.row;
            int c = current.col;
            int currentEnergy = current.energy;
            int mask = current.mask;
            int moves = current.moves;
            if (mask == allCollected) {
                return moves;
            }
            if (currentEnergy == 0) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n) {
                    continue;
                }
                char nextCell = classroom[nr].charAt(nc);
                if (nextCell == 'X') {
                    continue;
                }
                int newEnergy = currentEnergy - 1;
                int newMask = mask;
                if (nextCell == 'L') {
                    int id = litterId[nr][nc];
                    newMask = mask | (1 << id);
                }
                if (nextCell == 'R') {
                    newEnergy = energy;
                }
                if (!visited[nr][nc][newMask][newEnergy]) {
                    visited[nr][nc][newMask][newEnergy] = true;
                    queue.offer(
                            new State(
                                    nr,
                                    nc,
                                    newEnergy,
                                    newMask,
                                    moves + 1
                            )
                    );
                }
            }
        }
        return -1;
    }
}