class Solution {
    int result;
    int nonobscount;
    public int uniquePathsIII(int[][] grid) {
        result=0;
        int n=grid.length;
        int m=grid[0].length;
        nonobscount=0;
        int start_x=0;   
        int start_y=0;   
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    start_x=i;
                    start_y=j;
                    nonobscount++;
                }
                if(grid[i][j]==0)nonobscount++;
            }
        }
        backtrack(0,grid,start_x,start_y);
        return result;
    }

    public void backtrack(int count,int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
            return;
        }
        if(grid[i][j]==2){
            if(count==nonobscount){
                result++;
            }
            return;
        }
        grid[i][j]=-1;
        backtrack(count+1,grid,i+1,j);
        backtrack(count+1,grid,i,j+1);
        backtrack(count+1,grid,i-1,j);
        backtrack(count+1,grid,i,j-1);
        grid[i][j]=0;
    }
}