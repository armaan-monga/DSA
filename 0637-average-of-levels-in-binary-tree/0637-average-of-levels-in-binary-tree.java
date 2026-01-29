class Solution {
    public int height(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    public void preorder(TreeNode root,int n,long[] data){
        if(root==null)return ;
        if(n==1){
            data[0]+=root.val;
            data[1]+=1;
            return;
        }
        preorder(root.left,n-1,data);
        preorder(root.right,n-1,data);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null)return ans;
        int level=height(root);
        for(int i=1;i<=level;i++){
            long[] data=new long[2];
            preorder(root,i,data);
            double avg=(double) data[0]/data[1];
            ans.add(avg);
        }
        return ans;
    }
}