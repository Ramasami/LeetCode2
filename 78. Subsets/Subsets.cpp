#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<vector<int>> subsets(vector<int> &nums)
    {
        vector<vector<int>> ans;
        find(ans, nums, 0, nums.size(), vector<int>());
        return ans;
    }

    void find(vector<vector<int>> &ans, vector<int> &nums, int i, int n, vector<int> current)
    {
        if (i == n)
        {
            ans.push_back(current);
            return;
        }
        find(ans, nums, i + 1, n, current);
        current.push_back(nums[i]);
        find(ans, nums, i + 1, n, current);
    }
};