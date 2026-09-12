1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public TreeNode sufficientSubset(TreeNode root, int limit) {
18        if (root == null) return null;
19        limit -= root.val;
20        if (root.left == null && root.right == null) {
21            return limit > 0 ? null : root;
22        }
23        root.left = sufficientSubset(root.left, limit);
24        root.right = sufficientSubset(root.right, limit);
25        if (root.left == null && root.right == null) {
26            return null;
27        }
28        return root;
29    }
30}