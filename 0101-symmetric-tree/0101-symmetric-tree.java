class Solution {
    public boolean isSame(TreeNode p,TreeNode q){
        if(p==null && q==null)return true;
        if(q==null || p==null)return false;
        if(p.val!=q.val)return false;
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
    public TreeNode reverse(TreeNode root){
        if(root==null)return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        root.left=reverse(root.left);
        root.right=reverse(root.right);
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        root.left=reverse(root.left);
       return isSame(root.left,root.right);
    }
}