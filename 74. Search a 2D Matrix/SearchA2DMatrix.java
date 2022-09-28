public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    private boolean binarySearch(int[][] matrix, int target, int l, int r) {
        if (l > r)
            return false;
        int m = l + (r - l) / 2;
        int M = getValue(matrix, m);
        if (target == M)
            return true;
        else if (target > M)
            return binarySearch(matrix, target, m + 1, r);
        else
            return binarySearch(matrix, target, l, m - 1);
    }

    private int getValue(int[][] matrix, int index) {
        int row = index / matrix[0].length;
        int col = index % matrix[0].length;
        return matrix[row][col];
    }
}