class Solution {
    public int[] solve(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        int notTake = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int take = root.val
                 + left[0]
                 + right[0];

        return new int[]{notTake, take};
    }
    public int rob(TreeNode root) {
        int[] ans = solve(root);
        return Math.max(ans[0], ans[1]);
    }
}