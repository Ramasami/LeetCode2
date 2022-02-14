#include <bits/stdc++.h>
using namespace std;

class MyQueue
{

    stack<int> s1;
    stack<int> s2;
    int peekValue;
    int size = 0;

public:
    MyQueue()
    {
        s1 = stack<int>();
        s2 = stack<int>();
    }

    void push(int x)
    {
        s1.push(x);
        if (size == 0)
            peekValue = x;
        size++;
    }

    int pop()
    {
        for (int i = 0; i < size - 1; i++)
        {
            s2.push(s1.top());
            s1.pop();
        }
        if (size > 1)
            peekValue = s2.top();
        int result = s1.top();
        s1.pop();
        while (!s2.empty())
        {
            s1.push(s2.top());
            s2.pop();
        }
        size--;
        return result;
    }

    int peek()
    {
        return peekValue;
    }

    bool empty()
    {
        return size == 0;
    }
};