class Solution {
public:
    string longestCommonPrefix(vector<string>& str) {
        if (str.empty()) {
            return "";
        }
        if (str.size() == 1) {
            return str[0];
        }
        sort(str.begin(),str.end());
        string first=str[0] , last = str[str.size()-1];
        string ans;
        for(int i=0;i< min(first.length(),last.length());i++){
            if(first[i]!=last[i]){
                return ans;
            }
            else{
                ans+=first[i];
            }

        }
        return ans;
    }
};