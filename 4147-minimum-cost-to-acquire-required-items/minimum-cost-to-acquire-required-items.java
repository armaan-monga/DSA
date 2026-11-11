
class Solution {
    public long minimumCost(int cost1, int cost2, int costboth,
                            int need1, int need2) {

        long small = Math.min(need1, need2);
        long big = Math.max(need1, need2);

        long ans1 = (long) cost1 * need1
                  + (long) cost2 * need2;

        long ans2 = small * costboth
                  + (long) cost1 * (need1 - small)
                  + (long) cost2 * (need2 - small);

        long ans3 = big * costboth;
        return Math.min(ans1, Math.min(ans2, ans3));
    }
}
