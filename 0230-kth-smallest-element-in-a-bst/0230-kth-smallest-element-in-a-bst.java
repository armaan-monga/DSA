class Solution {
    int count=0;
    int result=-1;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return result;
    }
    public void helper(TreeNode root,int k){
        if(root==null || count>=k)return;
        helper(root.left,k);
        count++;
        if(count==k){
            result=root.val;
            return;
        }
        helper(root.right,k);
    }
}