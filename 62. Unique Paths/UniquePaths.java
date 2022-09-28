public class UniquePaths {

    public int uniquePaths(int m, int n) {
        m--;
        n--;
        int r = Math.min(m, n);
        int dp[][] = new int[m + n + 1][r + 1];
        return nCr(m + n, r, dp);
    }

    private int nCr(int n, int r, int dp[][]) {
        r = Math.min(r, n - r);
        if (r == 1)
            return n;
        if (r == 0)
            return 1;
        if (dp[n][r] != 0) {
            return dp[n][r];
        }
        dp[n][r] = nCr(n - 1, r, dp) + nCr(n - 1, r - 1, dp);
        return dp[n][r];
    }
}