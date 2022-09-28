#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class Solution
{
public:
    bool findTarget(TreeNode *root, int k)
    {
        unordered_set<int> *set = new unordered_set<int>();
        return find(set, root, k);
    }

    bool find(unordered_set<int> *set, TreeNode *root, int k)
    {
        if (root == NULL)
            return false;
        int val = root->val;
        if (set->find(k - val) != set->end())
            return true;
        set->insert(val);
        return find(set, root->left, k) || find(set, root->right, k);
    }
};