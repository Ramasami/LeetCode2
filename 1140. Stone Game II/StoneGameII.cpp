#include <bits/stdc++.h>
using namespace std;

class Solution
{

public:
    int stoneGameII(vector<int> &piles)
    {
        int n = piles.size();
        vector<vector<int>> dp(204, vector<int>(204, -1));
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += piles[i];
        int ans = find(0, 1, dp, piles, n);
        return (ans + sum) / 2;
    }

    int find(int i, int M, vector<vector<int>> &dp, vector<int> &piles, int &n)
    {
        if (i >= n)
            return 0;

        if (dp[i][M] != -1)
            return dp[i][M];

        int best = INT_MIN;
        int score = 0;
        for (int j = 0; j < 2 * M; j++)
        {
            if (i + j < n)
                score += piles[i + j];
            best = max(best, score - find(i + j + 1, max(j + 1, M), dp, piles, n));
        }
        dp[i][M] = best;
        return best;
    }
};