#include <bits/stdc++.h>
using namespace std;

class Solution
{

public:
    int maximumProduct(vector<int> &nums)
    {

        int max1 = INT_MIN, max2 = INT_MIN, max3 = INT_MIN;
        int min1 = INT_MAX, min2 = INT_MAX;
        for (vector<int>::iterator it = nums.begin(); it != nums.end(); it++)
        {
            int n = *it;
            if (n <= min1)
            {
                min2 = min1;
                min1 = n;
            }
            else if (n <= min2)
            {
                min2 = n;
            }

            if (n >= max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = n;
            }
            else if (n >= max2)
            {
                max3 = max2;
                max2 = n;
            }
            else if (n >= max3)
            {
                max3 = n;
            }
        }

        return max(max1 * max2 * max3, min1 * min2 * max1);
    }
};