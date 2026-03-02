class Solution {
    TreeNode prev=null;
    TreeNode head=null;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head;
    }
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        if(prev==null){
            head=root;
        }
        else{
            prev.right=root;
        }
        root.left=null;
        prev=root;
        inorder(root.right);
    }
}