class Solution {
    int index=0;
    public TreeNode bstFromPreorder(int[] arr) {
        return build(arr,Integer.MAX_VALUE);
    }
    public TreeNode build(int[] arr,int bound){
        if(index==arr.length || arr[index]>bound){
            return null;
        }
        TreeNode root=new TreeNode(arr[index++]);
        root.left=build(arr,root.val);
        root.right=build(arr,bound);
        return root;
    }
}