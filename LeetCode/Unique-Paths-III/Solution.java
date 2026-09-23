1class Solution {
2    int result;
3    int nonobscount;
4    public int uniquePathsIII(int[][] grid) {
5        result=0;
6        int n=grid.length;
7        int m=grid[0].length;
8        nonobscount=0;
9        int start_x=0;   
10        int start_y=0;   
11        for(int i=0;i<n;i++){
12            for(int j=0;j<m;j++){
13                if(grid[i][j]==1){
14                    start_x=i;
15                    start_y=j;
16                    nonobscount++;
17                }
18                if(grid[i][j]==0)nonobscount++;
19            }
20        }
21        backtrack(0,grid,start_x,start_y);
22        return result;
23    }
24
25    public void backtrack(int count,int[][] grid,int i,int j){
26        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1){
27            return;
28        }
29        if(grid[i][j]==2){
30            if(count==nonobscount){
31                result++;
32            }
33            return;
34        }
35        grid[i][j]=-1;
36        backtrack(count+1,grid,i+1,j);
37        backtrack(count+1,grid,i,j+1);
38        backtrack(count+1,grid,i-1,j);
39        backtrack(count+1,grid,i,j-1);
40        grid[i][j]=0;
41    }
42}