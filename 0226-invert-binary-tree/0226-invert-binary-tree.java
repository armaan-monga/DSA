class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        temp=invertTree(root.left);
        temp=invertTree(root.right);
        return root;
    }
}