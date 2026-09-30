1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int n = seq.length();
4        int[] arr = new int[n];
5        int depth = 0;
6        for(int i=0;i<n;i++){
7            char ch = seq.charAt(i);
8            if(ch=='('){
9                depth++;
10                if(depth%2==0){
11                    arr[i] = 0;
12                }
13                else arr[i] = 1;
14            }
15            else{
16                if(depth%2==0){
17                    arr[i] = 0;
18                }
19                else arr[i] = 1;
20                depth--;
21            }
22        }
23        return arr;
24    }
25}