#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int deleteAndEarn(vector<int> &nums)
    {
        map<int, int> count;
        for (int i = 0; i < nums.size(); i++)
            count[nums[i]] += nums[i];
        int n = count.size();
        map<int, int>::iterator left = count.begin(), right = count.begin();
        right++;
        int oneBack = left->second, twoBack = 0;
        for (; right != count.end(); left++, right++)
        {
            int curr = right->second;
            if (right->first > left->first + 1)
                curr += max(oneBack, twoBack);
            else
                curr += twoBack;
            twoBack = max(twoBack, oneBack);
            oneBack = curr;
        }
        return max(twoBack, oneBack);
    }
};