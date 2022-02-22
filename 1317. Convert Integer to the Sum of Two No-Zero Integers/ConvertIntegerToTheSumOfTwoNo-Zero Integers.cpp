#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> getNoZeroIntegers(int n)
    {
        vector<int> ans(2);
        for (int i = 1; i < n / 2 + 1; i++)
        {
            if (!contains0(i) && !contains0(n - i))
            {
                ans[0] = i;
                ans[1] = n - i;
                break;
            }
        }

        return ans;
    }

    bool contains0(int n)
    {
        while (n)
        {
            if (n % 10 == 0)
                return true;
            n /= 10;
        }
        return false;
    }
};