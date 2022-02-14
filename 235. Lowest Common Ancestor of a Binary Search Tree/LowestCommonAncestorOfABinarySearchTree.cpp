#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution
{
public:
    TreeNode *answer = NULL;
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        find(root, p, q);
        return answer;
    }

    bool find(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (root == NULL)
            return false;

        bool left = find(root->left, p, q);
        bool right = find(root->right, p, q);
        bool curr = root == p || root == q;
        if ((left && right) || (left && curr) || (right && curr))
            answer = root;
        return left || right || curr;
    }
};