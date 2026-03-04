public class Codec {
    int i=0;    
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfsserialize(root,sb);
        return sb.toString();
    }

    public void dfsserialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        dfsserialize(root.left,sb);
        dfsserialize(root.right,sb);

    }

    public TreeNode deserialize(String data) {
        String[] vals=data.split(",");
        return dfs(vals);
    }
    public TreeNode dfs(String[] vals){
        if(vals[i].equals("null")){
            i++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(vals[i]));
        i++;
        node.left=dfs(vals);
        node.right=dfs(vals);
        return node;
    }
}
