class Solution {
public:
    int mostWordsFound(vector<string>& sent) {
        int maxwords=0;
        for(string sentence : sent){
            int countspace=0;
            for(char c : sentence){
                if(c==' '){
                    countspace++;
                }
            }maxwords=max(maxwords,countspace+1);
        }return maxwords;
    }
};