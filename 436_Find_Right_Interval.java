import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // starts[i][0] = start value, starts[i][1] = original index
        int[][] starts = new int[n][2];

        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }

        // Sort by start point ascending
        Arrays.sort(starts, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int low = 0;
            int high = n - 1;
            int rightIndex = -1;

            // Binary search for smallest start >= target
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (starts[mid][0] >= target) {
                    rightIndex = starts[mid][1];
                    high = mid - 1; // Try to find a smaller valid start
                } else {
                    low = mid + 1;
                }
            }

            result[i] = rightIndex;
        }

        return result;
    }
}