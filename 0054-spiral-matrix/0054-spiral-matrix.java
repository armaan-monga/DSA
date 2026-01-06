class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans=new ArrayList<>();
        int row=matrix.length;
        int col=matrix[0].length;
        int top=0,bottom=row-1;
        int left=0,right=col-1;
        while(left<=right && top<=bottom){
            for(int j=left;j<=right;j++){
                ans.add(matrix[top][j]);
            }
                top++;
            
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
                right--;
            
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    ans.add(matrix[bottom][j]);
                }
                 bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    ans.add(matrix[i][left]);
                }
                    left++;
            }
        }
        return ans;
    }
}