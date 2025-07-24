class Solution {
public:
            void lpsfind(vector<int>&lps,string s){
                int pre=0,suf=1;
                while(suf<s.size()){
                    if(s[pre]==s[suf]){
                        lps[suf]=pre+1;
                        suf++,pre++;
                    }
                    else{
                        if(pre==0){
                            lps[suf]=0;
                            suf++;
                        }
                        else{
                            pre=lps[pre-1];
                        }
                    }
                }
            }

           int strStr(string heystack, string needle) {

            vector<int>lps(needle.size(),0);
            lpsfind(lps,needle);
            int first=0,second=0;
            while(first<heystack.size() && second<needle.size()){
                if(needle[second]==heystack[first]){
                    second++,first++;
                }else{
                    if(second==0) first++;
                    else second=lps[second-1];
                }
                }if(second==needle.size()){
                    return first-second;
            }return -1;
        // int n=heystack.size(),m=needle.size();
        // for(int i=0;i<=n-m;i++){
        //     int first=i,second=0;
        //     while(second<m){
        //         if(heystack[first]!=needle[second]){
        //             break;
        //         }
        //         else{
        //             first++;
        //             second++;
        //         }
        //     }
        //     if(second==m){
        //         return first-second;
        //     }
        // }return -1;
    }
};