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
    vector<double> averageOfLevels(TreeNode *root)
    {
        if (root == NULL)
            return vector<double>(0);
        queue<TreeNode *> *q = new queue<TreeNode *>;
        q->push(root);

        TreeNode *t;
        vector<double> ans;
        while (!q->empty())
        {
            queue<TreeNode *> *tempQ = new queue<TreeNode *>;
            double sum = 0;
            int n = q->size();
            while (!q->empty())
            {
                t = q->front();
                q->pop();
                sum += t->val;
                if (t->left != NULL)
                    tempQ->push(t->left);
                if (t->right != NULL)
                    tempQ->push(t->right);
            }
            q = tempQ;
            ans.push_back(sum / n);
        }
        return ans;
    }
};