class Solution {
    int n;
    int m;
    int max=0;
    public int getMaximumGold(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    solve(i,j,grid,0);
                }
            }
        }
        return max;
    }
    public void solve(int i,int j,int[][] grid,int curr_gold){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0){
            return;
        }
        int temp = grid[i][j];
        curr_gold+=temp;
        max=Math.max(max,curr_gold);
        grid[i][j]=0;
        solve(i+1,j,grid,curr_gold);
        solve(i,j+1,grid,curr_gold);
        solve(i-1,j,grid,curr_gold);
        solve(i,j-1,grid,curr_gold);
        grid[i][j] = temp;
    }
}