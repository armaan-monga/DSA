class Solution {
    public int[][] transpose(int[][] a) {
      int rows=a.length;
      int col=a[0].length;
      int[][] result = new int[col][rows]; 
      for(int i=0;i<rows;i++){
        for(int j=0;j<col;j++){
            result[j][i]=a[i][j];
        }
      } return result;
    }
}