class pair {
    TreeNode node;
    int level;

    pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
       Queue<pair> q=new LinkedList<>();
       q.offer(new pair(root,0));
       int maxwidth=0;
        while(!q.isEmpty()){
            int minidx=q.peek().level;
            int size=q.size();
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                pair curr=q.poll();
                int curridx=curr.level-minidx;
                if(i==0)first=curridx;
                if(i==size-1)last=curridx;
                if(curr.node.left!=null)q.offer(new pair(curr.node.left,2*curridx+1));
                if(curr.node.right!=null)q.offer(new pair(curr.node.right,2*curridx+2));
            }
            maxwidth = Math.max(maxwidth, last - first + 1);
        }
        return maxwidth;
    }
}