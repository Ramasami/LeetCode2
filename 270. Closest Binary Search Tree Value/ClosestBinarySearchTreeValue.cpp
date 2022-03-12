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
    int closestValue(TreeNode *root, double target)
    {

        int closest = root->val;
        double closestDiff = INT_MAX;

        while (root != NULL)
        {
            double curr = abs(target - root->val);
            if (curr < closestDiff)
            {
                closest = root->val;
                closestDiff = curr;
            }
            if (closestDiff < 0.5)
                return closest;
            root = target < root->val ? root->left : root->right;
        }
        return closest;
    }
};