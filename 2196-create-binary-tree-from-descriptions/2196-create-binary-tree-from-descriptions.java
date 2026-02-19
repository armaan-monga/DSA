class Solution {
    public TreeNode createBinaryTree(int[][] array) {
        HashMap<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int[] arr:array){
            int parent=arr[0];
            int child=arr[1];
            int isleft=arr[2];
            if(!map.containsKey(parent)){
                map.put(parent,new TreeNode(parent));
            }
            if(!map.containsKey(child)){
                map.put(child,new TreeNode(child));
            }
            if(isleft==1){
                map.get(parent).left=map.get(child);
            }
            if(isleft==0){
                map.get(parent).right=map.get(child);
            }
            set.add(child);
        }
        
        for(int key:map.keySet()){
            if(!set.contains(key))return map.get(key);
        }
        return null;
    }
}