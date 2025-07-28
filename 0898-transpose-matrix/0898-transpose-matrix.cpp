class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& a) {
      int rows=a.size();
      int col=a[0].size();
      vector<vector<int>> result(col,vector<int>(rows));
      for(int i=0;i<rows;i++){
        for(int j=0;j<col;j++){
            result[j][i]=a[i][j];
        }
      } return result;
    }
};