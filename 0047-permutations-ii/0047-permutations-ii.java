class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 0) return ans;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        backtrack(nums.length, ans, map, new ArrayList<>());
        return ans;
    }

    public void backtrack(int n,
                          List<List<Integer>> ans,
                          Map<Integer, Integer> map,
                          List<Integer> perm) {

        if (perm.size() == n) {
            ans.add(new ArrayList<>(perm));
            return;
        }

        for (int num : map.keySet()) {
            int count = map.get(num);
            if (count == 0) continue;

            perm.add(num);
            map.put(num, count - 1);

            backtrack(n, ans, map, perm);

            perm.remove(perm.size() - 1);
            map.put(num, count);
        }
    }
}