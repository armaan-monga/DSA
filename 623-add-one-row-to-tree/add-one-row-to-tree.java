class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currDepth = 1;
        while (currDepth < depth - 1) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            currDepth++;
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            node.left.left = left;
            node.right.right = right;
        }
        return root;
    }
}