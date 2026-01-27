class Solution {
    public static boolean contains(TreeNode root,TreeNode x){
        if(root==null)return false;
        if(root==x)return true;
        return contains(root.left,x) || contains(root.right,x);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root)return root;
        boolean  leftp=contains(root.left,p);
        boolean rightq=contains(root.right,q);
        if(leftp && rightq)return root;
        if(!leftp && !rightq)return root;
        if(!leftp && rightq)return lowestCommonAncestor(root.right,p,q);
        if(leftp && !rightq)return lowestCommonAncestor(root.left,p,q);
        return root;
    }
}