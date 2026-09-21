class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
    public List<TreeNode> solve(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int root = start; root <= end; root++) {
            List<TreeNode> leftTrees = solve(start, root - 1);
            List<TreeNode> rightTrees = solve(root + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}