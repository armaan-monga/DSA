class Solution {
    public int numSpecial(int[][] mat) {
       int count=0;
       int row=mat.length;
       int col=mat[0].length;
       int[] rowarr=new int[row];
       int[] colarr=new int[col];
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(mat[i][j]==1){
                rowarr[i]++;
                colarr[j]++;
            }
        }
       }
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(mat[i][j]==1){
            if(rowarr[i]==1 && colarr[j]==1){
                count++;
            }
        }
        }
        }
        return count;
    }
}