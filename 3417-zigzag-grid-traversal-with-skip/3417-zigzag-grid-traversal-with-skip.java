class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans=new ArrayList<>();
        boolean flagg=true;
        for(int i=0;i<grid.length;i++){
            if(i%2==0){
                for(int j=0;j<grid[0].length;j++){
                    if(flagg)ans.add(grid[i][j]);
                    flagg = !flagg;
                }
            }
            else{
                for(int j=grid[0].length-1;j>=0;j--){
                    if(flagg)ans.add(grid[i][j]);
                    flagg = !flagg;
                }
            }
        }
        return ans;
    }
}