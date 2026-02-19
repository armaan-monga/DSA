class Solution {
    public TreeNode bst(int[] nums,int low,int high){
        if(low>high)return null;
        int mid=low+(high-low)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=bst(nums,low,mid-1);
        root.right=bst(nums,mid+1,high);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums,0,nums.length-1);
    }
}