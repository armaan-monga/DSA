class Solution {
    public void combination(List<List<Integer>> ans,List<Integer> comb,int target,int idx,int[] arr){
        if(idx==arr.length || target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        comb.add(arr[idx]);
        // combination(ans,comb,target-arr[idx],idx+1,arr);
        combination(ans,comb,target-arr[idx],idx,arr);

        comb.remove(comb.size()-1);
        
        combination(ans,comb,target,idx+1,arr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        combination(ans,comb,target,0,candidates);
        return ans;
    }
}