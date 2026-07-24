class Solution {
    // Cache to store previously computed results so we don't repeat work
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p); // Start matching from index 0 of both strings
    }

    private boolean dfs(int i, int j, String s, String p) {
        // If we've already solved this exact sub-problem, return the saved answer
        if (memo[i][j] != null) return memo[i][j];

        // Base case: If pattern is exhausted, the string must also be exhausted to be a match
        if (j == p.length()) return i == s.length();

        // Check if the current characters match (or if the pattern has a wildcard '.')
        boolean firstMatch = (i < s.length() && 
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        boolean isMatching;
        
        // If the next character in the pattern is a '*', we have a choice
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Choice 1: Skip the '*' and its preceding character entirely (0 matches)
            // Choice 2: If the first characters matched, keep the '*' and move the string pointer forward (1+ matches)
            isMatching = dfs(i, j + 2, s, p) || (firstMatch && dfs(i + 1, j, s, p));
        } else {
            // Standard character match: move both pointers forward
            isMatching = firstMatch && dfs(i + 1, j + 1, s, p);
        }

        // Save the result to our cache and return
        memo[i][j] = isMatching;
        return isMatching;
    }
}