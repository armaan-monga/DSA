class Solution {
    int n;
    int m;
    int[][][] dp = new int[101][101][201];
    public boolean hasValidPath(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if(grid[0][0]==')')return false;
        if((m + (n - 1)) % 2 != 0)return false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,grid,0);
    }
    public boolean solve(int i,int j,char[][] grid,int opencount){
        opencount += (grid[i][j]=='(') ? 1 : -1;
         
        if(opencount<0)return false;
        if(dp[i][j][opencount]!=-1)return dp[i][j][opencount]==1;
        if(i==n-1 && j==m-1){
            if(opencount==0){
                dp[i][j][opencount] = 1;
                return true;
            }
            else{
                dp[i][j][opencount]=0;
                return false;
            }
        }

        if(i + 1 < n){
            if(solve(i+1,j,grid,opencount)){
                dp[i][j][opencount]=1;
                return true;
            }
        }
        if(j + 1 < m){
            if(solve(i,j+1,grid,opencount)){
                dp[i][j][opencount]=1;
                return true;
            }
        }
        dp[i][j][opencount]=0;
        return false;
    }
}