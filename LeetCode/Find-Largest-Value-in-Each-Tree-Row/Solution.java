1class Solution {
2    public List<Integer> largestValues(TreeNode root) {
3        List<Integer> ans = new ArrayList<>();
4        if(root==null)return ans;
5        Queue<TreeNode> q = new LinkedList<>();
6        q.add(root);
7        while(!q.isEmpty()){
8            int size = q.size();
9            int max=Integer.MIN_VALUE;
10            for(int i=0;i<size;i++){
11                TreeNode curr = q.remove();
12                if(curr.val > max) max=curr.val;
13                if(curr.left!=null) q.add(curr.left);
14                if(curr.right!=null) q.add(curr.right);
15            }
16            ans.add(max);
17        }
18        return ans;
19    }
20}