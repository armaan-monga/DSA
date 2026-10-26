class Solution {
    int n;
    int m;
    public int countIslands(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !vis[i][j]){
                    if(bfs(i,j,vis,grid,k)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean bfs(int row,int col,boolean[][] vis,int[][] grid,int K){
        vis[row][col]=true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        long sum=0;
        sum+=grid[row][col];
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int i=temp[0];
            int j=temp[1];
            for(int k=0;k<4;k++){
                int newrow=i+dir[k][0];
                int newcol=j+dir[k][1];
                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && grid[newrow][newcol]!=0 && !vis[newrow][newcol]){
                    sum+=grid[newrow][newcol];
                    vis[newrow][newcol]=true;
                    q.add(new int[]{newrow,newcol});
                }
            }
        }
        return sum%K==0;
    }
}