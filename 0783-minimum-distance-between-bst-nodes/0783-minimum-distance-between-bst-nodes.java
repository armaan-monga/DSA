class Solution {
    Integer prev=null;
    int min=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return min;
    }
    public void helper(TreeNode root){
        if(root==null)return;
        helper(root.left);
        if(prev!=null){
            min=Math.min(min,root.val-prev);
        }
        prev=root.val;
        helper(root.right);
    }
}