class Solution {
    long min=Long.MAX_VALUE;
    long smin=Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)return -1;
        helper(root);
        if(smin==Long.MAX_VALUE)return -1;
        return (int)smin;
    }
    public void helper(TreeNode root){
        if(root==null)return;
        if(root.val<min){
            smin=min;
            min=root.val;
        }
        if(root.val<smin && root.val>min)smin=root.val;
        helper(root.left);
        helper(root.right);
    }
}