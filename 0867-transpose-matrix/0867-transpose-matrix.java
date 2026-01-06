class Solution {
    public int[][] transpose(int[][] arr) {
       int rows=arr.length;
       int col=arr[0].length;
       int[][] ans=new int[col][rows];
       for(int i=0;i<rows;i++){
        for(int j=0;j<col;j++){
            ans[j][i]=arr[i][j];
        }
       }
       return ans;
    }
}