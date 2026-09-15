class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 1;
        }
        int left = 0;
        int prev = 0;
        int ans = 1;
        for (int right = 1; right < n; right++) {
            int curr;
            if (arr[right - 1] < arr[right]) {
                curr = 1;
            } else if (arr[right - 1] > arr[right]) {
                curr = -1;
            } else {
                curr = 0;
            }
            if (curr == 0) { left = right; } else if (curr == prev) { left = right - 1; }
            prev = curr;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}

