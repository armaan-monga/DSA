1class Solution {
2    public int findCenter(int[][] edges) {
3        List<List<Integer>> adj=new ArrayList<>();
4        for(int i=0;i<=edges.length+1;i++){
5            adj.add(new ArrayList<>());
6        }
7        for(int i=0;i<edges.length;i++){
8            int u=edges[i][0],v=edges[i][1];
9            adj.get(u).add(v);
10            adj.get(v).add(u);
11        }
12        int i=0;
13        for(List<Integer> l : adj){
14            if(l.size()==edges.length)return i;
15            i++;
16        }
17        return -1;
18    }
19}