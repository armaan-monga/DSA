class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        helper(root,map);
        int maxfreq=0;
        for(int freq:map.values()){
            maxfreq=Math.max(freq,maxfreq);
        }
        List<Integer> result=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==maxfreq){
                result.add(key);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
       return arr; 
    }
    public void helper(TreeNode root,Map<Integer,Integer> map){
        if(root==null)return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        helper(root.left,map);
        helper(root.right,map);
    }
}