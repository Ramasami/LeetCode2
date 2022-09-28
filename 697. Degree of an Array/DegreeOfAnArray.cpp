#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int findShortestSubArray(vector<int> &nums)
    {
        unordered_map<int, int> left, right, count;
        int n, c;
        int i = 0;
        for (vector<int>::iterator it = nums.begin(); it != nums.end(); it++)
        {
            n = *it;
            if (left.find(n) == left.end())
                left[n] = i;
            right[n] = i;
            count[n]++;
            i++;
        }
        int maxCount = 0;
        int maxRange = 0;
        for (unordered_map<int, int>::iterator it = count.begin(); it != count.end(); it++)
        {
            n = it->first;
            c = it->second;
            if (c > maxCount)
            {
                maxCount = c;
                maxRange = right[n] - left[n];
            }
            else if (c == maxCount)
            {
                maxRange = min(maxRange, right[n] - left[n]);
            }
        }
        return maxRange + 1;
    }
};