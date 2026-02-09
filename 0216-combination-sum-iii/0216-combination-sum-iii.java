class Solution {
    public void combination(List<List<Integer>> ans,List<Integer> comb,int k,int target,int start){
        if(target==0 && k==0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(target<0 || k==0)return;
        for(int i=start;i<=9;i++){
            if(i>target)break;
            comb.add(i);
            combination(ans,comb,k-1,target-i,i+1);
            comb.remove(comb.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> comb=new ArrayList<>();
        combination(ans,comb,k,n,1);
        return ans;
    }
}