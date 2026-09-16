1class Solution {
2    public int minimumOperations(int[] nums, int start, int goal) {
3        Queue<Integer> q=new LinkedList<>();
4        boolean[] vis =new boolean[1001];
5        q.add(start);
6        int steps=0;
7        while(q.size()>0){
8            int size=q.size();
9            for(int i=0;i<size;i++){
10                int x=q.poll();
11                if(x==goal)return steps;
12                for(int num:nums){
13                    int a=x+num;
14                    int b=x-num;
15                    int c=x^num;
16                    if(a==goal || b==goal || c==goal)return steps+1;
17                    if(a>=0 && a<=1000 && !vis[a]){
18                        vis[a]=true;
19                        q.add(a);
20                    }
21                    if(b>=0 && b<=1000 && !vis[b]){
22                        vis[b]=true;
23                        q.add(b);
24                    }
25                    if(c>=0 && c<=1000 && !vis[c]){
26                        vis[c]=true;
27                        q.add(c);
28                    }
29                }
30            }
31            steps++;
32        }
33        return -1;
34    }
35}