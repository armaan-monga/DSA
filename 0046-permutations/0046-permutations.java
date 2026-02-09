class Solution {
    public void permutation(List<List<Integer>> ans,List<Integer> perm,int[]arr,boolean[] used){
        if(perm.size()==arr.length){
            ans.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(used[i])continue;
            used[i]=true;
            perm.add(arr[i]);
            permutation(ans,perm,arr,used);
            perm.remove(perm.size()-1);
            used[i]=false;
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        if(nums.length==0)return ans;
        List<Integer> perm=new ArrayList<>();
        permutation(ans,perm,nums,new boolean[nums.length]);
        return ans;
    }
}