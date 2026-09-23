1class Solution {
2    public List<List<Integer>> findSubsequences(int[] nums) {
3        List<Integer> temp=new ArrayList<>();
4        List<List<Integer>> ans=new ArrayList<>();
5        solve(0,nums,temp,ans,Integer.MIN_VALUE);
6        return ans;
7    }
8    public void solve(int index,int[] nums,List<Integer> temp,List<List<Integer>> ans,int prev){
9        if(index>nums.length){
10            return;
11        }
12        if(temp.size()>=2){
13            ans.add(new ArrayList<>(temp));
14        }
15        HashSet<Integer> set = new HashSet<>();
16        for(int i=index;i<nums.length;i++){
17            if(nums[i]<prev)continue;
18            if(set.contains(nums[i]))continue;
19            set.add(nums[i]);
20            temp.add(nums[i]);
21            solve(i+1,nums,temp,ans,nums[i]);
22            temp.remove(temp.size()-1);
23        }
24        return;
25    }
26}