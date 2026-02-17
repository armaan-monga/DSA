class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        helper(root,ans);
        return ans.get(k-1);
    }
    public void helper(TreeNode root,ArrayList<Integer> ans){
        if(root==null)return;
        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
    }
}