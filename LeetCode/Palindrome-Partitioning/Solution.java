1class Solution {
2    public List<List<String>> partition(String s) {
3       List<List<String>> ans=new ArrayList<>();
4       List<String> temp=new ArrayList<>();
5       solve(0,s,temp,ans);
6       return ans; 
7    }
8    public void solve(int index,String s,List<String> temp,List<List<String>> ans){
9        if(index==s.length()){
10            ans.add(new ArrayList<>(temp));
11            return;
12        }
13        for(int i=index;i<s.length();i++){
14            if(isPalindrome(s,index,i)){
15                temp.add(s.substring(index,i+1));
16                solve(i+1,s,temp,ans);
17                temp.remove(temp.size()-1);
18            }
19        }
20        return;
21    }
22    public boolean isPalindrome(String s,int left,int right){
23        while(left<right){
24            if(s.charAt(left++)!=s.charAt(right--))return false;
25        }
26        return true;
27    }
28}