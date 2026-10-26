class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && !vis[i][j] && bfs(i,j,vis,grid)){
                    count++;
                }
            }
        }        
        return count;
    }
    public boolean bfs(int i,int j,boolean[][] vis,int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j]=true;
        boolean isClosed=true;
        int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int x=temp[0];
            int y=temp[1];
            for(int k=0;k<4;k++){
                int newr=x+dir[k][0];
                int newc=y+dir[k][1];
                if(newr<0 || newr>=n || newc<0 || newc>=m){
                    isClosed=false;
                }
                else if(grid[newr][newc]==0 && !vis[newr][newc]){
                    vis[newr][newc]=true;
                    q.add(new int[]{newr,newc});
                }
            }
        }
        return isClosed;
    }
}