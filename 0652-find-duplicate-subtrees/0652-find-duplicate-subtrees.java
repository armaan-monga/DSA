class Solution {
    public String getSubtreeString(TreeNode root,Map<String,Integer> map,List<TreeNode> res){
        if(root==null)return "N";
        String s=String.valueOf(root.val)+","+getSubtreeString(root.left,map,res)+","+getSubtreeString(root.right,map,res);
        int count=map.getOrDefault(s, 0);
        if(count==1){
            res.add(root);
        }
        
        map.put(s,count+1);
        return s;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map=new HashMap<>();
        List<TreeNode> res=new ArrayList<>();
        getSubtreeString(root,map,res);
        return res;
    }
}