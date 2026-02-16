class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            if(root.left!=null){
               insertIntoBST(root.left,val); 
            }
            else{
                TreeNode newnode=new TreeNode(val);
                root.left=newnode;
                return root;
            }
        }
        if(root.val<val){
            if(root.right!=null){
               insertIntoBST(root.right,val); 
            }
            else{
                TreeNode newnode=new TreeNode(val);
                root.right=newnode;
                return root;
            }
        }
        return root;
    }
}