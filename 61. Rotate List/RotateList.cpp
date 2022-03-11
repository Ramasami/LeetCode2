#include<bits/stdc++.h>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution
{
public:
    ListNode *rotateRight(ListNode *head, int k)
    {
        int n = 0;
        ListNode *top = new ListNode(0, head);
        ListNode *t = head;
        while (t != NULL)
        {
            n++;
            t = t->next;
        }
        if (n == 0)
            return head;
        k = k % n;
        k = n - k - 2;
        t = head;
        while (k >= 0)
        {
            k--;
            t = t->next;
        }
        top->next = t->next;
        t->next = NULL;
        t = top;
        while (t->next != NULL)
        {
            t = t->next;
        }
        t->next = head;
        return top->next;
    }
};