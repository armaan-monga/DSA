class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        vector<string> result;
        string prevSorted = "";

        for (int i = 0; i < words.size(); i++) {
            string currSorted = words[i];
            sort(currSorted.begin(), currSorted.end());

            if (i == 0 || currSorted != prevSorted) {
                result.push_back(words[i]);
                prevSorted = currSorted;
            }
        }
        return result;
    }
};