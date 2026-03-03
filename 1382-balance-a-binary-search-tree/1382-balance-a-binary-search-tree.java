class Solution {
    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null)return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        return solve(0,arr.size()-1,arr);
    }
    public TreeNode solve(int l,int r,List<Integer> arr){
        if(l>r)return null;
        int mid=l+(r-l)/2;
        TreeNode newnode=new TreeNode(arr.get(mid));
        newnode.left=solve(l,mid-1,arr);
        newnode.right=solve(mid+1,r,arr);
        return newnode;
    }
}