class Solution {
    public int sumNumbers(TreeNode root) {
      return dfs(root,0);  
    }
    public int dfs(TreeNode root,int currsum){
        if(root==null)return 0;
        currsum=currsum*10+root.val;
        if(root.left==null && root.right==null)return currsum;
        return dfs(root.left,currsum)+dfs(root.right,currsum);
    }
}