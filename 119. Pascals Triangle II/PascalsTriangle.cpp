#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    vector<int> getRow(int rowIndex)
    {
        rowIndex++;
        if (rowIndex == 1)
            return vector<int>{1};
        vector<int> current = vector<int>(rowIndex, 1);
        for (int i = 3; i <= rowIndex; i++)
        {
            int next = current[0];
            for (int k = 1; k < i - 1; k++)
            {
                int sum = next + current[k];
                next = current[k];
                current[k] = sum;
            }
        }
        return current;
    }
};