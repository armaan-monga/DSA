class Solution {
    public void rotate(int[][] m) {
        for(int i=0;i<m.length;i++){
            for(int j=0;j<i;j++){
                int temp=m[i][j];
                m[i][j]=m[j][i];
                m[j][i]=temp;
            }
        }
        for(int i=0;i<m.length;i++){
            int stcol=0;
            int endcol=m[0].length-1;
            while(stcol<endcol){
                int temp=m[i][stcol];
                m[i][stcol]=m[i][endcol];
                m[i][endcol]=temp;
                stcol++;
                endcol--;
            }
        }
    }
}