1class Solution {
2    public int reachableNodes(int n, int[][] edges, int[] restricted) {
3        Set<Integer> set=new HashSet<>();
4        for(int i=0;i<restricted.length;i++){
5            set.add(restricted[i]);
6        }
7        List<List<Integer>> adj=new ArrayList<>();
8        for(int i=0;i<n;i++){
9            adj.add(new ArrayList<>());
10        }
11        for(int i=0;i<edges.length;i++){
12            int u=edges[i][0] , v=edges[i][1];
13            adj.get(u).add(v);
14            adj.get(v).add(u);
15        }
16        boolean[] vis=new boolean[n];
17        vis[0]=true;
18        Queue<Integer> q=new LinkedList<>();
19        q.add(0);
20        int ans=1;
21        while(q.size()>0){
22            int curr=q.remove();
23            for(int ele:adj.get(curr)){
24                if(!vis[ele] && !set.contains(ele)){
25                    q.add(ele);
26                    vis[ele]=true;
27                    ans++;
28                }
29            }
30        }
31        return ans;
32    }
33}