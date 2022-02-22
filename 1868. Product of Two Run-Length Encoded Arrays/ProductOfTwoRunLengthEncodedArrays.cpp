#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<vector<int>> findRLEArray(vector<vector<int>> &encoded1, vector<vector<int>> &encoded2)
    {
        vector<vector<int>> ans;
        int i1 = 0, i2 = 0;
        int c1 = 0, c2 = 0;
        int j = 0;
        int n = 0;
        while (true)
        {
            if (i1 + encoded1[c1][1] < i2 + encoded2[c2][1])
            {
                i1 += encoded1[c1][1];
                add(ans, encoded1[c1][0] * encoded2[c2][0], i1 - j, n);
                j = i1;
                c1++;
            }
            else if (i1 + encoded1[c1][1] > i2 + encoded2[c2][1])
            {
                i2 += encoded2[c2][1];
                add(ans, encoded1[c1][0] * encoded2[c2][0], i2 - j, n);
                j = i2;
                c2++;
            }
            else
            {
                i1 += encoded1[c1][1];
                i2 += encoded2[c2][1];
                add(ans, encoded1[c1][0] * encoded2[c2][0], i1 - j, n);
                c1++;
                c2++;
                j = i1;
            }
            if (c1 == encoded1.size() && c2 == encoded2.size())
                break;
        }
        return ans;
    }

    void add(vector<vector<int>> &ans, int a, int b, int &n)
    {
        if (n > 0 && ans[n - 1][0] == a)
            ans[n - 1][1] += b;
        else
        {
            ans.push_back(vector<int>{a, b});
            n++;
        }
    }
};