1class Solution {
2    public List<TreeNode> generateTrees(int n) {
3        return solve(1, n);
4    }
5    public List<TreeNode> solve(int start, int end) {
6        List<TreeNode> ans = new ArrayList<>();
7        if (start > end) {
8            ans.add(null);
9            return ans;
10        }
11        for (int root = start; root <= end; root++) {
12            List<TreeNode> leftTrees = solve(start, root - 1);
13            List<TreeNode> rightTrees = solve(root + 1, end);
14            for (TreeNode left : leftTrees) {
15                for (TreeNode right : rightTrees) {
16                    TreeNode node = new TreeNode(root);
17                    node.left = left;
18                    node.right = right;
19                    ans.add(node);
20                }
21            }
22        }
23        return ans;
24    }
25}