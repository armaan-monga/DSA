class Solution {
    public int convertTime(String current, String correct) {
        int curr = Integer.parseInt(current.substring(0, 2)) * 60
                 + Integer.parseInt(current.substring(3, 5));
        int cor = Integer.parseInt(correct.substring(0, 2)) * 60
                + Integer.parseInt(correct.substring(3, 5));
        int diff = cor - curr;
        int count = 0;
        int[] ops = {60, 15, 5, 1};
        for (int op : ops) {
            count += diff / op;
            diff %= op;
        }
        return count;
    }
}