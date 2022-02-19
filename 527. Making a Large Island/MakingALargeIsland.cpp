#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int largestIsland(vector<vector<int>> &grid)
    {
        int island_number = 2;
        int n = grid.size();
        int island_size[500 * 250 + 2] = {0};
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    dfs(grid, island_size, island_number, i, j, n);
                }
            }
        }
        if (island_number <= 3)
        {
            if (island_number == 2)
                return 1;
            else
                return min(island_size[2] + 1, n * n);
        }
        int max_ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 0)
                {
                    unordered_set<int> s;
                    if (i > 0 && grid[i - 1][j] != 0)
                    {
                        s.insert(grid[i - 1][j]);
                    }
                    if (i < n - 1 && grid[i + 1][j] != 0)
                    {
                        s.insert(grid[i + 1][j]);
                    }
                    if (j > 0 && grid[i][j - 1] != 0)
                    {
                        s.insert(grid[i][j - 1]);
                    }
                    if (j < n - 1 && grid[i][j + 1] != 0)
                    {
                        s.insert(grid[i][j + 1]);
                    }
                    if (s.size() == 0)
                        continue;
                    int ans = 1;
                    for (unordered_set<int>::iterator it = s.begin(); it != s.end(); it++)
                        ans += island_size[*it];
                    max_ans = max(max_ans, ans);
                }
            }
        }
        return max_ans;
    }

    void dfs(vector<vector<int>> &grid, int *island_size, int &island_number, int i, int j, int n)
    {
        queue<pair<int, int>> q;
        q.push({i, j});
        while (!q.empty())
        {
            pair<int, int> c = q.front();
            q.pop();
            int x = c.first;
            int y = c.second;
            grid[x][y] = island_number;
            if (x > 0 && grid[x - 1][y] == 1)
            {
                q.push({x - 1, y});
                grid[x - 1][y] = -1;
            }
            if (x < n - 1 && grid[x + 1][y] == 1)
            {
                q.push({x + 1, y});
                grid[x + 1][y] = -1;
            }
            if (y > 0 && grid[x][y - 1] == 1)
            {
                q.push({x, y - 1});
                grid[x][y - 1] = -1;
            }
            if (y < n - 1 && grid[x][y + 1] == 1)
            {
                q.push({x, y + 1});
                grid[x][y + 1] = -1;
            }
            island_size[island_number]++;
        }
        island_number++;
    }
};