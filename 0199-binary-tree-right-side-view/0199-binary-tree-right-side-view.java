class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        rightview(root,0,ans);
        return ans;
    }
    public void rightview(TreeNode root,int level,List<Integer> ans){
        if(root==null)return;
        if(level==ans.size()){
            ans.add(root.val);
        }
        rightview(root.right,level+1,ans);
        rightview(root.left,level+1,ans);
    }
}