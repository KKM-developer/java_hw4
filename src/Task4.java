import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Task4 {
    int EMPTY = Integer.MAX_VALUE;

    public int[][] updateMatrix(int[][] mat) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int[][] steps = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = EMPTY;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            for (int[] step : steps) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];
                if (newRow >= 0 && newRow < mat.length && newCol >= 0 &&
                        newCol < mat[0].length &&
                        mat[newRow][newCol] == EMPTY) {
                    mat[newRow][newCol] = mat[curRow][curCol] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}