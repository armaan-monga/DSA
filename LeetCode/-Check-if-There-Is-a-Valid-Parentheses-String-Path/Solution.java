1class Solution {
2    int n;
3    int m;
4    int[][][] dp = new int[101][101][201];
5    public boolean hasValidPath(char[][] grid) {
6        n = grid.length;
7        m = grid[0].length;
8        if(grid[0][0]==')')return false;
9        if((m + (n - 1)) % 2 != 0)return false;
10        for(int i=0;i<n;i++){
11            for(int j=0;j<m;j++){
12                Arrays.fill(dp[i][j],-1);
13            }
14        }
15        return solve(0,0,grid,0);
16    }
17    public boolean solve(int i,int j,char[][] grid,int opencount){
18        opencount += (grid[i][j]=='(') ? 1 : -1;
19         
20        if(opencount<0)return false;
21        if(dp[i][j][opencount]!=-1)return dp[i][j][opencount]==1;
22        if(i==n-1 && j==m-1){
23            if(opencount==0){
24                dp[i][j][opencount] = 1;
25                return true;
26            }
27            else{
28                dp[i][j][opencount]=0;
29                return false;
30            }
31        }
32
33        if(i + 1 < n){
34            if(solve(i+1,j,grid,opencount)){
35                dp[i][j][opencount]=1;
36                return true;
37            }
38        }
39        if(j + 1 < m){
40            if(solve(i,j+1,grid,opencount)){
41                dp[i][j][opencount]=1;
42                return true;
43            }
44        }
45        dp[i][j][opencount]=0;
46        return false;
47    }
48}