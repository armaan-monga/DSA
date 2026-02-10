class Solution {
    public void helper(List<List<Integer>> ans,int n,int k,List<Integer> comb,int idx){
        if(comb.size()==k){
            ans.add(new ArrayList<>(comb));
            return;
        }
        for(int i=idx;i<=n;i++){
            comb.add(i);
            helper(ans,n,k,comb,i+1);
            comb.remove(comb.size()-1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
     List<List<Integer>> ans=new ArrayList<>();
     List<Integer> comb=new ArrayList<>();
     helper(ans,n,k,comb,1);
     return ans;   
    }
}