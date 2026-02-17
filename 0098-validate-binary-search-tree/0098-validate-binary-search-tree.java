class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        helper(root,arr);
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)<=arr.get(i-1))return false;
        }
        return true;
    }
    public void helper(TreeNode root,List<Integer> arr){
        if(root==null)return;
        helper(root.left,arr);
        arr.add(root.val);
        helper(root.right,arr);
    }
}