public class CheckIfEveryRowAndColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[n];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = matrix[i][j] - 1;
                int b = matrix[j][i] - 1;
                if (a >= n || b >= n || row[a] == flag || col[b] == flag)
                    return false;
                row[a] = flag;
                col[b] = flag;
            }
            flag = !flag;
        }
        return true;
    }
}