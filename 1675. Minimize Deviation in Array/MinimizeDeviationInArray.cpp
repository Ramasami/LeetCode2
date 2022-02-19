#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int minimumDeviation(vector<int> &nums)
    {
        for (int i = 0; i < nums.size(); i++)
            if (nums[i] % 2 == 1)
                nums[i] *= 2;
        priority_queue<int> maxHeap;
        int m = INT_MAX;
        for (int i = 0; i < nums.size(); i++)
        {
            maxHeap.push(nums[i]);
            m = min(nums[i], m);
        }
        int ans = INT_MAX;
        while (true)
        {
            int M = maxHeap.top();
            maxHeap.pop();
            while (maxHeap.size() > 1 && maxHeap.top() == M)
                maxHeap.pop();
            ans = min(ans, M - m);
            if (M % 2 == 0)
            {
                if (M / 2 < m)
                    m = M / 2;
                else
                    ans = min(ans, M - m);
                M /= 2;
                maxHeap.push(M);
            }
            else
            {
                break;
            }
        }
        return ans;
    }
};