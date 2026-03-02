class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Stack<Integer> st=new Stack<>();
        helper(root,st);
        TreeNode newnode=new TreeNode(st.pop());
        TreeNode n=newnode;
        while(!st.isEmpty()){
            newnode.right=new TreeNode(st.pop());
            newnode=newnode.right;
        }
        return n;
    }
    public void helper(TreeNode root,Stack<Integer> st){
        if(root==null)return;
        helper(root.right,st);
        st.push(root.val);
        helper(root.left,st);
    }
}