class Solution {
    int val=0;
    public void helper(TreeNode root){
        if(root==null)return;
        helper(root.right);
        root.val+=val;
        val=root.val;
        helper(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
         helper(root);
         return root;
    }
}