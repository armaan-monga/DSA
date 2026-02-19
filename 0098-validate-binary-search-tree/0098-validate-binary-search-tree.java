class Solution {
    long prev=Long.MIN_VALUE;
    public boolean helper(TreeNode root){
        if(root==null)return true;
        if(!helper(root.left))return false;
        if(root.val<=prev)return false;
        prev=root.val;
        return helper(root.right);
    }
    public boolean isValidBST(TreeNode root) {
       return helper(root); 
    }
}