import java.util.*;

public class BinaryTreePostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return travel(root, ans);
    }

    private List<Integer> travel(TreeNode root, List<Integer> ans) {
        if (root == null)
            return ans;
        travel(root.left, ans);
        travel(root.right, ans);
        ans.add(root.val);
        return ans;
    }
}