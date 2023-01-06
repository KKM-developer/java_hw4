import java.util.Stack;

public class task2 {
    int[][] STEPS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid) {
        int count = 0;
        Stack<int[]> satck = new Stack<>();
        satck.push(new int[]{i, j});
        grid[i][j] = 0;
        while (!satck.isEmpty()) {
            int[] cur = satck.pop();
            int curI = cur[0];
            int curJ = cur[1];

            count++;

            for (int[] step : STEPS) {
                int newI = curI + step[0];
                int newJ = curJ + step[1];
                if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length
                        && grid[newI][newJ] == 1) {
                    grid[newI][newJ] = 0;
                    satck.push(new int[]{newI, newJ});
                }
            }
        }
        return count;
    }
}