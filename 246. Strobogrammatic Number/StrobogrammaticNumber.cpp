#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool isStrobogrammatic(string num)
    {
        int n = num.length();
        for (int i = 0; i <= n / 2; i++)
        {
            char a = num[i];
            char b = num[n - i - 1];
            char x = a;
            switch (a)
            {
            case '2':
            case '3':
            case '4':
            case '5':
            case '7':
                return false;
            case '6':
                x = '9';
                break;
            case '9':
                x = '6';
                break;
            }
            switch (b)
            {
            case '2':
            case '3':
            case '4':
            case '5':
            case '7':
                return false;
            }
            if (x != b)
                return false;
        }
        return true;
    }
};