#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> findErrorNums(vector<int> &nums)
    {
        int x = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            x = x ^ (i + 1);
            x = x ^ (nums[i]);
        }
        int rm = x & (~x + 1);
        int a = 0, b = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if ((rm & (i + 1)) == 0)
            {
                a ^= (i + 1);
            }
            else
            {
                b ^= (i + 1);
            }

            if ((rm & nums[i]) == 0)
            {
                a ^= nums[i];
            }
            else
            {
                b ^= nums[i];
            }
        }
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] == a)
                return vector<int>{a, b};
            else if (nums[i] == b)
                return vector<int>{b, a};
        }
        return vector<int>{a, b};
        ;
    }
};