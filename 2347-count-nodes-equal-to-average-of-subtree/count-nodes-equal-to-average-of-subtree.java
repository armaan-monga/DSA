class Solution {
    int ans = 0;

    class Pair {
        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        int sum = root.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;

        if (root.val == sum / count) {
            ans++;
        }

        return new Pair(sum, count);
    }

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return ans;
    }
}