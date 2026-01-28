class Solution {
    public int height(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void nthlevel(TreeNode root,int n,List<Integer> arr){
        if(root==null)return;
        if(n==1){
            arr.add(root.val);
        }
        nthlevel(root.left,n-1,arr);
        nthlevel(root.right,n-1,arr);
    }
    public void nthlevel2(TreeNode root,int n,List<Integer> arr){
        if(root==null)return;
        if(n==1){
            arr.add(root.val);
        }
        nthlevel2(root.right,n-1,arr);
        nthlevel2(root.left,n-1,arr);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        int level=height(root);
        for(int i=1;i<=level;i++){
            List<Integer> arr=new ArrayList<>();
            if(i%2!=0){
                nthlevel(root,i,arr);
            }
            else nthlevel2(root,i,arr);
            ans.add(arr);
        }
        return ans;
    }
}