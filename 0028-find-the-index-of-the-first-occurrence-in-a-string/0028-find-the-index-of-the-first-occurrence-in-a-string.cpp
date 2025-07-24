class Solution {
public:
    int strStr(string heystack, string needle) {
        int n=heystack.size(),m=needle.size();
        for(int i=0;i<=n-m;i++){
            int first=i,second=0;
            while(second<m){
                if(heystack[first]!=needle[second]){
                    break;
                }
                else{
                    first++;
                    second++;
                }
            }
            if(second==m){
                return first-second;
            }
        }return -1;
    }
};