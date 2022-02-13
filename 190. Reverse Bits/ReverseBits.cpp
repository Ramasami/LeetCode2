#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    uint32_t reverseBits(uint32_t n)
    {
        uint32_t ans = 0;
        uint32_t x = 1;
        uint32_t y = 1 << 31;
        for (int i = 0; i < 32; i++)
        {
            if ((n & x) != 0)
                ans = ans | y;
            x = x << 1;
            y = y >> 1;
        }
        return ans;
    }
};