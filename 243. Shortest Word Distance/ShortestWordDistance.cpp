#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int shortestDistance(vector<string> &wordsDict, string word1, string word2)
    {
        int i1 = -1;
        int i2 = -1;
        int ans = INT_MAX;
        int n = wordsDict.size();
        for (int i = 0; i < n; i++)
        {
            if (wordsDict[i] == word1)
                i1 = i;
            else if (wordsDict[i] == word2)
                i2 = i;
            if (i1 != -1 && i2 != -1)
                ans = min(ans, abs(i2 - i1));
        }
        return ans;
    }
};