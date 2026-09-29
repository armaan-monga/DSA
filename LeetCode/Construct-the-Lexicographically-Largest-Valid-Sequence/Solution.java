1class Solution {
2    public int[] constructDistancedSequence(int n) {
3        int[] arr = new int[2*n - 1];
4        Arrays.fill(arr,-1);
5        boolean[] used = new boolean[n+1];
6        boolean ans = solve(0,n,arr,used);
7        return arr;
8    }
9
10    public boolean solve(int i,int n,int[] arr,boolean[] used){
11        if(i>=arr.length)return true;
12        if(arr[i]!=-1){
13            return solve(i+1,n,arr,used);
14        }
15        for(int num=n;num>=1;num--){
16            if(used[num]){
17                continue;
18            }
19            used[num]=true;
20            arr[i]=num;
21            if(num==1){
22                if(solve(i+1,n,arr,used))return true;
23            }
24            else{
25                int j = arr[i]+i;
26                if(j<arr.length && arr[j]==-1){
27                arr[j] = num;
28                if(solve(i+1,n,arr,used))return true;
29                arr[j]=-1;
30                }
31            }
32            used[num]=false;
33            arr[i]=-1;
34        }
35        return false;
36    }
37}