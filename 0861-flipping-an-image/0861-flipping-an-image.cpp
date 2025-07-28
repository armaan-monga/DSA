class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& a) {
      int rows=a.size();
      int col=a[0].size();
      for(int i=0;i<rows;i++){
        int start=0,end=col-1;
        while(start<end){
            swap(a[i][start],a[i][end]);
            start++;
            end--;

        }
        for(int j=0;j<col;j++){
            a[i][j]=1-a[i][j];
        }
      }return a;
    }
};