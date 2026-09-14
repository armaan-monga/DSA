class Solution {
    public TreeNode dfs(TreeNode root,int val,int depth,int curr){
        if(root==null)return null;
        if(curr==depth-1){
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=left;
            root.right.right=right;
            return root;
        }
        root.left=dfs(root.left,val,depth,curr+1);
        root.right=dfs(root.right,val,depth,curr+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newNode = new TreeNode(val);
            newNode.left=root;
            return newNode;
        }
        return dfs(root,val,depth,1);
    }
}