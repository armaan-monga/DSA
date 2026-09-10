class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<restricted.length;i++){
            set.add(restricted[i]);
        }
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0] , v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        vis[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int ans=1;
        while(q.size()>0){
            int curr=q.remove();
            for(int ele:adj.get(curr)){
                if(!vis[ele] && !set.contains(ele)){
                    q.add(ele);
                    vis[ele]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
}