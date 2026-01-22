class Solution {
    public int height(TreeNode root){
        if(root==null || (root.left==null && root.right==null))return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        int lh=height(root.left);
        int rh=height(root.right);
        if(root.left!=null)lh++;
        if(root.right!=null)rh++;
        int difference=lh-rh;
        if(difference<0)difference = -difference;
        if(difference>1)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}