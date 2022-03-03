#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int numberOfArithmeticSlices(vector<int> &nums)
    {
        int diff = 0;
        int l = 0;
        int r = 0;
        int n = nums.size();
        int ans = 0;
        for (r = 0; r < n - 1; r++)
        {
            int currDiff = nums[r + 1] - nums[r];
            if (currDiff == diff)
            {
                continue;
            }
            else
            {
                if (r - l >= 2)
                {
                    int c = r - l;
                    ans += (c * (c - 1)) / 2;
                }
                l = r;
                diff = currDiff;
            }
        }
        if (r - l >= 2)
        {
            int c = r - l;
            ans += (c * (c - 1)) / 2;
        }
        return ans;
    }
};