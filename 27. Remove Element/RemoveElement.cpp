#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int removeElement(vector<int> &nums, int val)
    {
        int l = 0;
        int r = nums.size() - 1;
        for (int i = 0; i <= r; i++)
        {
            if (nums[i] == val)
            {
                while (nums[r] == val && r > i)
                {
                    r--;
                }
                if (r == i)
                    return l;
                nums[l++] = nums[r--];
            }
            else
            {
                nums[l++] = nums[i];
            }
        }
        return l;
    }
};