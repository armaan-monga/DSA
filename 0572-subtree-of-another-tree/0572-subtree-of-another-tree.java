class Solution {
    public boolean issame(TreeNode p,TreeNode q){
        if(p==null && q==null)return true;
        if(p==null || q==null)return false;
        if(p.val!=q.val)return false;
        return issame(p.left,q.left) && issame(p.right,q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if(root==null)return false;
        if(issame(root,subroot))return true;
        return isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
    }
}