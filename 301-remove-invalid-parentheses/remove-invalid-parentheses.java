class Solution {

    int minRemove = Integer.MAX_VALUE;
    Set<String> set = new HashSet<>();
    Set<String> visited = new HashSet<>();

    public boolean check(StringBuilder s) {

        int open = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } 
            else if (ch == ')') {

                open--;

                if (open < 0) {
                    return false;
                }
            }
        }

        return open == 0;
    }

    public List<String> removeInvalidParentheses(String s) {

        StringBuilder sb = new StringBuilder(s);

        solve(0, sb, 0);

        return new ArrayList<>(set);
    }

    public void solve(int i, StringBuilder sb, int removed) {

        if (removed > minRemove) {
            return;
        }

        String state = sb.toString() + "#" + i + "#" + removed;

        if (visited.contains(state)) {
            return;
        }

        visited.add(state);

        if (i == sb.length()) {

            if (check(sb)) {

                if (removed < minRemove) {
                    minRemove = removed;
                    set.clear();
                }

                if (removed == minRemove) {
                    set.add(sb.toString());
                }
            }

            return;
        }

        char ch = sb.charAt(i);

        // Remove
        if (ch == '(' || ch == ')') {

            sb.deleteCharAt(i);

            solve(i, sb, removed + 1);

            sb.insert(i, ch);
        }

        // Keep
        solve(i + 1, sb, removed);
    }
}