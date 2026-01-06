class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int row=arr.length;
        int col=arr[0].length;
        int toprow=0;
        int bottomrow=row-1;
        int leftcol=0;
        int rightcol=col-1;
        ArrayList<Integer> ans=new ArrayList<>();
        while(toprow<=bottomrow && leftcol<=rightcol){
            for(int j=leftcol;j<=rightcol;j++){
                ans.add(arr[toprow][j]);
            }
            toprow++;
            for(int i=toprow;i<=bottomrow;i++){
                ans.add(arr[i][rightcol]);
            }
            rightcol--;
            if(toprow<=bottomrow){
                for(int j=rightcol;j>=leftcol;j--){
                    ans.add(arr[bottomrow][j]);
                }
                bottomrow--;
            }
            if(leftcol<=rightcol){
                for(int i=bottomrow;i>=toprow;i--){
                    ans.add(arr[i][leftcol]);
                }
                leftcol++;
            }
        }
        return ans;
    }
}