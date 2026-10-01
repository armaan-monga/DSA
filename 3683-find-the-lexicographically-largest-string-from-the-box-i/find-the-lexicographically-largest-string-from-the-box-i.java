class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
           return word;
        }
        int n = word.length();
        int longest_possible = n - (numFriends - 1);
        String result = "";
        for(int i=0;i<n;i++){
            int possible_len = Math.min(longest_possible,n-i);
            String sub = word.substring(i,i+possible_len);
            if(result.compareTo(sub)<0){
                result = sub;
            }
        }
        return result;
    }
}