#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool hasAlternatingBits(int a)
    {
        long n = a;
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }
};