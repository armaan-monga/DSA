class Solution {
    public void combination(List<List<Integer>> ans, List<Integer> comb,int target, int idx,int[] arr){
        if(target==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(target<0 || idx==arr.length)return;
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])continue;
            if(arr[i]>target)break;
        
        comb.add(arr[i]);
        combination(ans,comb,target-arr[i],i+1,arr);
        comb.remove(comb.size()-1);
        // combination(ans,comb,target,idx+1,arr);

        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        combination(ans,comb,target,0,candidates);
        return ans;
    }
}