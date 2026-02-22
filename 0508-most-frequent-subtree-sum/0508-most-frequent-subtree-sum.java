class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    int maxfreq=0;
    public int solve(TreeNode root){
        if(root==null)return 0;
            int leftsum=solve(root.left);
            int rightsum=solve(root.right);
            int sum=root.val+leftsum+rightsum;
            map.put(sum,map.getOrDefault(sum,0)+1);
            maxfreq=Math.max(maxfreq,map.get(sum));
            return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        solve(root);    
        List<Integer> list=new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxfreq) {
                list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}