class Solution {
    public int findCenter(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=edges.length+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int i=0;
        for(List<Integer> l : adj){
            if(l.size()==edges.length)return i;
            i++;
        }
        return -1;
    }
}