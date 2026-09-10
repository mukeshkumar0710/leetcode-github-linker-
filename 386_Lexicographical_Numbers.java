class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;

        for (int i = 0; i < n; i++) {
            result.add(curr);

            // Try to go deeper (e.g., 1 -> 10)
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                // If we reach the end of a branch or hit the bound n, backtrack
                while (curr % 10 == 9 || curr >= n) {
                    curr /= 10;
                }
                // Move to the next sibling
                curr++;
            }
        }

        return result;
    }
}