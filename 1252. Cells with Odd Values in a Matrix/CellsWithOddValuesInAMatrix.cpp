#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int oddCells(int m, int n, vector<vector<int>> &indices)
    {
        vector<int> row(m);
        vector<int> col(n);
        for (vector<vector<int>>::iterator it = indices.begin(); it != indices.end(); it++)
        {
            row[(*it)[0]]++;
            col[(*it)[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if ((row[i] + col[j]) % 2 == 1)
                    ans++;
        return ans;
    }
};