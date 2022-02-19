#include <bits/stdc++.h>
using namespace std;

class WordDistance
{

    unordered_map<string, vector<int>> map;

public:
    WordDistance(vector<string> &wordsDict)
    {
        int n = wordsDict.size();
        for (int i = 0; i < n; i++)
        {
            string s = wordsDict[i];
            if (map.find(s) == map.end())
                map[s] = vector<int>();
            map[s].push_back(i);
        }
    }

    int shortest(string word1, string word2)
    {
        vector<int> v1 = map[word1];
        vector<int> v2 = map[word2];
        vector<int>::iterator it1 = v1.begin();
        vector<int>::iterator it2 = v2.begin();
        int ans = INT_MAX;
        while (it1 != v1.end() && it2 != v2.end())
        {
            if (*it1 < *it2)
            {
                ans = min(ans, *it2 - *it1);
                it1++;
            }
            else
            {
                ans = min(ans, *it1 - *it2);
                it2++;
            }
        }

        return ans;
    }
};