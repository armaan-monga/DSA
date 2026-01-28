class Solution {
    public void odd(TreeNode left,TreeNode right,int level){
        if(left==null || right==null)return ;
        if(level%2==1){
            int temp=left.val;
            left.val=right.val;
            right.val=temp;
        }
        odd(left.left,right.right,level+1);
        odd(left.right,right.left,level+1);
        return;
    }
    public TreeNode reverseOddLevels(TreeNode root) {
    if(root==null)return root;
    odd(root.left,root.right,1);
    return root;       
    }
}