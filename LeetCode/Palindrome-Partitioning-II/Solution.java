1class Solution {
2    int ans=Integer.MAX_VALUE;
3    int[] dp;
4    public int minCut(String s) {
5        dp=new int[s.length()];
6        Arrays.fill(dp,-1);
7        return solve(0,s)-1;
8    }
9    public boolean isPalindrome(String s,int left,int right){
10        while(left<right){
11            if(s.charAt(left++)!=s.charAt(right--))return false;
12        }
13        return true;
14    }
15    public int solve(int index,String s){
16        if(index==s.length()){
17            return 0;
18        }
19        if(dp[index]!=-1){
20            return dp[index];
21        }
22        int min=Integer.MAX_VALUE;
23        for(int i=index;i<s.length();i++){
24            if(isPalindrome(s,index,i)){
25                int partition=1+solve(i+1,s);
26                min=Math.min(min,partition);
27            }
28        }
29        return dp[index]=min;
30    }
31}