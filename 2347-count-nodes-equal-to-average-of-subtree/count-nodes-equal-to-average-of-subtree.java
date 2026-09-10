class Solution {
    int ans = 0;

    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + sum(root.left) + sum(root.right);
    }

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int s = sum(root);
        int c = count(root);

        if (root.val == s / c) {
            ans++;
        }

        averageOfSubtree(root.left);
        averageOfSubtree(root.right);

        return ans;
    }
}