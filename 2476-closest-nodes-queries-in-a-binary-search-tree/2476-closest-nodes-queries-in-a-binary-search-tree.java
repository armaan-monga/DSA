class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
         List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {
            int idx = Collections.binarySearch(arr, q);

            int small = -1, large = -1;

            if (idx >= 0) {
                small = arr.get(idx);
                large = arr.get(idx);
            } else {
                idx = -idx - 1;  

                if (idx < arr.size()) {
                    large = arr.get(idx);
                }

                if (idx - 1 >= 0) {
                    small = arr.get(idx - 1);
                }
            }

            ans.add(Arrays.asList(small, large));
        }

        return ans;
    }

    public void inorder(TreeNode root,List<Integer> arr){
        if(root==null)return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}