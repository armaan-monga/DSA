/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public void preorder(TreeNode root,StringBuilder sb){
        if(root==null)return;
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())return null;
        String[] arr=data.split(",");
        int[] index=new int[1];
        return build(arr,index,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public TreeNode build(String[] arr,int[] index,long min,long max){
        if(index[0]>=arr.length)return null;
        int val=Integer.parseInt(arr[index[0]]);
        if(val<min || val>max)return null;
        index[0]++;
        TreeNode root=new TreeNode(val);
        root.left=build(arr,index,min,val);
        root.right=build(arr,index,val,max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;