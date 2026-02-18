class Solution {
    public TreeNode bstFromPreorder(int[] arr) {
        if(arr.length==0)return null;
        TreeNode root=new TreeNode(arr[0]);
        for(int i=1;i<arr.length;i++){
            helper(root,arr[i]);
        }
        return root;
    }
    public TreeNode helper(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left=helper(root.left,val);
        }
        else{
            root.right=helper(root.right,val);
        }
        return root;
    }
}