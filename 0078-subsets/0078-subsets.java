class Solution {
    public void helper(List<List<Integer>> ans,List<Integer> sub,int[] nums,int idx){
        ans.add(new ArrayList<>(sub));
        for(int i=idx;i<nums.length;i++){
            sub.add(nums[i]);
            helper(ans,sub,nums,i+1);
            sub.remove(sub.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> sub=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,sub,nums,0);
        return ans;
    }
}